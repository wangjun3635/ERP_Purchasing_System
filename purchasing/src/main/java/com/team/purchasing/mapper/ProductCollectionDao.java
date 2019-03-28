package com.team.purchasing.mapper;

import com.team.purchasing.bean.ProductCollection;

import java.util.List;

/**
 * @Auther: 018399
 * @Date: 2019/3/23 14:44
 * @Description:
 */
public interface ProductCollectionDao {

    public List<ProductCollection> queryProductCollectionList(ProductCollection productCollection);

    public int updateProductCollection(ProductCollection productCollection);

    public int deleteProductCollection(ProductCollection productCollection);

    public int addProductCollection(ProductCollection productCollection);

    public int queryProductCollectionCount(ProductCollection productCollection);
}
