package com.graduationproject.mybatisdemo.demo.service.impl;

import com.graduationproject.mybatisdemo.demo.RequestDao.shoppingCartRequsetDao;
import com.graduationproject.mybatisdemo.demo.ResponseDao.shoppingCarResponseDao;
import com.graduationproject.mybatisdemo.demo.entity.Shoppingcar;
import com.graduationproject.mybatisdemo.demo.dao.ShoppingcarDao;
import com.graduationproject.mybatisdemo.demo.service.GoodsService;
import com.graduationproject.mybatisdemo.demo.service.ShoppingcarService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (Shoppingcar)表服务实现类
 *
 * @author makejava
 * @since 2020-04-22 23:41:12
 */
@Service("shoppingcarService")
public class ShoppingcarServiceImpl implements ShoppingcarService {
    @Resource
    private ShoppingcarDao shoppingcarDao;

    @Resource
    private GoodsService goodsService;

    /**
     * 通过ID查询单条数据
     *
     * @param shoppingcarid 主键
     * @return 实例对象
     */
    @Override
    public Shoppingcar queryById(Integer shoppingcarid) {
        return this.shoppingcarDao.queryById(shoppingcarid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Shoppingcar> queryAllByLimit(int offset, int limit) {
        return this.shoppingcarDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param shoppingcar 实例对象
     * @return 实例对象
     */
    @Override
    public Shoppingcar insert(Shoppingcar shoppingcar) {
        this.shoppingcarDao.insert(shoppingcar);
        return shoppingcar;
    }

    /**
     * 修改数据
     *
     * @param shoppingcar 实例对象
     * @return 实例对象
     */
    @Override
    public Shoppingcar update(Shoppingcar shoppingcar) {
        this.shoppingcarDao.update(shoppingcar);
        return this.queryById(shoppingcar.getShoppingcarid());
    }

    /**
     * 通过主键删除数据
     *
     * @param shoppingcarid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer shoppingcarid) {
        return this.shoppingcarDao.deleteById(shoppingcarid) > 0;
    }

    @Override
    public List<shoppingCarResponseDao> list(String username) {
        List<shoppingCarResponseDao> responseList = new ArrayList<>();
        List<Shoppingcar> listdata = this.shoppingcarDao.list(username);
        for (Shoppingcar shoppingcar : listdata
        ) {
            shoppingCarResponseDao shoppingCarResponseDao = new shoppingCarResponseDao();
            shoppingCarResponseDao.setShoppingcarid(shoppingcar.getShoppingcarid());
            shoppingCarResponseDao.setUserid(shoppingcar.getUserid());
            shoppingCarResponseDao.setGoodsnum(shoppingcar.getGoodsnum());
            Integer goodsId;
            goodsId = shoppingcar.getGoodsid();
            shoppingCarResponseDao.setGoodsid(goodsId);
            shoppingCarResponseDao.setGoodsname(this.goodsService.queryById(goodsId).getGoodsname());
            shoppingCarResponseDao.setGoodsprice(this.goodsService.queryById(goodsId).getGoodsprice());
            shoppingCarResponseDao.setSponsor(this.goodsService.queryById(goodsId).getSponsor());
            shoppingCarResponseDao.setSupplier(this.goodsService.queryById(goodsId).getSupplier());
            shoppingCarResponseDao.setDistributor(this.goodsService.queryById(goodsId).getDistributor());
            shoppingCarResponseDao.setGoodsinfo(this.goodsService.queryById(goodsId).getGoodsinfo());
            shoppingCarResponseDao.setGoodsimg(this.goodsService.queryById(goodsId).getGoodsimg());
            shoppingCarResponseDao.setDiscount(this.goodsService.queryById(goodsId).getDiscount());
            shoppingCarResponseDao.setIsdeleted(shoppingcar.getIsdeleted());
            shoppingCarResponseDao.setIslocked(shoppingcar.getIslocked());
            shoppingCarResponseDao.setCreatetime(shoppingcar.getCreatetime());
            responseList.add(shoppingCarResponseDao);
        }
        return responseList;
    }

    @Override
    public int add(String username, shoppingCartRequsetDao shoppingCartRequsetDao) {
        List<Shoppingcar> listdata = this.shoppingcarDao.checkShoppingCartAlreadyExist(username,shoppingCartRequsetDao.getGoodsid());
        if(!listdata.isEmpty()){
            for (Shoppingcar shoppingcar:listdata
                 ) {
                shoppingcar.setGoodsnum(shoppingcar.getGoodsnum()+Integer.parseInt(shoppingCartRequsetDao.getGoodsnum()));
                if(this.shoppingcarDao.update(shoppingcar)==1){
                    return 10;
                }
            }
        }
        return this.shoppingcarDao.add(username, shoppingCartRequsetDao.getGoodsid(), shoppingCartRequsetDao.getGoodsnum());
    }

    @Override
    public int deleteByShoppingcarid(String shoppingcarid){
        Integer shoppingcarId=Integer.parseInt(shoppingcarid);
        if(this.shoppingcarDao.queryById(shoppingcarId)==null){
            return 10;
        }
        return this.shoppingcarDao.deleteById(shoppingcarId);
    }

    @Override
    public int edit(Shoppingcar shoppingcar){
        return this.shoppingcarDao.update(shoppingcar);
    }
}