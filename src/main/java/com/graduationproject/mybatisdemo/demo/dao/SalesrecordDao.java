package com.graduationproject.mybatisdemo.demo.dao;

import com.graduationproject.mybatisdemo.demo.entity.Salesrecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Salesrecord)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-24 04:29:11
 */
@Mapper
public interface SalesrecordDao {

    /**
     * 通过ID查询单条数据
     *
     * @param salesrecordid 主键
     * @return 实例对象
     */
    Salesrecord queryById(Integer salesrecordid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Salesrecord> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param salesrecord 实例对象
     * @return 对象列表
     */
    List<Salesrecord> queryAll(Salesrecord salesrecord);

    /**
     * 新增数据
     *
     * @param salesrecord 实例对象
     * @return 影响行数
     */
    int insert(Salesrecord salesrecord);

    /**
     * 修改数据
     *
     * @param salesrecord 实例对象
     * @return 影响行数
     */
    int update(Salesrecord salesrecord);

    /**
     * 通过主键删除数据
     *
     * @param salesrecordid 主键
     * @return 影响行数
     */
    int deleteById(Integer salesrecordid);

    List<Salesrecord> list(String username);
}