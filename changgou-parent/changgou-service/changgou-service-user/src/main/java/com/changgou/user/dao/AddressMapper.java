package com.changgou.user.dao;

import com.changgou.user.pojo.Address;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/****
 * @Author:shenkunlin
 * @Description:Address的Dao
 * @Date 2019/6/14 0:12
 *****/
@Repository
public interface AddressMapper extends Mapper<Address> {
}
