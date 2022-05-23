package com.maymar.filemngt.controller;

import com.maymar.filemngt.doa.FileUploadResponse;
import com.maymar.filemngt.entity.Attachment;
import com.maymar.filemngt.service.AttachmentService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.Optional;

@RestController
public class AttachmentController {

  private AttachmentService attachmentService;

  public AttachmentController(AttachmentService attachmentService){
    this.attachmentService = attachmentService;
  }

  @PostMapping("/upload")
  public ResponseEntity<FileUploadResponse> uploadFile(@RequestParam ("file") MultipartFile file) throws IOException {

    System.out.println("Inside controller");

    Attachment fileUploaded = attachmentService.saveAttachment(file);

    String fileDownloadUrl = ServletUriComponentsBuilder
        .fromCurrentContextPath()
        .path("/download/")
        .path(fileUploaded.getId())
        .toUriString();

    FileUploadResponse fileUploadResponse = new FileUploadResponse();
    fileUploadResponse.setFileName(file.getName());
    fileUploadResponse.setFileType(file.getContentType());
    fileUploadResponse.setSize(file.getSize());
    fileUploadResponse.setDownloadUrl(fileDownloadUrl);

    return new ResponseEntity<>(fileUploadResponse, HttpStatus.OK);
  }

  @GetMapping("/download/{id}")
  public ResponseEntity<byte[]> downloadFile(@PathVariable String id){

    Attachment downloadFile =  attachmentService.findAttachmentById(id).get();

    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\"" + downloadFile.getFileName() + "\"")
        .body(downloadFile.getFileData());
  }
}
