package com.team.purchasing.controller;

import com.team.purchasing.bean.orderproduct.OrderProduct;
import com.team.purchasing.controller.request.orderproduct.OrderProductRequest;
import com.team.purchasing.controller.response.orderproduct.OrderProductResponse;
import com.team.purchasing.service.OrderProductService;
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
 * @Date:2/3/19 上午11:33
 */
@RestController
@RequestMapping("/orderProduct")
@Api(tags="订单产品信息查询接口")
@Slf4j
public class OrderProductController {

    @Resource
    private OrderProductService orderProductService;

    @PostMapping("/queryOrderProduct")
    @ApiOperation(value="订单产品信息查询", notes = "订单产品信息查询")
    public OrderProductResponse queryOrderProduct(@RequestBody OrderProductRequest orderProductRequest){

        Long orderId = orderProductRequest.getOrderId();

        List<OrderProduct> orderProducts = orderProductService.queryOrderProductList(orderId);

        OrderProductResponse orderProductResponse = new OrderProductResponse();
        orderProductResponse.setOrderProducts(orderProducts);

        return orderProductResponse;
    }
}
