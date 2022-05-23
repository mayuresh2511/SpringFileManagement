package com.maymar.filemngt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
@Data@NoArgsConstructor
@AllArgsConstructor
public class Attachment {

  @Id
  @GeneratedValue(generator =  "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  private String Id;

  private String FileName;

  private String FileType;

  @Lob
  private byte[] fileData;

  public Attachment(String fileName, String contentType, byte[] bytes) {
    this.FileName = fileName;
    this.FileType = contentType;
    this.fileData = bytes;
  }
}
