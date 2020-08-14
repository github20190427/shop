package com.changgou.order.dao;

import com.changgou.order.pojo.Order;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/****
 * @Author:shenkunlin
 * @Description:Order的Dao
 * @Date 2019/6/14 0:12
 *****/
@Repository
public interface OrderMapper extends Mapper<Order> {
}
