package com.team.purchasing.mapper;

import com.team.purchasing.bean.Product;
import com.team.purchasing.bean.ProductSupplierRelation;

import java.util.List;

/**
 * @Auther:ynhuang
 * @Date:24/2/19 上午11:46
 */
public interface ProductDao {

    public List<Product> queryProductList(ProductSupplierRelation productSupplierRelation);

    public Integer queryProductCount(ProductSupplierRelation productSupplierRelation);

}
