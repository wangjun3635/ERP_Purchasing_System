package com.team.purchasing.controller.response.booking;

import com.team.purchasing.bean.booking.OrderBooking;
import com.team.purchasing.common.GeneralResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Auther:ynhuang
 * @Date:1/3/19 下午11:01
 */
@Data
@ApiModel(description = "下单预定响应实体类")
public class OrderBookingResponse extends GeneralResponse {

    @ApiModelProperty
    private OrderBooking orderBooking;

}
