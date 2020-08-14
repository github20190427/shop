package com.changgou.order.dao;

import com.changgou.order.pojo.OrderLog;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/****
 * @Author:shenkunlin
 * @Description:OrderLog的Dao
 * @Date 2019/6/14 0:12
 *****/
@Repository
public interface OrderLogMapper extends Mapper<OrderLog> {
}
