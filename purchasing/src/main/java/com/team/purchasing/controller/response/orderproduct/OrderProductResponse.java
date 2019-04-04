package com.team.purchasing.controller.response.orderproduct;

import com.team.purchasing.bean.orderproduct.OrderProductDeaily;
import com.team.purchasing.common.GeneralResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Auther:ynhuang
 * @Date:2/3/19 上午11:36
 */
@Data
@ApiModel(description = "订单产品信息查询响应实体类")
public class OrderProductResponse extends GeneralResponse {

    @ApiModelProperty
    private List<OrderProductDeaily> orderProducts;

}
