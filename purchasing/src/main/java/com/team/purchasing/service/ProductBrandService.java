package com.team.purchasing.service;

import com.team.purchasing.bean.ProductBrand;

import java.util.List;

/**
 * @Auther:ynhuang
 * @Date:19/3/19 下午9:36
 */
public interface ProductBrandService {

    public List<ProductBrand> queryProductBrandList(ProductBrand productBrand);

    public int queryProductBrandCount(ProductBrand productBrand);

}
