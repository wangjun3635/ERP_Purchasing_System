package com.team.purchasing.mapper;

import com.team.purchasing.bean.Product;
import com.team.purchasing.bean.ProductSupplierRelation;
import com.team.purchasing.bean.productquery.ProductTypeName;

import java.util.List;

/**
 * @Auther:ynhuang
 * @Date:24/2/19 上午11:46
 */
public interface ProductDao {

    public List<Product> queryProductList(ProductSupplierRelation productSupplierRelation);

    public int queryProductCount(ProductSupplierRelation productSupplierRelation);

    public List<ProductTypeName> queryProductTypeName();

}
