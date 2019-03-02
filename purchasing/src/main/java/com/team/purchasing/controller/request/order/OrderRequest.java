package com.team.purchasing.controller.request.order;

import com.team.purchasing.bean.order.Order;
import com.team.purchasing.common.GeneralRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Auther:ynhuang
 * @Date:2/3/19 上午11:14
 */
@Data
@ApiModel(description = "订单查询请求实体类")
public class OrderRequest extends GeneralRequest {

    @ApiModelProperty(value = "购物车信息")
    private Order order;

}
