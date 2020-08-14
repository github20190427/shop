package com.changgou.goods.controller;

import com.changgou.goods.pojo.Brand;
import com.changgou.goods.pojo.BrandCategory;
import com.changgou.goods.pojo.BrandList;
import com.changgou.goods.service.BrandService;
import com.github.pagehelper.PageInfo;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:
 * @Date 2019/6/14 0:18
 *****/

@RestController
@RequestMapping("/brand")
@CrossOrigin
@Secured({"ROLE_USER","ROLE_VIP"})
public class BrandController {

    @Autowired
    private BrandService brandService;

    /***
     * Brand分页条件搜索实现
     * @param brand
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false)  Brand brand, @PathVariable  int page, @PathVariable  int size){
        //调用BrandService实现分页条件查询Brand
        PageInfo<Brand> pageInfo = brandService.findPage(brand, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Brand分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用BrandService实现分页查询Brand
        PageInfo<Brand> pageInfo = brandService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param brand
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<Brand>> findList(@RequestBody(required = false)  Brand brand){
        //调用BrandService实现条件查询Brand
        List<Brand> list = brandService.findList(brand);
        return new Result<List<Brand>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用BrandService实现根据主键删除
        brandService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Brand数据
     * @param brand
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  Brand brand,@PathVariable Integer id){
        //设置主键值
        brand.setId(id);
        //调用BrandService实现修改Brand
        brandService.update(brand);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Brand数据
     * @param brand
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   Brand brand){
        //调用BrandService实现添加Brand
        brandService.add(brand);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Brand数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<Brand> findById(@PathVariable Integer id){
        //调用BrandService实现根据主键查询Brand
        Brand brand = brandService.findById(id);
        return new Result<Brand>(true,StatusCode.OK,"查询成功",brand);
    }

    /***
     * 查询Brand全部数据
     * @return
     */
    @GetMapping
    @Secured({"ROLE_VIP"})
    public Result<List<Brand>> findAll(){
        //调用BrandService实现查询所有Brand
        List<Brand> list = brandService.findAll();
        return new Result<List<Brand>>(true, StatusCode.OK,"查询成功",list) ;
    }

    @GetMapping(value = "/xml/{id}")
    public Result<Brand> findByIdMybaits(@PathVariable(value = "id") Integer id){
        Brand brand = brandService.findByIdxml(id);
        return new Result<Brand>(true,StatusCode.OK,"查询成功",brand);
    }

    @GetMapping(value = "/zuoHe/{id}")
    public Result<List<BrandCategory>> findZuHeXinXi(@PathVariable(value = "id") Integer id){
        List<BrandCategory> brandCategory = brandService.findZuHeXinXi(id);
        return new Result<List<BrandCategory>>(true,StatusCode.OK,"查询成功",brandCategory);
    }

    @GetMapping(value = "/select")
    public Result<List<Brand>> findBySelect(@RequestBody String str){
        System.out.println(str);
        return new Result<List<Brand>>(true,StatusCode.OK,"查询成功",null);
    }


    /*
    {
        "name":"wsk",
        "brands":[{"id":"1115"},{"id":"1528","name":"HTC","image":""},{"id":"1912","name":"HTC","image":"","letter":"H"}],
        "brandMap":{"nmae":"heloo"},
        "strList":["1115","1528","1912"]
    }
     */
    @GetMapping(value = "/select1")
    public Result<List<Brand>> findBySelect1(@RequestBody BrandList brands){
        System.out.println(brands.getName());
        for (Brand brand:brands.getBrands()){
            System.out.println("id:"+brand.getId());
        }
       for(String str :brands.getBrandMap().keySet())
           System.out.println("key:"+str+"    value:"+brands.getBrandMap().get(str));

       for(String s : brands.getStrList()){
           System.out.println("s:"+s);
       }

        return new Result<List<Brand>>(true,StatusCode.OK,"查询成功",null);
    }

    @GetMapping(value = "/selectAll")
    public Result<List<Brand>> findBySelectAll(@RequestBody BrandList brands){
        List<Brand> brandList = brandService.findBySelect(brands.getStrList());
        return new Result<List<Brand>>(true,StatusCode.OK,"查询成功",brandList);
    }

    /*
    {
        "name":"wsk",
        "brands":[{"id":"1115"},{"id":"1528","name":"HTC","image":""},{"id":"1912","name":"HTC","image":"","letter":"H"}],
        "brandMap":{"nmae":"heloo"},
        "strList":["1115","1528","1912"]
    }
     */
    @GetMapping(value = "/selectAllByObject")
    public Result<List<Brand>> selectAllByObject(@RequestBody BrandList brands){
        List<Brand> brandList = brandService.findBySelectByObject(brands.getBrands());
        return new Result<List<Brand>>(true,StatusCode.OK,"查询成功",brandList);
    }
}
