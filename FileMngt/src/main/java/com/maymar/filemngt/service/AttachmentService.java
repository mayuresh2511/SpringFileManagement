package com.maymar.filemngt.service;

import com.maymar.filemngt.entity.Attachment;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

public interface AttachmentService {

  public Attachment saveAttachment(MultipartFile file) throws IOException;

  public Optional<Attachment> findAttachmentById(String id);
}
