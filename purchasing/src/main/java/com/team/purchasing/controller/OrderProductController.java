package com.team.purchasing.controller;

import com.team.purchasing.bean.Product;
import com.team.purchasing.bean.ProductSupplierRelation;
import com.team.purchasing.bean.orderproduct.OrderProduct;
import com.team.purchasing.bean.orderproduct.OrderProductDeaily;
import com.team.purchasing.controller.request.orderproduct.OrderProductRequest;
import com.team.purchasing.controller.response.orderproduct.OrderProductResponse;
import com.team.purchasing.mapper.ProductDao;
import com.team.purchasing.service.OrderProductService;
import com.team.purchasing.service.ProductService;
import com.team.purchasing.utils.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
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

    @Resource
    private ProductService productService;

    @PostMapping("/queryOrderProduct")
    @ApiOperation(value="订单产品信息查询", notes = "订单产品信息查询")
    public OrderProductResponse queryOrderProduct(@RequestBody OrderProductRequest orderProductRequest){

        Long orderId = orderProductRequest.getOrderId();

        List<OrderProduct> orderProducts = orderProductService.queryOrderProductList(orderId);

        //拼接产品信息
        List<OrderProductDeaily> orderProductDeailyList = new ArrayList<>();
        orderProducts.stream()
                .filter(x -> x != null)
                .forEach(x -> {
                    ProductSupplierRelation productSupplierRelation = new ProductSupplierRelation();

                    Page page = new Page();
                    page.setCurrentNum(9999);
                    page.setRowNumber(0);

                    productSupplierRelation.setPage(page);
                    productSupplierRelation.setProductId(x.getProductId());

                    // 查询产品信息
                    List<Product> productList = productService.queryProductList(productSupplierRelation);

                    // 开始组装产品信息
                    OrderProductDeaily orderProductDeaily = groupResponese(productList, x);
                    orderProductDeailyList.add(orderProductDeaily);

                });

        OrderProductResponse orderProductResponse = new OrderProductResponse();
        orderProductResponse.setOrderProducts(orderProductDeailyList);

        return orderProductResponse;
    }


    /**
     * covert对象转换
     * @param productList
     * @param orderProduct
     * @return
     */
    private OrderProductDeaily groupResponese(List<Product> productList, OrderProduct orderProduct) {

        OrderProductDeaily orderProductDeaily = new OrderProductDeaily();

        orderProductDeaily.setId(orderProduct.getId());
        orderProductDeaily.setOrderId(orderProduct.getOrderId());
        orderProductDeaily.setOrderNumber(orderProduct.getOrderNumber());
        orderProductDeaily.setBrandId(orderProduct.getBrandId());
        orderProductDeaily.setProductName(orderProduct.getProductName());
        orderProductDeaily.setProductPrice(orderProduct.getProductPrice());
        orderProductDeaily.setProductQuantity(orderProduct.getProductQuantity());
        orderProductDeaily.setCreateTime(orderProduct.getCreateTime());
        orderProductDeaily.setCreateUserId(orderProduct.getCreateUserId());
        orderProductDeaily.setUpdateTime(orderProduct.getUpdateTime());
        orderProductDeaily.setUpdateUserId(orderProduct.getUpdateUserId());

        if(!CollectionUtils.isEmpty(productList)){
            Product productTemp = productList.get(0);
            orderProductDeaily.setProduct(productTemp);
        }

        return orderProductDeaily;
    }
}
