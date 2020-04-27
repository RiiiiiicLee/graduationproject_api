package com.graduationproject.mybatisdemo.demo.service.impl;

import com.graduationproject.mybatisdemo.demo.RequestDao.salesRecordDeleteRequestDao;
import com.graduationproject.mybatisdemo.demo.RequestDao.salesRecordRequestDao;
import com.graduationproject.mybatisdemo.demo.ResponseDao.salesrecordResponseDao;
import com.graduationproject.mybatisdemo.demo.ResponseDao.shoppingCarResponseDao;
import com.graduationproject.mybatisdemo.demo.dao.ShoppingcarDao;
import com.graduationproject.mybatisdemo.demo.entity.Address;
import com.graduationproject.mybatisdemo.demo.entity.Salesrecord;
import com.graduationproject.mybatisdemo.demo.dao.SalesrecordDao;
import com.graduationproject.mybatisdemo.demo.entity.Shoppingcar;
import com.graduationproject.mybatisdemo.demo.entity.User;
import com.graduationproject.mybatisdemo.demo.service.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (Salesrecord)表服务实现类
 *
 * @author makejava
 * @since 2020-04-24 04:29:11
 */
@Service("salesrecordService")
public class SalesrecordServiceImpl implements SalesrecordService {
    @Resource
    private SalesrecordDao salesrecordDao;

    @Resource
    private GoodsService goodsService;

    @Resource
    private ShoppingcarDao shoppingcarDao;

    @Resource
    private AddressService addressService;

    @Resource
    private UserService userService;

    /**
     * 通过ID查询单条数据
     *
     * @param salesrecordid 主键
     * @return 实例对象
     */
    @Override
    public Salesrecord queryById(Integer salesrecordid) {
        return this.salesrecordDao.queryById(salesrecordid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Salesrecord> queryAllByLimit(int offset, int limit) {
        return this.salesrecordDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param salesrecord 实例对象
     * @return 实例对象
     */
    @Override
    public Salesrecord insert(Salesrecord salesrecord) {
        this.salesrecordDao.insert(salesrecord);
        return salesrecord;
    }

    /**
     * 修改数据
     *
     * @param salesrecord 实例对象
     * @return 实例对象
     */
    @Override
    public Salesrecord update(Salesrecord salesrecord) {
        this.salesrecordDao.update(salesrecord);
        return this.queryById(salesrecord.getSalesrecordid());
    }

    /**
     * 通过主键删除数据
     *
     * @param salesrecordid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer salesrecordid) {
        return this.salesrecordDao.deleteById(salesrecordid) > 0;
    }

    @Override
    public List<salesrecordResponseDao> list(String username){
        List<salesrecordResponseDao> responseList = new ArrayList<>();
        List<Salesrecord> listdata = this.salesrecordDao.list(username);
        int orderid = 0;
        for (Salesrecord salesrecord : listdata
        ) {
            salesrecordResponseDao salesrecordResponseDao = new salesrecordResponseDao();
            salesrecordResponseDao.setSalesrecordid(salesrecord.getSalesrecordid());
            if(orderid != salesrecord.getOrderid()) {
                salesrecordResponseDao.setOrderid(salesrecord.getOrderid());
                orderid=salesrecord.getOrderid();
            }else{
                salesrecordResponseDao.setOrderid(0);
            }
            salesrecordResponseDao.setUserid(salesrecord.getUserid());
            Integer goodsId;
            goodsId=salesrecord.getGoodsid();
            salesrecordResponseDao.setGoodsid(goodsId);
            salesrecordResponseDao.setGoodsname(this.goodsService.queryById(goodsId).getGoodsname());
            salesrecordResponseDao.setGoodsprice(this.goodsService.queryById(goodsId).getGoodsprice());
            salesrecordResponseDao.setSponsor(this.goodsService.queryById(goodsId).getSponsor());
            salesrecordResponseDao.setSupplier(this.goodsService.queryById(goodsId).getSupplier());
            salesrecordResponseDao.setDistributor(this.goodsService.queryById(goodsId).getDistributor());
            salesrecordResponseDao.setGoodsinfo(this.goodsService.queryById(goodsId).getGoodsinfo());
            salesrecordResponseDao.setGoodsimg(this.goodsService.queryById(goodsId).getGoodsimg());
            salesrecordResponseDao.setDiscount(this.goodsService.queryById(goodsId).getDiscount());
            salesrecordResponseDao.setGoodsnum(salesrecord.getGoodsnum());
            salesrecordResponseDao.setAddressinfo(salesrecord.getAddressinfo());
            salesrecordResponseDao.setAddressname(salesrecord.getAddressinfo());
            salesrecordResponseDao.setTel(salesrecord.getTel());
            salesrecordResponseDao.setIsdeleted(salesrecord.getIsdeleted());
            salesrecordResponseDao.setCreatetime(salesrecord.getCreatetime());
            responseList.add(salesrecordResponseDao);
        }
        return responseList;
    }

    @Override
    public List<salesrecordResponseDao> showlist(String username, Integer orderId){
        List<salesrecordResponseDao> responseList = new ArrayList<>();
        List<Salesrecord> listdata = this.salesrecordDao.showlist(username,orderId);
        int orderid = 0;
        for (Salesrecord salesrecord : listdata
        ) {
            salesrecordResponseDao salesrecordResponseDao = new salesrecordResponseDao();
            salesrecordResponseDao.setSalesrecordid(salesrecord.getSalesrecordid());
            if(orderid != salesrecord.getOrderid()) {
                salesrecordResponseDao.setOrderid(salesrecord.getOrderid());
                orderid=salesrecord.getOrderid();
            }else{
                salesrecordResponseDao.setOrderid(0);
            }
            salesrecordResponseDao.setUserid(salesrecord.getUserid());
            Integer goodsId;
            goodsId=salesrecord.getGoodsid();
            salesrecordResponseDao.setGoodsid(goodsId);
            salesrecordResponseDao.setGoodsname(this.goodsService.queryById(goodsId).getGoodsname());
            salesrecordResponseDao.setGoodsprice(this.goodsService.queryById(goodsId).getGoodsprice());
            salesrecordResponseDao.setSponsor(this.goodsService.queryById(goodsId).getSponsor());
            salesrecordResponseDao.setSupplier(this.goodsService.queryById(goodsId).getSupplier());
            salesrecordResponseDao.setDistributor(this.goodsService.queryById(goodsId).getDistributor());
            salesrecordResponseDao.setGoodsinfo(this.goodsService.queryById(goodsId).getGoodsinfo());
            salesrecordResponseDao.setGoodsimg(this.goodsService.queryById(goodsId).getGoodsimg());
            salesrecordResponseDao.setDiscount(this.goodsService.queryById(goodsId).getDiscount());
            salesrecordResponseDao.setGoodsnum(salesrecord.getGoodsnum());
            salesrecordResponseDao.setAddressinfo(salesrecord.getAddressinfo());
            salesrecordResponseDao.setAddressname(salesrecord.getAddressinfo());
            salesrecordResponseDao.setTel(salesrecord.getTel());
            salesrecordResponseDao.setIsdeleted(salesrecord.getIsdeleted());
            salesrecordResponseDao.setCreatetime(salesrecord.getCreatetime());
            responseList.add(salesrecordResponseDao);
        }
        return responseList;
    }

    @Override
    public int confirmOrder(String username, String addressId){
        List<Shoppingcar> shoppingrecord=this.shoppingcarDao.list(username);
        Address address = this.addressService.queryById(Integer.parseInt(addressId));
        User user= this.userService.selectUser(username);
        int orderid=0;
        if(this.salesrecordDao.getOrderId(username)==null){
            orderid=1;
        }else {
            orderid=this.salesrecordDao.getOrderId(username)+1;
        }
        int confirmOrder=0;
        if(shoppingrecord==null || address == null){
            return 0;
        }
        for (Shoppingcar shoppingcar:shoppingrecord) {
            Salesrecord salesrecord=new Salesrecord();
            salesrecord.setAddressinfo(address.getAddressinfo());
            salesrecord.setAddressname(address.getAddressname());
            salesrecord.setTel(address.getTel());
            salesrecord.setUserid(user.getUserid());
            salesrecord.setOrderid(orderid);
            salesrecord.setGoodsid(shoppingcar.getGoodsid());
            salesrecord.setGoodsnum(shoppingcar.getGoodsnum());
            confirmOrder=confirmOrder + this.salesrecordDao.insert(salesrecord);
            this.shoppingcarDao.deleteById(shoppingcar.getShoppingcarid());
        }
        return confirmOrder;
    }

    @Override
    public List<Salesrecord> all(){
        return this.salesrecordDao.all();
    }

    @Override
    public int userdelete(String username, String orderId){
        return this.salesrecordDao.userdelete(username,orderId);
    }

    @Override
    public int editAddress(salesRecordRequestDao salesRecordRequestDao){
        return this.salesrecordDao.editAddress(salesRecordRequestDao);
    }

    @Override
    public int adminDelete(salesRecordDeleteRequestDao salesRecordDeleteRequestDao){
        return this.salesrecordDao.admindelete(salesRecordDeleteRequestDao.getUserid(),
                salesRecordDeleteRequestDao.getOrderid(),salesRecordDeleteRequestDao.getIsdeleted());
    }
}