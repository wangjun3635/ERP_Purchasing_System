package com.team.purchasing.service.impl;

import com.team.purchasing.bean.productcomment.ProductComment;
import com.team.purchasing.mapper.productcomment.ProductCommentDao;
import com.team.purchasing.service.ProductCommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

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

        try {
            ProductComment productComment = productCommentDao.queryProductComment(productId);
            return productComment;
        }catch (Exception e) {
            log.error("查询数据异常,异常信息为: {}", e);
            throw new RuntimeException("[ProductCommentServiceImpl] 查询数据异常");
        }

    }

}
