package com.team.purchasing.service;

import com.team.purchasing.bean.productcomment.ProductComment;

/**
 * @Auther:ynhuang
 * @Date:4/3/19 下午9:27
 */
public interface ProductCommentService {

    /** 添加评价,针对每个产品 **/
    public int addComment(ProductComment productComment);

    public ProductComment queryProductComment(int productId);


}
