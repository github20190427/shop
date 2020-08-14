package com.changgou.order.dao;

import com.changgou.order.pojo.UndoLog;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/****
 * @Author:shenkunlin
 * @Description:UndoLog的Dao
 * @Date 2019/6/14 0:12
 *****/
@Repository
public interface UndoLogMapper extends Mapper<UndoLog> {
}
