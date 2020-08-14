package com.changgou.user.feign;
import com.changgou.user.pojo.SysUser;
import com.github.pagehelper.PageInfo;
import entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:
 * @Date 2019/6/18 13:58
 *****/
@FeignClient(name="user")
@RequestMapping("/sysUser")
public interface SysUserFeign {

    /***
     * SysUser分页条件搜索实现
     * @param sysUser
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) SysUser sysUser, @PathVariable int page, @PathVariable int size);

    /***
     * SysUser分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable int page, @PathVariable int size);

    /***
     * 多条件搜索品牌数据
     * @param sysUser
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<SysUser>> findList(@RequestBody(required = false) SysUser sysUser);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Integer id);

    /***
     * 修改SysUser数据
     * @param sysUser
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody SysUser sysUser, @PathVariable Integer id);

    /***
     * 新增SysUser数据
     * @param sysUser
     * @return
     */
    @PostMapping
    Result add(@RequestBody SysUser sysUser);

    /***
     * 根据ID查询SysUser数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<SysUser> findById(@PathVariable Integer id);

    /***
     * 查询SysUser全部数据
     * @return
     */
    @GetMapping
    Result<List<SysUser>> findAll();

    /***
     * 查询User信息和role信息
     * @param name
     * @return
     */
    @GetMapping("/loads/{name}")
    Result<SysUser> findsByName(@PathVariable(value = "name") String name);
}