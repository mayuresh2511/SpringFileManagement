package com.maymar.filemngt.doa;

public class FileUploadResponse {

  private String fileName;
  private String fileType;
  private String downloadUrl;
  private long size;

  public FileUploadResponse(){}

  public FileUploadResponse(String fileName, String fileType, String downloadUrl, long size) {
    this.fileName = fileName;
    this.fileType = fileType;
    this.downloadUrl = downloadUrl;
    this.size = size;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public String getFileType() {
    return fileType;
  }

  public String getDownloadUrl() {
    return downloadUrl;
  }

  public long getSize() {
    return size;
  }

  public void setFileType(String fileType) {
    this.fileType = fileType;
  }

  public void setDownloadUrl(String downloadUrl) {
    this.downloadUrl = downloadUrl;
  }

  public void setSize(long size) {
    this.size = size;
  }
}
