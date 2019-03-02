package com.team.purchasing.controller.response.order;

import com.team.purchasing.bean.order.Order;
import com.team.purchasing.common.GeneralResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Auther:ynhuang
 * @Date:2/3/19 上午11:15
 */
@Data
@ApiModel(description = "订单查询响应实体类")
public class OrderResponse extends GeneralResponse {

    @ApiModelProperty
    private List<Order> orders;

}
