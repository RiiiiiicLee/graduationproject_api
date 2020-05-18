package com.graduationproject.mybatisdemo.demo.dao;

import com.graduationproject.mybatisdemo.demo.entity.Forum;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Forum)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-15 16:51:24
 */
@Mapper
public interface ForumDao {

    /**
     * 通过ID查询单条数据
     *
     * @param forumid 主键
     * @return 实例对象
     */
    Forum queryById(Integer forumid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Forum> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param forum 实例对象
     * @return 对象列表
     */
    List<Forum> queryAll(Forum forum);

    /**
     * 新增数据
     *
     * @param forum 实例对象
     * @return 影响行数
     */
    int insert(Forum forum);

    /**
     * 修改数据
     *
     * @param forum 实例对象
     * @return 影响行数
     */
    int update(Forum forum);

    /**
     * 通过主键删除数据
     *
     * @param forumid 主键
     * @return 影响行数
     */
    int deleteById(Integer forumid);

    List<Forum> list();

    List<Forum> detail(String forumOrderId);

    Integer getForumFloorid(String forumOrderId);

    Integer getForumOrderId();

    List<Forum> reportlist();

}