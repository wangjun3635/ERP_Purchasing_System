package com.team.purchasing.service.impl;

import com.team.purchasing.bean.Product;
import com.team.purchasing.bean.ProductSupplierRelation;
import com.team.purchasing.mapper.ProductDao;
import com.team.purchasing.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther:ynhuang
 * @Date:24/2/19 下午3:50
 */
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductDao productDao;

    @Override
    public List<Product> queryProductList(ProductSupplierRelation product) {
        return productDao.queryProductList(product);
    }

    @Override
    public Integer queryProductCount(ProductSupplierRelation product) {
        Integer count = productDao.queryProductCount(product);
        return count == null ? 0 : count;
    }
}
