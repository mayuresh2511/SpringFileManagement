package com.maymar.filemngt.service;

import com.maymar.filemngt.entity.Attachment;
import com.maymar.filemngt.repository.AttachmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class AttachmentSeviceImpl implements AttachmentService{

  private AttachmentRepository attachmentRepository;

  public AttachmentSeviceImpl(AttachmentRepository attachmentRepository){
    this.attachmentRepository = attachmentRepository;
  }
  @Override
  public Attachment saveAttachment(MultipartFile file) throws IOException {

    String fileName = StringUtils.cleanPath(file.getName());

    Attachment attachment= new Attachment(fileName, file.getContentType(), file.getBytes());

    return attachmentRepository.save(attachment);
  }

  @Override
  public Optional<Attachment> findAttachmentById(String id) {
    return attachmentRepository.findById(id);
  }
}
