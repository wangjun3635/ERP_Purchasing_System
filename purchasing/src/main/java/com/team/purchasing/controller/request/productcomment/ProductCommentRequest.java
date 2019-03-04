package com.team.purchasing.controller.request.productcomment;

import com.team.purchasing.bean.productcomment.ProductComment;
import com.team.purchasing.common.GeneralRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Auther:ynhuang
 * @Date:4/3/19 下午9:33
 */
@Data
@ApiModel(description = "商品评价查询请求实体类")
public class ProductCommentRequest extends GeneralRequest {

    @ApiModelProperty(value = "商品评价实体")
    private ProductComment productComment;

}
