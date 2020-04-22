package com.graduationproject.mybatisdemo.demo.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Address)实体类
 *
 * @author makejava
 * @since 2020-04-23 01:36:18
 */
public class Address implements Serializable {
    private static final long serialVersionUID = -44017075129397327L;
    
    private Integer addressid;
    
    private Integer userid;
    
    private String addressinfo;
    
    private String addressname;
    
    private String tel;
    
    private Integer isdeleted;
    
    private Date createtime;


    public Integer getAddressid() {
        return addressid;
    }

    public void setAddressid(Integer addressid) {
        this.addressid = addressid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
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