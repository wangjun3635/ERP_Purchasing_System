package com.team.purchasing.controller.request;

import com.team.purchasing.bean.ProductBrand;
import com.team.purchasing.common.GeneralRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Auther:ynhuang
 * @Date:19/3/19 下午9:49
 */
@Data
@ApiModel(description = "产品品牌请求实体类")
public class ProductBrandRequest extends GeneralRequest {

    @ApiModelProperty(value = "品牌信息")
    private ProductBrand productBrand;

}
