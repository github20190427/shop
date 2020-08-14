package com.changgou.user.service.impl;

import com.changgou.user.dao.SysPermissionMapper;
import com.changgou.user.pojo.SysPermission;
import com.changgou.user.service.SysPermissionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:SysPermission业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class SysPermissionServiceImpl implements SysPermissionService {

    @Autowired
    private SysPermissionMapper sysPermissionMapper;


    /**
     * SysPermission条件+分页查询
     * @param sysPermission 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<SysPermission> findPage(SysPermission sysPermission, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(sysPermission);
        //执行搜索
        return new PageInfo<SysPermission>(sysPermissionMapper.selectByExample(example));
    }

    /**
     * SysPermission分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<SysPermission> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<SysPermission>(sysPermissionMapper.selectAll());
    }

    /**
     * SysPermission条件查询
     * @param sysPermission
     * @return
     */
    @Override
    public List<SysPermission> findList(SysPermission sysPermission){
        //构建查询条件
        Example example = createExample(sysPermission);
        //根据构建的条件查询数据
        return sysPermissionMapper.selectByExample(example);
    }


    /**
     * SysPermission构建查询对象
     * @param sysPermission
     * @return
     */
    public Example createExample(SysPermission sysPermission){
        Example example=new Example(SysPermission.class);
        Example.Criteria criteria = example.createCriteria();
        if(sysPermission!=null){
            // 编号
            if(!StringUtils.isEmpty(sysPermission.getID())){
                    criteria.andEqualTo("ID",sysPermission.getID());
            }
            // 菜单名称
            if(!StringUtils.isEmpty(sysPermission.getPermissionNAME())){
                    criteria.andEqualTo("permissionNAME",sysPermission.getPermissionNAME());
            }
            // 菜单地址
            if(!StringUtils.isEmpty(sysPermission.getPermissionUrl())){
                    criteria.andEqualTo("permissionUrl",sysPermission.getPermissionUrl());
            }
            // 父菜单id
            if(!StringUtils.isEmpty(sysPermission.getParentId())){
                    criteria.andEqualTo("parentId",sysPermission.getParentId());
            }
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(Integer id){
        sysPermissionMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改SysPermission
     * @param sysPermission
     */
    @Override
    public void update(SysPermission sysPermission){
        sysPermissionMapper.updateByPrimaryKey(sysPermission);
    }

    /**
     * 增加SysPermission
     * @param sysPermission
     */
    @Override
    public void add(SysPermission sysPermission){
        sysPermissionMapper.insert(sysPermission);
    }

    /**
     * 根据ID查询SysPermission
     * @param id
     * @return
     */
    @Override
    public SysPermission findById(Integer id){
        return  sysPermissionMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询SysPermission全部数据
     * @return
     */
    @Override
    public List<SysPermission> findAll() {
        return sysPermissionMapper.selectAll();
    }
}
