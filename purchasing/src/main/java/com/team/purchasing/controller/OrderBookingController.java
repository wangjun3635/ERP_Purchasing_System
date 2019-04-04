package com.team.purchasing.controller;

import com.team.purchasing.bean.booking.OrderBooking;
import com.team.purchasing.common.MessageInfo;
import com.team.purchasing.controller.request.booking.OrderBookingRequest;
import com.team.purchasing.controller.response.booking.OrderBookingResponse;
import com.team.purchasing.service.OrderBookingService;
import com.team.purchasing.utils.OrderIDUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Auther:ynhuang
 * @Date:1/3/19 下午10:57
 */
@RestController
@RequestMapping("/orderBooking")
@Api(tags="订单下单接口")
@Slf4j
public class OrderBookingController {
    
    @Resource
    private OrderBookingService orderBookingService;

    @PostMapping("/createOrderBooking")
    @ApiOperation(value="预定下单", notes = "预定下单")
    public OrderBookingResponse createOrderBooking(@RequestBody OrderBookingRequest orderBookingRequest){

        OrderBooking orderBooking = buildUserInfo(orderBookingRequest);
        //订单编号自定义生成
        orderBooking.setOrderNumber(OrderIDUtil.getOrderId());

        int bookingOrderId = orderBookingService.createBookingOrder(orderBooking);

        OrderBookingResponse orderBookingResponse = new OrderBookingResponse();
        MessageInfo messageInfo = new MessageInfo();
        if(bookingOrderId != 0){
            messageInfo.setMessageText("下单成功,预定订单id为:" + bookingOrderId + ",订单编号为:" + orderBooking.getOrderNumber());
        }else {
            messageInfo.setMessageText("下单失败");
        }
        messageInfo.setCode("200");
        orderBookingResponse.setMessageInfo(messageInfo);

        OrderBooking orderBookingResp = new OrderBooking();
        orderBookingResp.setId(bookingOrderId);
        orderBookingResp.setOrderNumber(orderBooking.getOrderNumber());

        orderBookingResponse.setOrderBooking(orderBookingResp);

        return orderBookingResponse;
    }

    @PostMapping("/cancelOrderBooking")
    @ApiOperation(value="取消订单", notes = "取消订单")
    public OrderBookingResponse cancelOrderBooking(@RequestBody OrderBookingRequest orderBookingRequest){

        OrderBooking orderBooking = buildUserInfo(orderBookingRequest);
        int bookingOrder = orderBookingService.cancelBookingOrder(orderBooking);

        OrderBookingResponse orderBookingResponse = new OrderBookingResponse();
        MessageInfo messageInfo = new MessageInfo();
        if(bookingOrder != 0) {
            messageInfo.setMessageText("取消订单成功");
        }else {
            messageInfo.setMessageText("取消订单失败");
        }
        messageInfo.setCode("200");
        orderBookingResponse.setMessageInfo(messageInfo);

        return orderBookingResponse;
    }

    @PostMapping("/updateOrderBooking")
    @ApiOperation(value="更新下单信息", notes = "更新下单信息")
    public OrderBookingResponse updateOrderBooking(@RequestBody OrderBookingRequest orderBookingRequest){

        OrderBooking orderBooking = buildUserInfo(orderBookingRequest);
        int bookingOrder = orderBookingService.updateBookingOrder(orderBooking);

        OrderBookingResponse orderBookingResponse = new OrderBookingResponse();
        MessageInfo messageInfo = new MessageInfo();
        if(bookingOrder != 0) {
            messageInfo.setMessageText("更新订单成功");
        }else {
            messageInfo.setMessageText("更新订单失败");
        }
        messageInfo.setCode("200");
        orderBookingResponse.setMessageInfo(messageInfo);

        return orderBookingResponse;
    }

    private OrderBooking buildUserInfo(OrderBookingRequest orderBookingRequest) {

        OrderBooking orderBooking = orderBookingRequest.getOrderBooking();

        orderBooking.setUserId(orderBookingRequest.getBaseUserInfo().getUserId());
        orderBooking.setHCId(orderBookingRequest.getBaseUserInfo().getHcId());

        orderBooking.setCreateUserId(orderBooking.getUserId() == null ? orderBooking.getHCId() : orderBooking.getUserId());
        orderBooking.setUpdateUserId(orderBooking.getUserId() == null ? orderBooking.getHCId() : orderBooking.getUserId());

        return orderBooking;
    }

}
