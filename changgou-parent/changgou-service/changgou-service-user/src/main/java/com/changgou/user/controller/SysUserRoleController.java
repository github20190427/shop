package com.changgou.user.controller;

import com.changgou.user.pojo.SysUserRole;
import com.changgou.user.service.SysUserRoleService;
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
@RequestMapping("/sysUserRole")
@CrossOrigin
public class SysUserRoleController {

    @Autowired
    private SysUserRoleService sysUserRoleService;

    /***
     * SysUserRole分页条件搜索实现
     * @param sysUserRole
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false)  SysUserRole sysUserRole, @PathVariable  int page, @PathVariable  int size){
        //调用SysUserRoleService实现分页条件查询SysUserRole
        PageInfo<SysUserRole> pageInfo = sysUserRoleService.findPage(sysUserRole, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * SysUserRole分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用SysUserRoleService实现分页查询SysUserRole
        PageInfo<SysUserRole> pageInfo = sysUserRoleService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param sysUserRole
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<SysUserRole>> findList(@RequestBody(required = false)  SysUserRole sysUserRole){
        //调用SysUserRoleService实现条件查询SysUserRole
        List<SysUserRole> list = sysUserRoleService.findList(sysUserRole);
        return new Result<List<SysUserRole>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用SysUserRoleService实现根据主键删除
        sysUserRoleService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改SysUserRole数据
     * @param sysUserRole
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  SysUserRole sysUserRole,@PathVariable Integer id){
        //设置主键值
        sysUserRole.setUID(id);
        //调用SysUserRoleService实现修改SysUserRole
        sysUserRoleService.update(sysUserRole);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增SysUserRole数据
     * @param sysUserRole
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   SysUserRole sysUserRole){
        //调用SysUserRoleService实现添加SysUserRole
        sysUserRoleService.add(sysUserRole);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询SysUserRole数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<SysUserRole> findById(@PathVariable Integer id){
        //调用SysUserRoleService实现根据主键查询SysUserRole
        SysUserRole sysUserRole = sysUserRoleService.findById(id);
        return new Result<SysUserRole>(true,StatusCode.OK,"查询成功",sysUserRole);
    }

    /***
     * 查询SysUserRole全部数据
     * @return
     */
    @GetMapping
    public Result<List<SysUserRole>> findAll(){
        //调用SysUserRoleService实现查询所有SysUserRole
        List<SysUserRole> list = sysUserRoleService.findAll();
        return new Result<List<SysUserRole>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
