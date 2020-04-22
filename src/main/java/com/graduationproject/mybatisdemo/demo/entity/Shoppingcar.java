package com.graduationproject.mybatisdemo.demo.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Shoppingcar)实体类
 *
 * @author makejava
 * @since 2020-04-22 23:41:12
 */
public class Shoppingcar implements Serializable {
    private static final long serialVersionUID = -64396077386709791L;
    
    private Integer shoppingcarid;
    
    private Integer userid;
    
    private Integer goodsid;
    
    private Integer goodsnum;
    
    private Integer isdeleted;
    
    private Integer islocked;
    
    private Date createtime;


    public Integer getShoppingcarid() {
        return shoppingcarid;
    }

    public void setShoppingcarid(Integer shoppingcarid) {
        this.shoppingcarid = shoppingcarid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    public Integer getGoodsnum() {
        return goodsnum;
    }

    public void setGoodsnum(Integer goodsnum) {
        this.goodsnum = goodsnum;
    }

    public Integer getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Integer isdeleted) {
        this.isdeleted = isdeleted;
    }

    public Integer getIslocked() {
        return islocked;
    }

    public void setIslocked(Integer islocked) {
        this.islocked = islocked;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

}