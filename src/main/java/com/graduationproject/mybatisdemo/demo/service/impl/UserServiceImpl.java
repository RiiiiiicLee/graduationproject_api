package com.graduationproject.mybatisdemo.demo.service.impl;

import com.graduationproject.mybatisdemo.demo.RequestDao.userRequestDao;
import com.graduationproject.mybatisdemo.demo.entity.User;
import com.graduationproject.mybatisdemo.demo.dao.UserDao;
import com.graduationproject.mybatisdemo.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2020-03-25 20:05:02
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    /**
     * 通过ID查询单条数据
     *
     * @param userid 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Integer userid) {
        return this.userDao.queryById(userid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<User> queryAllByLimit(int offset, int limit) {
        return this.userDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User insert(User user) {
        this.userDao.insert(user);
        return user;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User update(User user) {
        this.userDao.update(user);
        return this.queryById(user.getUserid());
    }

    /**
     * 通过主键删除数据
     *
     * @param userid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer userid) {
        return this.userDao.deleteById(userid) > 0;
    }

    @Override
    public List<User> list() {
        return this.userDao.list();
    }

    @Override
    public User newUser(userRequestDao userRequestDao){
        User user = new User();
        user.setUsername(userRequestDao.getUsername());
        user.setPassword(userRequestDao.getPassword());
        user.setTel(userRequestDao.getTel());
        user.setAddress(userRequestDao.getAddress());
        user.setEmail(userRequestDao.getEmail());
        user.setUserstatus(userRequestDao.getUserstatus());
        user.setBirthday(userRequestDao.getBirthday());
        user.setCreatetime(userRequestDao.getCreatetime());
        user.setIsdeleted(userRequestDao.getIsdeleted());
        user.setIslocked(userRequestDao.getIslocked());
        int i = this.userDao.newUser(user);
        if(i ==1){
            return user;}
        else{
            return null;
        }
    }
}