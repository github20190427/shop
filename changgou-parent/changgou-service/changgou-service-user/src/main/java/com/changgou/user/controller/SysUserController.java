package com.changgou.user.controller;

import com.changgou.user.pojo.SysUser;
import com.changgou.user.service.SysUserService;
import com.github.pagehelper.PageInfo;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:
 * @Date 2019/6/14 0:18
 *****/

@RestController
@RequestMapping("/sysUser")
@CrossOrigin
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    /***
     * SysUser分页条件搜索实现
     * @param sysUser
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false)  SysUser sysUser, @PathVariable  int page, @PathVariable  int size){
        //调用SysUserService实现分页条件查询SysUser
        PageInfo<SysUser> pageInfo = sysUserService.findPage(sysUser, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * SysUser分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用SysUserService实现分页查询SysUser
        PageInfo<SysUser> pageInfo = sysUserService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param sysUser
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<SysUser>> findList(@RequestBody(required = false)  SysUser sysUser){
        //调用SysUserService实现条件查询SysUser
        List<SysUser> list = sysUserService.findList(sysUser);
        return new Result<List<SysUser>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用SysUserService实现根据主键删除
        sysUserService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改SysUser数据
     * @param sysUser
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  SysUser sysUser,@PathVariable Integer id){
        //设置主键值
        sysUser.setId(id);
        //调用SysUserService实现修改SysUser
        sysUserService.update(sysUser);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增SysUser数据
     * @param sysUser
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   SysUser sysUser){
        //调用SysUserService实现添加SysUser
        sysUserService.add(sysUser);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询SysUser数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<SysUser> findById(@PathVariable Integer id){
        //调用SysUserService实现根据主键查询SysUser
        SysUser sysUser = sysUserService.findById(id);
        return new Result<SysUser>(true,StatusCode.OK,"查询成功",sysUser);
    }

    /***
     * 查询SysUser全部数据
     * @return
     */
    @GetMapping
    public Result<List<SysUser>> findAll(){
        //调用SysUserService实现查询所有SysUser
        List<SysUser> list = sysUserService.findAll();
        return new Result<List<SysUser>>(true, StatusCode.OK,"查询成功",list) ;
    }

    @GetMapping("/loads/{name}")
    public Result<SysUser> findByName(@PathVariable String name){
        SysUser sysUser = sysUserService.findByName(name);
        return new Result<SysUser>(true, StatusCode.OK,"查询成功",sysUser) ;
    }
}
