package com.graduationproject.mybatisdemo.demo.service;

import com.graduationproject.mybatisdemo.demo.entity.Notification;
import java.util.List;

/**
 * (Notification)表服务接口
 *
 * @author makejava
 * @since 2020-04-24 04:08:12
 */
public interface NotificationService {

    /**
     * 通过ID查询单条数据
     *
     * @param notificationid 主键
     * @return 实例对象
     */
    Notification queryById(Integer notificationid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Notification> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param notification 实例对象
     * @return 实例对象
     */
    Notification insert(Notification notification);

    /**
     * 修改数据
     *
     * @param notification 实例对象
     * @return 实例对象
     */
    Notification update(Notification notification);

    /**
     * 通过主键删除数据
     *
     * @param notificationid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer notificationid);

    List<Notification> list();

}