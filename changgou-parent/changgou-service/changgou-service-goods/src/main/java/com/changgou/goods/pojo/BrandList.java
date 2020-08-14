package com.changgou.goods.pojo;

import java.util.HashMap;
import java.util.List;

public class BrandList {
    String name;
    List<Brand> brands;
    HashMap<String,String> brandMap;
    List<String> strList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Brand> getBrands() {
        return brands;
    }

    public void setBrands(List<Brand> brands) {
        this.brands = brands;
    }

    public HashMap<String, String> getBrandMap() {
        return brandMap;
    }

    public void setBrandMap(HashMap<String, String> brandMap) {
        this.brandMap = brandMap;
    }

    public List<String> getStrList() {
        return strList;
    }

    public void setStrList(List<String> strList) {
        this.strList = strList;
    }
}
