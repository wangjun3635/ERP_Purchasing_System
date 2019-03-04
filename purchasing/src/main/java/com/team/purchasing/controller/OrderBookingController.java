package com.team.purchasing.controller;

import com.team.purchasing.bean.Product;
import com.team.purchasing.bean.booking.OrderBooking;
import com.team.purchasing.bean.orderproduct.OrderProduct;
import com.team.purchasing.controller.request.booking.OrderBookingRequest;
import com.team.purchasing.controller.response.booking.OrderBookingResponse;
import com.team.purchasing.service.OrderBookingService;
import com.team.purchasing.service.OrderProductService;
import com.team.purchasing.service.ProductService;
import com.team.purchasing.utils.OrderIDUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

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

    @Resource
    private OrderProductService orderProductService;

    @PostMapping("/createOrderBooking")
    @ApiOperation(value="预定下单", notes = "预定下单")
    public OrderBookingResponse createOrderBooking(@RequestBody OrderBookingRequest orderBookingRequest){

        OrderBooking orderBooking = orderBookingRequest.getOrderBooking();
        // TODO: 1/3/19 对于订单编号生成的规则确认
        orderBooking.setOrderNumber(OrderIDUtil.getOrderId());

        int bookingOrder = orderBookingService.createBookingOrder(orderBooking);

        OrderBookingResponse orderBookingResponse = new OrderBookingResponse();
        orderBookingResponse.getMessageInfo().setKey(String.valueOf(bookingOrder));

        // TODO: 1/3/19 落地产品信息快照 tb_order_product 收货地址表落地
        createOrderProduct(orderBooking);

        return orderBookingResponse;
    }

    private void createOrderProduct(OrderBooking orderBooking) {

        List<Integer> productIds = orderBooking.getProductIds();
        OrderProduct orderProduct = new OrderProduct();


        productIds.stream()
                .filter(x -> x != null)
                .forEach(x -> {
                    try {
                        orderProductService.addOrderProduct(orderProduct);
                    }catch (Exception e) {
                        log.error("快照数据生成失败,orderId为：{}, productId为:{}", orderBooking.getId(), x , e);
                        throw new RuntimeException("订单产品信息快照数据生成失败");
                    }
                });


    }

    @PostMapping("/cancelOrderBooking")
    @ApiOperation(value="取消订单", notes = "取消订单")
    public OrderBookingResponse cancelOrderBooking(@RequestBody OrderBookingRequest orderBookingRequest){

        OrderBooking orderBooking = orderBookingRequest.getOrderBooking();
        int bookingOrder = orderBookingService.cancelBookingOrder(orderBooking);

        OrderBookingResponse orderBookingResponse = new OrderBookingResponse();
        orderBookingResponse.getMessageInfo().setKey(String.valueOf(bookingOrder));

        return orderBookingResponse;
    }

    @PostMapping("/updateOrderBooking")
    @ApiOperation(value="更新下单信息", notes = "更新下单信息")
    public OrderBookingResponse updateOrderBooking(@RequestBody OrderBookingRequest orderBookingRequest){

        OrderBooking orderBooking = orderBookingRequest.getOrderBooking();
        int bookingOrder = orderBookingService.updateBookingOrder(orderBooking);

        OrderBookingResponse orderBookingResponse = new OrderBookingResponse();
        orderBookingResponse.getMessageInfo().setKey(String.valueOf(bookingOrder));

        return orderBookingResponse;
    }

}
