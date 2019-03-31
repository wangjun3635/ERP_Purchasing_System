package com.team.purchasing.controller.response;

import com.team.purchasing.bean.productquery.ProductQuery;
import com.team.purchasing.common.GeneralResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Auther:ynhuang
 * @Date:19/3/19 下午9:52
 */
@Data
@ApiModel(description = "产品筛选条件响应实体类")
public class ProductQueryResponse extends GeneralResponse {

    @ApiModelProperty
    private ProductQuery productQuery;

}
