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
    public List<Product> queryProductList(ProductSupplierRelation productSupplierRelation) {

        try {
            List<Product> productList = productDao.queryProductList(productSupplierRelation);
            return productList;
        }catch (Exception e) {
            log.error("查询数据异常,异常信息为: {}", e);
            throw new RuntimeException("[ProductServiceImpl] 查询数据异常");
        }

    }

    @Override
    public int queryProductCount(ProductSupplierRelation productSupplierRelation) {

        try {
            int count = productDao.queryProductCount(productSupplierRelation);
            return count;
        }catch (Exception e) {
            log.error("查询count数据异常,异常信息为: {}", e);
            throw new RuntimeException("[ProductServiceImpl] 查询count数据异常");
        }

    }
}
