package com.team.purchasing.controller.request;

import com.team.purchasing.bean.ProductCategory;
import com.team.purchasing.common.GeneralRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Auther: 018399
 * @Date: 2019/2/27 19:20
 * @Description:
 */
@Data
@ApiModel(description = "产品类别请求实体类")
public class ProductCategoryRequest extends GeneralRequest {

    @ApiModelProperty(value = "产品类别")
    private ProductCategory productCategory;

}
