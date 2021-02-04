package com.liusu.domain.server.bo;

import com.hbmss.framework.model.BaseModel;

/**
 * 消息中所携带的图片或表情。
 * 
 * @author LiuSu
 * @since 2021.01.26
 */
public class ListenerPictureBO extends BaseModel {

  private static final long serialVersionUID = -987793248664068580L;

  private String path;

  /** 图片地址 */
  private String url;

  private Long fileID;

  /** 文件大小(字节) */
  private Long fileSize;

  /** 文件MD5(字节) */
  private String fileMD5;

  private String forwordBuf;

  private String forwordField;

  /**
   * 这个构造方法一般用于好友发过来的图片消息
   *
   * @param path 原图URL
   * @param url 未知作用（似乎是图片文件的本地保存路径
   * @param fileSize 文件大小
   * @param fileMD5 文件MD5
   */
  public ListenerPictureBO(String path, String url, Long fileSize, String fileMD5) {
    this.path = path;
    this.url = url;
    this.fileSize = fileSize;
    this.fileMD5 = fileMD5;
  }

  /**
   * 这个构造方法一般用于大表情
   *
   * @param forwordBuf 缩略图的Base64编码值
   * @param forwordField 未知作用
   */
  public ListenerPictureBO(String forwordBuf, String forwordField) {
    this.forwordBuf = forwordBuf;
    this.forwordField = forwordField;
  }

  /**
   * 这个构造方法一般用于群的图片消息
   *
   * @param url 原图URL
   * @param fileID 图片ID
   * @param fileSize 图片大小
   * @param fileMD5 图片的MD5
   * @param forwordBuf 缩略图的Base64编码值
   * @param forwordField 未知作用
   */
  public ListenerPictureBO(String url, Long fileID, Long fileSize, String fileMD5, String forwordBuf,
      String forwordField) {
    this.url = url;
    this.fileID = fileID;
    this.fileSize = fileSize;
    this.fileMD5 = fileMD5;
    this.forwordBuf = forwordBuf;
    this.forwordField = forwordField;
  }

  public String getPath() {
    return path;
  }

  public String getUrl() {
    return url;
  }

  public Long getFileID() {
    return fileID;
  }

  public void setPath(String path) {

    this.path = path;
  }

  public void setUrl(String url) {

    this.url = url;
  }

  public void setFileID(Long fileID) {

    this.fileID = fileID;
  }

  public void setFileSize(Long fileSize) {

    this.fileSize = fileSize;
  }

  public void setFileMD5(String fileMD5) {

    this.fileMD5 = fileMD5;
  }

  public void setForwordBuf(String forwordBuf) {

    this.forwordBuf = forwordBuf;
  }

  public void setForwordField(String forwordField) {

    this.forwordField = forwordField;
  }

  public Long getFileSize() {
    return fileSize;
  }

  public String getFileMD5() {
    return fileMD5;
  }

  public String getForwordBuf() {
    return forwordBuf;
  }

  public String getForwordField() {
    return forwordField;
  }

  @Override
  public String toString() {
    return "ListenerPictureBO [path=" + path + ", url=" + url + ", fileID=" + fileID + ", fileSize=" + fileSize
        + ", fileMD5=" + fileMD5 + ", forwordBuf=" + forwordBuf + ", forwordField=" + forwordField + "]";
  }

}
