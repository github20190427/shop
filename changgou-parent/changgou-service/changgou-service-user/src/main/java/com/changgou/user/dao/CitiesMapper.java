package com.changgou.user.dao;

import com.changgou.user.pojo.Cities;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/****
 * @Author:shenkunlin
 * @Description:Cities的Dao
 * @Date 2019/6/14 0:12
 *****/
@Repository
public interface CitiesMapper extends Mapper<Cities> {
}
