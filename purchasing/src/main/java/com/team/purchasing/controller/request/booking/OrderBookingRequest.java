package com.team.purchasing.controller.request.booking;

import com.team.purchasing.bean.booking.OrderBooking;
import com.team.purchasing.common.GeneralRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Auther:ynhuang
 * @Date:1/3/19 下午10:58
 */
@Data
@ApiModel(description = "订单预定请求实体类")
public class OrderBookingRequest extends GeneralRequest {

    @ApiModelProperty(value = "订单预定信息")
    private OrderBooking orderBooking;

}
