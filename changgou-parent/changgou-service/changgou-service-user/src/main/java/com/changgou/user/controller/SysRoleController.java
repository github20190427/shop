package com.changgou.user.controller;

import com.changgou.user.pojo.SysRole;
import com.changgou.user.service.SysRoleService;
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
@RequestMapping("/sysRole")
@CrossOrigin
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    /***
     * SysRole分页条件搜索实现
     * @param sysRole
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false)  SysRole sysRole, @PathVariable  int page, @PathVariable  int size){
        //调用SysRoleService实现分页条件查询SysRole
        PageInfo<SysRole> pageInfo = sysRoleService.findPage(sysRole, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * SysRole分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用SysRoleService实现分页查询SysRole
        PageInfo<SysRole> pageInfo = sysRoleService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param sysRole
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<SysRole>> findList(@RequestBody(required = false)  SysRole sysRole){
        //调用SysRoleService实现条件查询SysRole
        List<SysRole> list = sysRoleService.findList(sysRole);
        return new Result<List<SysRole>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用SysRoleService实现根据主键删除
        sysRoleService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改SysRole数据
     * @param sysRole
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  SysRole sysRole,@PathVariable Integer id){
        //设置主键值
        sysRole.setID(id);
        //调用SysRoleService实现修改SysRole
        sysRoleService.update(sysRole);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增SysRole数据
     * @param sysRole
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   SysRole sysRole){
        //调用SysRoleService实现添加SysRole
        sysRoleService.add(sysRole);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询SysRole数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<SysRole> findById(@PathVariable Integer id){
        //调用SysRoleService实现根据主键查询SysRole
        SysRole sysRole = sysRoleService.findById(id);
        return new Result<SysRole>(true,StatusCode.OK,"查询成功",sysRole);
    }

    /***
     * 查询SysRole全部数据
     * @return
     */
    @GetMapping
    public Result<List<SysRole>> findAll(){
        //调用SysRoleService实现查询所有SysRole
        List<SysRole> list = sysRoleService.findAll();
        return new Result<List<SysRole>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
