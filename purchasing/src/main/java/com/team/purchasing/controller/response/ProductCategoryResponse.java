package com.team.purchasing.controller.response;

import com.team.purchasing.bean.ProductCategory;
import com.team.purchasing.common.GeneralResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Auther: 018399
 * @Date: 2019/2/27 19:21
 * @Description:
 */
@Data
@ApiModel(description = "产品类别相应实体类")
public class ProductCategoryResponse extends GeneralResponse {

    @ApiModelProperty
    private List<ProductCategory> productCategoryList;

}
