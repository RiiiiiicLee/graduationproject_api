package com.graduationproject.mybatisdemo.demo.service.impl;

import com.graduationproject.mybatisdemo.demo.entity.Notification;
import com.graduationproject.mybatisdemo.demo.dao.NotificationDao;
import com.graduationproject.mybatisdemo.demo.service.NotificationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Notification)表服务实现类
 *
 * @author makejava
 * @since 2020-04-24 04:08:12
 */
@Service("notificationService")
public class NotificationServiceImpl implements NotificationService {
    @Resource
    private NotificationDao notificationDao;

    /**
     * 通过ID查询单条数据
     *
     * @param notificationid 主键
     * @return 实例对象
     */
    @Override
    public Notification queryById(Integer notificationid) {
        return this.notificationDao.queryById(notificationid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Notification> queryAllByLimit(int offset, int limit) {
        return this.notificationDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param notification 实例对象
     * @return 实例对象
     */
    @Override
    public Notification insert(Notification notification) {
        this.notificationDao.insert(notification);
        return notification;
    }

    /**
     * 修改数据
     *
     * @param notification 实例对象
     * @return 实例对象
     */
    @Override
    public Notification update(Notification notification) {
        this.notificationDao.update(notification);
        return this.queryById(notification.getNotificationid());
    }

    /**
     * 通过主键删除数据
     *
     * @param notificationid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer notificationid) {
        return this.notificationDao.deleteById(notificationid) > 0;
    }


    @Override
    public List<Notification> list(){
        return this.notificationDao.list();
    }
}