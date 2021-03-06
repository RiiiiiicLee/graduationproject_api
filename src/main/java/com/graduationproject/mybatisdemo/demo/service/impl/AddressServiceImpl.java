package com.graduationproject.mybatisdemo.demo.service.impl;

import com.graduationproject.mybatisdemo.demo.entity.Address;
import com.graduationproject.mybatisdemo.demo.dao.AddressDao;
import com.graduationproject.mybatisdemo.demo.service.AddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Address)表服务实现类
 *
 * @author makejava
 * @since 2020-04-23 01:36:18
 */
@Service("addressService")
public class AddressServiceImpl implements AddressService {
    @Resource
    private AddressDao addressDao;

    /**
     * 通过ID查询单条数据
     *
     * @param addressid 主键
     * @return 实例对象
     */
    @Override
    public Address queryById(Integer addressid) {
        return this.addressDao.queryById(addressid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Address> queryAllByLimit(int offset, int limit) {
        return this.addressDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param address 实例对象
     * @return 实例对象
     */
    @Override
    public Address insert(Address address) {
        this.addressDao.insert(address);
        return address;
    }

    /**
     * 修改数据
     *
     * @param address 实例对象
     * @return 实例对象
     */
    @Override
    public Address update(Address address) {
        this.addressDao.update(address);
        return this.queryById(address.getAddressid());
    }

    /**
     * 通过主键删除数据
     *
     * @param addressid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer addressid) {
        return this.addressDao.deleteById(addressid) > 0;
    }

    @Override
    public List<Address> list(String username){
        return this.addressDao.list(username);
    };

    @Override
    public int add(String username, String addressinfo, String addressname, String tel){
        return this.addressDao.add(username,addressinfo,addressname,tel);
    };

    @Override
    public int deleteByAddressId(Integer addressid){
        return this.addressDao.deleteById(addressid);
    }
}