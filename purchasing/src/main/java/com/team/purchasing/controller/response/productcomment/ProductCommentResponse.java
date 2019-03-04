package com.team.purchasing.controller.response.productcomment;

import com.team.purchasing.bean.productcomment.ProductComment;
import com.team.purchasing.common.GeneralResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Auther:ynhuang
 * @Date:4/3/19 下午9:36
 */
@Data
@ApiModel(description = "产品评价响应实体类")
public class ProductCommentResponse extends GeneralResponse {

    @ApiModelProperty
    private ProductComment productComment;

}
