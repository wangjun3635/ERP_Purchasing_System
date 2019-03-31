package com.team.purchasing.controller;

import com.team.purchasing.bean.productquery.*;
import com.team.purchasing.controller.response.ProductQueryResponse;
import com.team.purchasing.mapper.ProductBrandDao;
import com.team.purchasing.mapper.ProductDao;
import com.team.purchasing.mapper.SupplierDao;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 018399
 * @Date: 2019/3/29 12:09
 * @Description:
 */
@RestController
@RequestMapping("/productQuery")
@Api(tags="产品查询过滤信息接口")
@Slf4j
public class ProductQueryController {

    @Resource
    private SupplierDao supplierDao;

    @Resource
    private ProductBrandDao productBrandDao;

    @Resource
    private ProductDao productDao;

    ////期货、分类、品牌、代理商、化学品级别、安全级别
    @PostMapping(value = "/queryProductQuery")
    @ApiOperation(value="产品查询过滤信息返回接口, " +
            "货期 1:现货2：期货, " +
            "供应商信息: 供应商名称, " +
            "品牌信息: 品牌名称, " +
            "产品分类信息: 和产品表的firstLevel字段")
    public ProductQueryResponse queryProductQuery(){

        //1 货期信息返回
        List<Delivery> deliveryTypeList = new ArrayList<>();

        Delivery delivery = new Delivery();
        delivery.setKey("1");
        delivery.setValues("现货");
        deliveryTypeList.add(delivery);

        delivery.setKey("2");
        delivery.setValues("期货");
        deliveryTypeList.add(delivery);

        //2 查询供应商数据集合
        List<SupplierName> supplierNameList = supplierDao.getSupplierName();

        //3 品牌数据集合
        List<BrandName> brandNameList = productBrandDao.queryProductBrandNameList();

        //4 产品分类信息
        List<ProductTypeName> productTypeNameList = productDao.queryProductTypeName();

        ProductQueryResponse productQueryResponse = new ProductQueryResponse();

        ProductQuery productQuery = new ProductQuery();
        productQuery.setDeliveryTypeList(deliveryTypeList);
        productQuery.setSupplierNameList(supplierNameList);
        productQuery.setBrandNameList(brandNameList);
        productQuery.setProductTypeNameList(productTypeNameList);

        productQueryResponse.setProductQuery(productQuery);

        return productQueryResponse;
    }
}
