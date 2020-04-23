package com.graduationproject.mybatisdemo.demo.service;

import com.graduationproject.mybatisdemo.demo.RequestDao.shoppingCartRequsetDao;
import com.graduationproject.mybatisdemo.demo.ResponseDao.shoppingCarResponseDao;
import com.graduationproject.mybatisdemo.demo.entity.Shoppingcar;
import java.util.List;

/**
 * (Shoppingcar)表服务接口
 *
 * @author makejava
 * @since 2020-04-22 23:41:12
 */
public interface ShoppingcarService {

    /**
     * 通过ID查询单条数据
     *
     * @param shoppingcarid 主键
     * @return 实例对象
     */
    Shoppingcar queryById(Integer shoppingcarid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Shoppingcar> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param shoppingcar 实例对象
     * @return 实例对象
     */
    Shoppingcar insert(Shoppingcar shoppingcar);

    /**
     * 修改数据
     *
     * @param shoppingcar 实例对象
     * @return 实例对象
     */
    Shoppingcar update(Shoppingcar shoppingcar);

    /**
     * 通过主键删除数据
     *
     * @param shoppingcarid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer shoppingcarid);

    List<shoppingCarResponseDao> list(String username);

    int add(String username, shoppingCartRequsetDao shoppingCartRequsetDao);

    int deleteByShoppingcarid(String shoppingcarid);

}