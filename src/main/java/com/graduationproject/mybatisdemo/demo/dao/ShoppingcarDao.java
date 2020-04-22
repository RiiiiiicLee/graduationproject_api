package com.graduationproject.mybatisdemo.demo.dao;

import com.graduationproject.mybatisdemo.demo.entity.Shoppingcar;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Shoppingcar)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-22 23:41:12
 */
@Mapper
public interface ShoppingcarDao {

    /**
     * 通过ID查询单条数据
     *
     * @param shoppingcarid 主键
     * @return 实例对象
     */
    Shoppingcar queryById(Integer shoppingcarid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Shoppingcar> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param shoppingcar 实例对象
     * @return 对象列表
     */
    List<Shoppingcar> queryAll(Shoppingcar shoppingcar);

    /**
     * 新增数据
     *
     * @param shoppingcar 实例对象
     * @return 影响行数
     */
    int insert(Shoppingcar shoppingcar);

    /**
     * 修改数据
     *
     * @param shoppingcar 实例对象
     * @return 影响行数
     */
    int update(Shoppingcar shoppingcar);

    /**
     * 通过主键删除数据
     *
     * @param shoppingcarid 主键
     * @return 影响行数
     */
    int deleteById(Integer shoppingcarid);

    List<Shoppingcar> list(String username);

    int add(String username, String goodsid, String goodsnum);
}