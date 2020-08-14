package com.changgou.user.controller;

import com.changgou.user.pojo.SysPermission;
import com.changgou.user.service.SysPermissionService;
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
@RequestMapping("/sysPermission")
@CrossOrigin
public class SysPermissionController {

    @Autowired
    private SysPermissionService sysPermissionService;

    /***
     * SysPermission分页条件搜索实现
     * @param sysPermission
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false)  SysPermission sysPermission, @PathVariable  int page, @PathVariable  int size){
        //调用SysPermissionService实现分页条件查询SysPermission
        PageInfo<SysPermission> pageInfo = sysPermissionService.findPage(sysPermission, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * SysPermission分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用SysPermissionService实现分页查询SysPermission
        PageInfo<SysPermission> pageInfo = sysPermissionService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param sysPermission
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<SysPermission>> findList(@RequestBody(required = false)  SysPermission sysPermission){
        //调用SysPermissionService实现条件查询SysPermission
        List<SysPermission> list = sysPermissionService.findList(sysPermission);
        return new Result<List<SysPermission>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用SysPermissionService实现根据主键删除
        sysPermissionService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改SysPermission数据
     * @param sysPermission
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  SysPermission sysPermission,@PathVariable Integer id){
        //设置主键值
        sysPermission.setID(id);
        //调用SysPermissionService实现修改SysPermission
        sysPermissionService.update(sysPermission);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增SysPermission数据
     * @param sysPermission
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   SysPermission sysPermission){
        //调用SysPermissionService实现添加SysPermission
        sysPermissionService.add(sysPermission);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询SysPermission数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<SysPermission> findById(@PathVariable Integer id){
        //调用SysPermissionService实现根据主键查询SysPermission
        SysPermission sysPermission = sysPermissionService.findById(id);
        return new Result<SysPermission>(true,StatusCode.OK,"查询成功",sysPermission);
    }

    /***
     * 查询SysPermission全部数据
     * @return
     */
    @GetMapping
    public Result<List<SysPermission>> findAll(){
        //调用SysPermissionService实现查询所有SysPermission
        List<SysPermission> list = sysPermissionService.findAll();
        return new Result<List<SysPermission>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
