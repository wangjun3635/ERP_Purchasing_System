package com.team.purchasing.service;

import com.team.purchasing.bean.Product;
import com.team.purchasing.bean.ProductSupplierRelation;

import java.util.List;

/**
 * @Auther:ynhuang
 * @Date:24/2/19 上午11:44
 */
public interface ProductService {

    public List<Product> queryProductList(ProductSupplierRelation product);

    public Integer queryProductCount(ProductSupplierRelation product);

}
