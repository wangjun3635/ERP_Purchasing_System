package com.team.purchasing.service.impl;

import com.team.purchasing.bean.ProductCollection;
import com.team.purchasing.mapper.ProductCollectionDao;
import com.team.purchasing.service.ProductCollectionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: 018399
 * @Date: 2019/3/23 14:46
 * @Description:
 */
@Service
@Slf4j
public class ProductCollectionServiceImpl implements ProductCollectionService {

    @Resource
    private ProductCollectionDao productCollectionDao;

    @Override
    public List<ProductCollection> queryProductCollectionList(ProductCollection productCollection) {

        try {

            List<ProductCollection> productCollections = productCollectionDao.queryProductCollectionList(productCollection);
            return productCollections;

        }catch (Exception e) {

            log.error("收藏夹查询失败");
            throw new RuntimeException("收藏夹查询失败");

        }

    }

    @Override
    @Transactional
    public int updateProductCollection(ProductCollection productCollection) {

        try {

            int result = productCollectionDao.updateProductCollection(productCollection);
            return result;

        }catch (Exception e) {
            log.error("收藏夹更新失败");
            throw new RuntimeException("收藏夹更新失败");
        }

    }

    @Override
    @Transactional
    public int deleteProductCollection(ProductCollection productCollection) {
        try {

            int result = productCollectionDao.deleteProductCollection(productCollection);
            return result;

        }catch (Exception e) {
            log.error("收藏夹删除失败");
            throw new RuntimeException("收藏夹删除失败");
        }
    }

    @Override
    @Transactional
    public int addProductCollection(ProductCollection productCollection) {
        try {

            int result = productCollectionDao.addProductCollection(productCollection);
            return result;

        }catch (Exception e) {
            log.error("收藏夹添加失败");
            throw new RuntimeException("收藏夹添加失败");
        }
    }

    @Override
    public int queryProductCollectionCount(ProductCollection productCollection) {

        try {
            int result = productCollectionDao.queryProductCollectionCount(productCollection);
            return result;
        }catch (Exception e) {
            log.error("收藏夹查询count失败");
            throw new RuntimeException("收藏夹查询count失败");
        }

    }
}
