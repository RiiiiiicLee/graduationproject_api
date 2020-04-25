package com.graduationproject.mybatisdemo.demo.service.impl;

import com.graduationproject.mybatisdemo.demo.ResponseDao.salesrecordResponseDao;
import com.graduationproject.mybatisdemo.demo.ResponseDao.shoppingCarResponseDao;
import com.graduationproject.mybatisdemo.demo.entity.Salesrecord;
import com.graduationproject.mybatisdemo.demo.dao.SalesrecordDao;
import com.graduationproject.mybatisdemo.demo.entity.Shoppingcar;
import com.graduationproject.mybatisdemo.demo.service.GoodsService;
import com.graduationproject.mybatisdemo.demo.service.SalesrecordService;
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
        for (Salesrecord salesrecord : listdata
        ) {
            salesrecordResponseDao salesrecordResponseDao = new salesrecordResponseDao();
            salesrecordResponseDao.setSalesrecordid(salesrecord.getSalesrecordid());
            salesrecordResponseDao.setOrderid(salesrecord.getOrderid());
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
}