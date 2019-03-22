package com.team.purchasing.controller.response;

import com.team.purchasing.bean.ProductBrand;
import com.team.purchasing.common.GeneralResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Auther:ynhuang
 * @Date:19/3/19 下午9:52
 */
@Data
@ApiModel(description = "品牌响应实体类")
public class ProductBrandResponse extends GeneralResponse {

    @ApiModelProperty
    private List<ProductBrand> productBrands;

}
