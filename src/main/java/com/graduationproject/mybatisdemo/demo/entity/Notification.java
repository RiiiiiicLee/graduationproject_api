package com.graduationproject.mybatisdemo.demo.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Notification)实体类
 *
 * @author makejava
 * @since 2020-04-24 04:08:12
 */
public class Notification implements Serializable {
    private static final long serialVersionUID = -97247009161461793L;
    
    private Integer notificationid;
    
    private String notiname;
    
    private String noticontent;
    
    private String notiimgurl;
    
    private String notiimgname;
    
    private Integer isdeleted;
    
    private Date createtime;


    public Integer getNotificationid() {
        return notificationid;
    }

    public void setNotificationid(Integer notificationid) {
        this.notificationid = notificationid;
    }

    public String getNotiname() {
        return notiname;
    }

    public void setNotiname(String notiname) {
        this.notiname = notiname;
    }

    public String getNoticontent() {
        return noticontent;
    }

    public void setNoticontent(String noticontent) {
        this.noticontent = noticontent;
    }

    public String getNotiimgurl() {
        return notiimgurl;
    }

    public void setNotiimgurl(String notiimgurl) {
        this.notiimgurl = notiimgurl;
    }

    public String getNotiimgname() {
        return notiimgname;
    }

    public void setNotiimgname(String notiimgname) {
        this.notiimgname = notiimgname;
    }

    public Integer getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Integer isdeleted) {
        this.isdeleted = isdeleted;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

}