package com.team.purchasing.mapper.productcomment;

import com.team.purchasing.bean.productcomment.ProductComment;
import org.apache.ibatis.annotations.Param;

/**
 * @Auther:ynhuang
 * @Date:4/3/19 下午9:16
 */
public interface ProductCommentDao {

    /** 添加评价,针对每个产品 **/
    public int addComment(@Param("productComment") ProductComment productComment);

    public ProductComment queryProductComment(@Param("productId") int productId);

}
