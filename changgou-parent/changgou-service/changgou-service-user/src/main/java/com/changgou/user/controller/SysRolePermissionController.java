package com.changgou.user.controller;

import com.changgou.user.pojo.SysRolePermission;
import com.changgou.user.service.SysRolePermissionService;
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
@RequestMapping("/sysRolePermission")
@CrossOrigin
public class SysRolePermissionController {

    @Autowired
    private SysRolePermissionService sysRolePermissionService;

    /***
     * SysRolePermission分页条件搜索实现
     * @param sysRolePermission
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false)  SysRolePermission sysRolePermission, @PathVariable  int page, @PathVariable  int size){
        //调用SysRolePermissionService实现分页条件查询SysRolePermission
        PageInfo<SysRolePermission> pageInfo = sysRolePermissionService.findPage(sysRolePermission, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * SysRolePermission分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用SysRolePermissionService实现分页查询SysRolePermission
        PageInfo<SysRolePermission> pageInfo = sysRolePermissionService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param sysRolePermission
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<SysRolePermission>> findList(@RequestBody(required = false)  SysRolePermission sysRolePermission){
        //调用SysRolePermissionService实现条件查询SysRolePermission
        List<SysRolePermission> list = sysRolePermissionService.findList(sysRolePermission);
        return new Result<List<SysRolePermission>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用SysRolePermissionService实现根据主键删除
        sysRolePermissionService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改SysRolePermission数据
     * @param sysRolePermission
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  SysRolePermission sysRolePermission,@PathVariable Integer id){
        //设置主键值
        sysRolePermission.setRID(id);
        //调用SysRolePermissionService实现修改SysRolePermission
        sysRolePermissionService.update(sysRolePermission);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增SysRolePermission数据
     * @param sysRolePermission
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   SysRolePermission sysRolePermission){
        //调用SysRolePermissionService实现添加SysRolePermission
        sysRolePermissionService.add(sysRolePermission);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询SysRolePermission数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<SysRolePermission> findById(@PathVariable Integer id){
        //调用SysRolePermissionService实现根据主键查询SysRolePermission
        SysRolePermission sysRolePermission = sysRolePermissionService.findById(id);
        return new Result<SysRolePermission>(true,StatusCode.OK,"查询成功",sysRolePermission);
    }

    /***
     * 查询SysRolePermission全部数据
     * @return
     */
    @GetMapping
    public Result<List<SysRolePermission>> findAll(){
        //调用SysRolePermissionService实现查询所有SysRolePermission
        List<SysRolePermission> list = sysRolePermissionService.findAll();
        return new Result<List<SysRolePermission>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
