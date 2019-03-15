package com.team.purchasing.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team.purchasing.bean.productcomment.ProductComment;
import com.team.purchasing.mapper.productcomment.ProductCommentDao;
import com.team.purchasing.service.ProductCommentService;

import lombok.extern.slf4j.Slf4j;

/**
 * @Auther:ynhuang
 * @Date:4/3/19 下午9:28
 */
@Service
@Slf4j
public class ProductCommentServiceImpl implements ProductCommentService {

    @Resource
    private ProductCommentDao productCommentDao;

    @Override
    @Transactional
    public int addComment(ProductComment productComment) {

        try {
            int result = productCommentDao.addComment(productComment);
            return result;
        }catch (Exception e){
            log.error("添加评价失败,当前为：{}", productComment, e);
            throw new RuntimeException("添加评价失败");
        }
    }

    @Override
    public ProductComment queryProductComment(int productId) {
        return productCommentDao.queryProductComment(productId);
    }

}
