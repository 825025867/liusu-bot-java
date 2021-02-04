
/*
* $Id:$
* Copyright 2021 LiuSu.com All rights reserved.
*/

package com.liusu.domain.server.bo;

import com.hbmss.framework.model.BaseModel;

/**
 * 视频消息
 * 
 * @author LiuSu
 * @since 2021.01.28
 */

public class ListenerVideoBO extends BaseModel {

  private static final long serialVersionUID = 448124619656562760L;

  /** 视频地址 */
  private String VideoUrl;

  /** 视频大小(字节) */
  private Long VideoSize;

  /** 视频MD5(字节) */
  private String VideoMd5;

  private String forwordBuf;

  private Long forwordField;

  public ListenerVideoBO() {
    super();
  }

  public ListenerVideoBO(String videoUrl, Long videoSize, String videoMd5, String forwordBuf, Long forwordField) {
    super();
    VideoUrl = videoUrl;
    VideoSize = videoSize;
    VideoMd5 = videoMd5;
    this.forwordBuf = forwordBuf;
    this.forwordField = forwordField;
  }

  @Override
  public String toString() {
    return "ListenerVideoBO [VideoUrl=" + VideoUrl + ", VideoSize=" + VideoSize + ", VideoMd5=" + VideoMd5
        + ", forwordBuf=" + forwordBuf + ", forwordField=" + forwordField + "]";
  }

  public String getVideoUrl() {

    return VideoUrl;
  }

  public void setVideoUrl(String videoUrl) {

    VideoUrl = videoUrl;
  }

  public Long getVideoSize() {

    return VideoSize;
  }

  public void setVideoSize(Long videoSize) {

    VideoSize = videoSize;
  }

  public String getVideoMd5() {

    return VideoMd5;
  }

  public void setVideoMd5(String videoMd5) {

    VideoMd5 = videoMd5;
  }

  public String getForwordBuf() {

    return forwordBuf;
  }

  public void setForwordBuf(String forwordBuf) {

    this.forwordBuf = forwordBuf;
  }

  public Long getForwordField() {

    return forwordField;
  }

  public void setForwordField(Long forwordField) {

    this.forwordField = forwordField;
  }

}
