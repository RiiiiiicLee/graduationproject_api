package com.graduationproject.mybatisdemo.demo.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Salesrecord)实体类
 *
 * @author makejava
 * @since 2020-04-24 04:29:11
 */
public class Salesrecord implements Serializable {
    private static final long serialVersionUID = 471630617555423666L;
    
    private Integer salesrecordid;
    
    private Integer orderid;
    
    private Integer userid;
    
    private Integer goodsid;
    
    private Integer goodsnum;
    
    private String addressinfo;
    
    private String addressname;
    
    private String tel;
    
    private Integer isdeleted;
    
    private Date createtime;


    public Integer getSalesrecordid() {
        return salesrecordid;
    }

    public void setSalesrecordid(Integer salesrecordid) {
        this.salesrecordid = salesrecordid;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
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

    public String getAddressinfo() {
        return addressinfo;
    }

    public void setAddressinfo(String addressinfo) {
        this.addressinfo = addressinfo;
    }

    public String getAddressname() {
        return addressname;
    }

    public void setAddressname(String addressname) {
        this.addressname = addressname;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
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