package com.graduationproject.mybatisdemo.demo.service;

import com.graduationproject.mybatisdemo.demo.RequestDao.salesRecordDeleteRequestDao;
import com.graduationproject.mybatisdemo.demo.RequestDao.salesRecordRequestDao;
import com.graduationproject.mybatisdemo.demo.ResponseDao.salesrecordResponseDao;
import com.graduationproject.mybatisdemo.demo.entity.Salesrecord;
import java.util.List;

/**
 * (Salesrecord)表服务接口
 *
 * @author makejava
 * @since 2020-04-24 04:29:11
 */
public interface SalesrecordService {

    /**
     * 通过ID查询单条数据
     *
     * @param salesrecordid 主键
     * @return 实例对象
     */
    Salesrecord queryById(Integer salesrecordid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Salesrecord> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param salesrecord 实例对象
     * @return 实例对象
     */
    Salesrecord insert(Salesrecord salesrecord);

    /**
     * 修改数据
     *
     * @param salesrecord 实例对象
     * @return 实例对象
     */
    Salesrecord update(Salesrecord salesrecord);

    /**
     * 通过主键删除数据
     *
     * @param salesrecordid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer salesrecordid);

    List<salesrecordResponseDao> list(String username);

    List<salesrecordResponseDao> showlist(String username, Integer orderId);

    int confirmOrder(String username, String addressId);

    int userdelete(String username, String orderId);


    List<Salesrecord> all();

    int editAddress(salesRecordRequestDao salesRecordRequestDao);

    int adminDelete(salesRecordDeleteRequestDao salesRecordDeleteRequestDao);

}