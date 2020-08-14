package com.changgou.user.dao;

import com.changgou.user.pojo.SysPermission;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/****
 * @Author:shenkunlin
 * @Description:SysPermission的Dao
 * @Date 2019/6/14 0:12
 *****/
@Repository
public interface SysPermissionMapper extends Mapper<SysPermission> {
}
