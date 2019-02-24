package com.team.purchasing.service.impl;

import com.team.purchasing.bean.ProductCategory;
import com.team.purchasing.mapper.ProductCategoryDao;
import com.team.purchasing.service.ProductCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Auther:ynhuang
 * @Date:24/2/19 下午4:09
 */
@Service
@Slf4j
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Resource
    private ProductCategoryDao productCategoryDao;

    @Override
    @Transactional
    public int updateProductCategory(ProductCategory productCategory) {
        try {
            int result = productCategoryDao.updateProductCategory(productCategory);
            return result;
        }catch (Exception e){
            log.error("产品类型更新出现错误, 信息为：{}", productCategory, e);
            throw new RuntimeException("产品类型更新出现错误..");
        }
    }
}
