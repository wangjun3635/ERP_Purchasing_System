package com.team.purchasing.controller.request;

import com.team.purchasing.bean.ProductSupplierRelation;
import com.team.purchasing.common.GeneralRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Auther: 018399
 * @Date: 2019/2/27 18:58
 * @Description:
 */
@Data
@ApiModel(description = "产品请求实体类")
public class ProductSupplierRequest extends GeneralRequest {

    @ApiModelProperty(value = "产品信息")
    private ProductSupplierRelation productSupplierRelation;

}
