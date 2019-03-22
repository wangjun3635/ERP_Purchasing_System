package com.team.purchasing.service.impl;

import com.team.purchasing.bean.ProductBrand;
import com.team.purchasing.mapper.ProductBrandDao;
import com.team.purchasing.service.ProductBrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @Auther:ynhuang
 * @Date:19/3/19 下午9:36
 */
@Service
@Slf4j
public class ProductBrandServiceImpl implements ProductBrandService {

    @Resource
    private ProductBrandDao productBrandDao;

    @Override
    public List<ProductBrand> queryProductBrandList(ProductBrand productBrand) {

        try {
            List<ProductBrand> productBrands = productBrandDao.queryProductBrandList(productBrand);
            return productBrands;
        }catch (Exception e) {
            log.error("品牌查询失败", e);
            throw new RuntimeException("品牌查询失败..");
        }

    }

    @Override
    public int queryProductBrandCount(ProductBrand productBrand) {

        try {
            int count = productBrandDao.queryProductBrandCount(productBrand);
            return count;
        }catch (Exception e) {
            log.error("品牌查询count失败", e);
            throw new RuntimeException("品牌查询count失败..");
        }

    }
}
