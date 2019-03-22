package com.team.purchasing.controller;

import com.team.purchasing.bean.order.Order;
import com.team.purchasing.controller.request.order.OrderRequest;
import com.team.purchasing.controller.response.order.OrderResponse;
import com.team.purchasing.service.OrderService;
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
 * @Date:2/3/19 上午10:49
 */
@RestController
@RequestMapping("/order")
@Api(tags="订单查询接口")
@Slf4j
public class OrderController {

    @Resource
    private OrderService orderService;

    @PostMapping("/queryOrderList")
    @ApiOperation(value="订单信息查询", notes = "订单信息查询")
    public OrderResponse queryOrderList(@RequestBody OrderRequest orderRequest){

        Order order = orderRequest.getOrder();
        //初始化分页
        int count = orderService.queryOrderCount(order);
        order.getPage().init(count);

        //查询
        List<Order> orders = orderService.queryOrderList(order);

        //参数拼接
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrders(orders);
        orderResponse.setPage(order.getPage());

        return orderResponse;
    }

}
