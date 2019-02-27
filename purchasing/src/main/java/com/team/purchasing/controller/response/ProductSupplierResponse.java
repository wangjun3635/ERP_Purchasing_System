package com.team.purchasing.controller.response;

import com.team.purchasing.bean.Product;
import com.team.purchasing.common.GeneralResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Auther: 018399
 * @Date: 2019/2/27 19:01
 * @Description:
 */
@Data
@ApiModel(description = "查询产品响应实体类")
public class ProductSupplierResponse extends GeneralResponse {

    @ApiModelProperty
    private List<Product> productList;

}
