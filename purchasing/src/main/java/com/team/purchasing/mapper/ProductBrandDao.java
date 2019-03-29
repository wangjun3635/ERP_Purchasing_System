package com.team.purchasing.mapper;

import com.team.purchasing.bean.ProductBrand;

import java.util.List;

/**
 * @Auther:ynhuang
 * @Date:16/3/19 下午12:29
 */
public interface ProductBrandDao {

    // TODO: 16/3/19 sql需要构建一个排序关系,关于首字母中英文排序 
    public List<ProductBrand> queryProductBrandList(ProductBrand productBrand);

    public int queryProductBrandCount(ProductBrand productBrand);

    public List<String> queryProductBrandNameList();

}
