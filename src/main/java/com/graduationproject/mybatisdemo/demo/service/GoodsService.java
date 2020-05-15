package com.graduationproject.mybatisdemo.demo.service;

import com.graduationproject.mybatisdemo.demo.entity.Goods;
import com.graduationproject.mybatisdemo.demo.entity.User;

import java.util.List;

/**
 * (Goods)表服务接口
 *
 * @author makejava
 * @since 2020-04-22 03:10:26
 */
public interface GoodsService {

    /**
     * 通过ID查询单条数据
     *
     * @param goodsid 主键
     * @return 实例对象
     */
    Goods queryById(Integer goodsid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Goods> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param goods 实例对象
     * @return 实例对象
     */
    Goods insert(Goods goods);

    /**
     * 修改数据
     *
     * @param goods 实例对象
     * @return 实例对象
     */
    Goods update(Goods goods);

    /**
     * 通过主键删除数据
     *
     * @param goodsid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer goodsid);

    List<Goods> list();

    List<Goods> search(String search);
}