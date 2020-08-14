package com.changgou.user.dao;

import com.changgou.user.pojo.SysUser;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:SysUser的Dao
 * @Date 2019/6/14 0:12
 *****/
@Repository
public interface SysUserMapper extends Mapper<SysUser> {

    @Select("select * from sys_user where username=#{username}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roles",column = "id", javaType = List.class,
                    many = @Many(select = "com.changgou.user.dao.SysRoleMapper.findByUid"))
    })
    public SysUser findByName(String username);
}
