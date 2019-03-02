package com.team.purchasing.controller.request.orderproduct;

import com.team.purchasing.common.GeneralRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Auther:ynhuang
 * @Date:2/3/19 上午11:34
 */
@Data
@ApiModel(description = "订单产品信息查询请求实体类")
public class OrderProductRequest  extends GeneralRequest {

    @ApiModelProperty(value = "订单id")
    private Long orderId;

}
