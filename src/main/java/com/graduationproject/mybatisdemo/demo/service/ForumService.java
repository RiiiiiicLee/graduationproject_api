package com.graduationproject.mybatisdemo.demo.service;

import com.graduationproject.mybatisdemo.demo.entity.Forum;
import java.util.List;

/**
 * (Forum)表服务接口
 *
 * @author makejava
 * @since 2020-05-15 16:51:24
 */
public interface ForumService {

    /**
     * 通过ID查询单条数据
     *
     * @param forumid 主键
     * @return 实例对象
     */
    Forum queryById(Integer forumid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Forum> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param forum 实例对象
     * @return 实例对象
     */
    Forum insert(Forum forum);

    /**
     * 修改数据
     *
     * @param forum 实例对象
     * @return 实例对象
     */
    Forum update(Forum forum);

    /**
     * 通过主键删除数据
     *
     * @param forumid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer forumid);

    List<Forum> list();

    List<Forum> detail(String forumOrderId);

    Integer comment(Forum forum);

    Integer newforum(Forum forum);

    List<Forum> reportlist();

}