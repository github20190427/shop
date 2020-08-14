package com.changgou.goods.mydao;

import com.changgou.goods.pojo.Brand;
import com.changgou.goods.pojo.BrandCategory;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MyBrandMapper {

    Brand findByIdxml(Integer id);

    List<BrandCategory> findZuHeXinXi(Integer id);

    List<Brand> findBySelect(List list);
    List<Brand> findBySelectByObject(List list);
}
