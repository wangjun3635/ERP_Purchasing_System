package com.team.purchasing.controller;

import com.team.purchasing.bean.Supplier;
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

        Delivery deliveryX = new Delivery();
        deliveryX.setKey("1");
        deliveryX.setValues("现货");
        deliveryTypeList.add(deliveryX);

        Delivery deliveryQ = new Delivery();
        deliveryQ.setKey("2");
        deliveryQ.setValues("期货");
        deliveryTypeList.add(deliveryQ);

        //2 查询供应商数据集合
        List<SupplierName> supplierNameList = supplierDao.getSupplierName();

        //3 品牌数据集合
        List<BrandName> brandNameList = productBrandDao.queryProductBrandNameList();

        //4 产品分类信息
        List<ProductTypeName> productTypeNameList = productDao.queryProductTypeName();

        ProductQueryResponse productQueryResponse = new ProductQueryResponse();

        List<ProductQuery> productQueryList = new ArrayList<>();

        //5 期货参数拼接
        ProductQuery<Delivery> deliveryProductQuery = new ProductQuery<>();
        deliveryProductQuery.setResponseList(deliveryTypeList);
        deliveryProductQuery.setName("期货");
        deliveryProductQuery.setKey("deliveryType");
        productQueryList.add(deliveryProductQuery);

        //6 供应商参数拼接
        ProductQuery<SupplierName> supplierNameProductQuery = new ProductQuery<>();
        supplierNameProductQuery.setResponseList(supplierNameList);
        supplierNameProductQuery.setName("供应商");
        supplierNameProductQuery.setKey("supplierName");
        productQueryList.add(supplierNameProductQuery);

        //7 品牌查询参数拼接
        ProductQuery<BrandName> brandNameProductQuery = new ProductQuery<>();
        brandNameProductQuery.setResponseList(brandNameList);
        brandNameProductQuery.setName("品牌");
        brandNameProductQuery.setKey("brandName");
        productQueryList.add(brandNameProductQuery);

        //8 产品分类信息参数拼接
        ProductQuery<ProductTypeName> productTypeNameProductQuery = new ProductQuery<>();
        productTypeNameProductQuery.setResponseList(productTypeNameList);
        productTypeNameProductQuery.setName("产品分类");
        productTypeNameProductQuery.setKey("productTypeName");
        productQueryList.add(productTypeNameProductQuery);

        productQueryResponse.setProductQueryList(productQueryList);

        return productQueryResponse;
    }
}
