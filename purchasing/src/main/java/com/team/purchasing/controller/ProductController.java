package com.team.purchasing.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.team.purchasing.bean.Product;
import com.team.purchasing.bean.ProductSupplierRelation;
import com.team.purchasing.controller.request.ProductSupplierRequest;
import com.team.purchasing.controller.response.ProductSupplierResponse;
import com.team.purchasing.service.ProductService;
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
 * @Date:24/2/19 上午11:42
 */
@RestController
@RequestMapping("/product")
@Api(tags="产品查询接口")
@Slf4j
public class ProductController {

    @Resource
    private ProductService productService;

    @PostMapping("/getProductList")
    @ApiOperation(value="产品信息查询", notes = "产品信息查询")
    public ProductSupplierResponse queryProductList(@RequestBody ProductSupplierRequest request) throws JsonProcessingException {

        ProductSupplierRelation product = request.getProductSupplierRelation();

        //1 更新page
        int count = productService.queryProductCount(product);
        product.getPage().init(count);

        //2 查询数据
        List<Product> products = productService.queryProductList(product);

        //4 拼接参数
        ProductSupplierResponse productSupplierResponse = new ProductSupplierResponse();
        productSupplierResponse.setProductList(products);

        return productSupplierResponse;
    }

}
