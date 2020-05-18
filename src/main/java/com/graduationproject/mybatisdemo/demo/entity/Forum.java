package com.graduationproject.mybatisdemo.demo.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Forum)实体类
 *
 * @author makejava
 * @since 2020-05-15 16:51:24
 */
public class Forum implements Serializable {
    private static final long serialVersionUID = -86403104637996856L;
    
    private Integer forumid;
    
    private Integer forumorderid;
    
    private Integer forumfloorid;
    
    private String username;
    
    private String avatar;
    
    private String content;
    
    private Integer likes;
    
    private Integer dislikes;
    
    private Integer islocked;
    
    private Integer isdeleted;
    
    private Date createtime;


    public Integer getForumid() {
        return forumid;
    }

    public void setForumid(Integer forumid) {
        this.forumid = forumid;
    }

    public Integer getForumorderid() {
        return forumorderid;
    }

    public void setForumorderid(Integer forumorderid) {
        this.forumorderid = forumorderid;
    }

    public Integer getForumfloorid() {
        return forumfloorid;
    }

    public void setForumfloorid(Integer forumfloorid) {
        this.forumfloorid = forumfloorid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getDislikes() {
        return dislikes;
    }

    public void setDislikes(Integer dislikes) {
        this.dislikes = dislikes;
    }

    public Integer getIslocked() {
        return islocked;
    }

    public void setIslocked(Integer islocked) {
        this.islocked = islocked;
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