package com.graduationproject.mybatisdemo.demo.service.impl;

import com.graduationproject.mybatisdemo.demo.entity.Forum;
import com.graduationproject.mybatisdemo.demo.dao.ForumDao;
import com.graduationproject.mybatisdemo.demo.service.ForumService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Forum)表服务实现类
 *
 * @author makejava
 * @since 2020-05-15 16:51:24
 */
@Service("forumService")
public class ForumServiceImpl implements ForumService {
    @Resource
    private ForumDao forumDao;

    /**
     * 通过ID查询单条数据
     *
     * @param forumid 主键
     * @return 实例对象
     */
    @Override
    public Forum queryById(Integer forumid) {
        return this.forumDao.queryById(forumid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Forum> queryAllByLimit(int offset, int limit) {
        return this.forumDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param forum 实例对象
     * @return 实例对象
     */
    @Override
    public Forum insert(Forum forum) {
        this.forumDao.insert(forum);
        return forum;
    }

    /**
     * 修改数据
     *
     * @param forum 实例对象
     * @return 实例对象
     */
    @Override
    public Forum update(Forum forum) {
        this.forumDao.update(forum);
        return this.queryById(forum.getForumid());
    }

    /**
     * 通过主键删除数据
     *
     * @param forumid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer forumid) {
        return this.forumDao.deleteById(forumid) > 0;
    }

    @Override
    public List<Forum> list(){
        return this.forumDao.list();
    }

    @Override
    public List<Forum> detail(String forumOrderId){
        return this.forumDao.detail(forumOrderId);
    }

    @Override
    public Integer comment(Forum forum){
        forum.setForumfloorid(this.forumDao.getForumFloorid(forum.getForumorderid().toString())+1);
        forum.setLikes(0);
        forum.setDislikes(0);
        forum.setIsdeleted(0);
        forum.setIslocked(0);
        return this.forumDao.insert(forum);
    }

    @Override
    public Integer newforum(Forum forum) {
        forum.setForumorderid(this.forumDao.getForumOrderId()+1);
        forum.setForumfloorid(0);
        forum.setLikes(0);
        forum.setDislikes(0);
        forum.setIsdeleted(0);
        forum.setIslocked(0);
        return this.forumDao.insert(forum);
    }

    @Override
    public List<Forum> reportlist() {
        return this.forumDao.reportlist();
    }
}