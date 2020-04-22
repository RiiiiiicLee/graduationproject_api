package com.graduationproject.mybatisdemo.demo.service;

import com.graduationproject.mybatisdemo.demo.entity.Address;
import java.util.List;

/**
 * (Address)表服务接口
 *
 * @author makejava
 * @since 2020-04-23 01:36:18
 */
public interface AddressService {

    /**
     * 通过ID查询单条数据
     *
     * @param addressid 主键
     * @return 实例对象
     */
    Address queryById(Integer addressid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Address> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param address 实例对象
     * @return 实例对象
     */
    Address insert(Address address);

    /**
     * 修改数据
     *
     * @param address 实例对象
     * @return 实例对象
     */
    Address update(Address address);

    /**
     * 通过主键删除数据
     *
     * @param addressid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer addressid);

    List<Address> list(String username);
}