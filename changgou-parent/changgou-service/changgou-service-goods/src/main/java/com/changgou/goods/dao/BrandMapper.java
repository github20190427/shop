package com.changgou.goods.dao;
import com.changgou.goods.pojo.Brand;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/****
 * @Author:shenkunlin
 * @Description:Brand的Dao
 * @Date 2019/6/14 0:12
 *****/
@Repository
public interface BrandMapper extends Mapper<Brand>, MySqlMapper<Brand> {
}
