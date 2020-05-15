package com.graduationproject.mybatisdemo.demo.dao;

import com.graduationproject.mybatisdemo.demo.entity.Goods;
import com.graduationproject.mybatisdemo.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Goods)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-22 03:10:26
 */
@Mapper
public interface GoodsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param goodsid 主键
     * @return 实例对象
     */
    Goods queryById(Integer goodsid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Goods> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param goods 实例对象
     * @return 对象列表
     */
    List<Goods> queryAll(Goods goods);

    /**
     * 新增数据
     *
     * @param goods 实例对象
     * @return 影响行数
     */
    int insert(Goods goods);

    /**
     * 修改数据
     *
     * @param goods 实例对象
     * @return 影响行数
     */
    int update(Goods goods);

    /**
     * 通过主键删除数据
     *
     * @param goodsid 主键
     * @return 影响行数
     */
    int deleteById(Integer goodsid);

    List<Goods> list();

    List<Goods> search(String search);
}