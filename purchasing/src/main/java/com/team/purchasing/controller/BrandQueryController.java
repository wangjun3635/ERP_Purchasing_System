package com.team.purchasing.controller;

import com.team.purchasing.bean.brandquery.BrandQuery;
import com.team.purchasing.bean.productquery.BrandName;
import com.team.purchasing.bean.productquery.ProductQuery;
import com.team.purchasing.bean.productquery.ProductTypeName;
import com.team.purchasing.controller.response.BrandQueryResponse;
import com.team.purchasing.mapper.ProductBrandDao;
import com.team.purchasing.mapper.ProductDao;
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
 * @Date: 2019/4/3 09:25
 * @Description: 品牌查询过滤条件返回
 */
@RestController
@RequestMapping("/brandQuery")
@Api(tags="品牌查询过滤信息接口")
@Slf4j
public class BrandQueryController {

    @Resource
    private ProductDao productDao;

    @Resource
    private ProductBrandDao productBrandDao;

    @PostMapping(value = "/queryBrandQuery")
    @ApiOperation(value="返回2个过滤条件 1、产品分类信息 2、品牌名称信息返回")
    public BrandQueryResponse queryProductQuery(){


        BrandQueryResponse brandQueryResponse = new BrandQueryResponse();

        List<BrandQuery> brandQueryList = new ArrayList<>();

        //1 获取产品分类信息
        List<ProductTypeName> productTypeNameList = productDao.queryProductTypeName();
        BrandQuery<ProductTypeName> brandQuery = new BrandQuery<>();
        brandQuery.setResponseList(productTypeNameList);
        brandQuery.setName("产品分类");
        brandQuery.setKey("productTypeName");
        brandQueryList.add(brandQuery);

        //2 获取品牌名称信息
        List<BrandName> brandNameList = productBrandDao.queryProductBrandNameList();
        BrandQuery<BrandName> brandNameProductQuery = new BrandQuery<>();
        brandNameProductQuery.setResponseList(brandNameList);
        brandNameProductQuery.setName("品牌");
        brandNameProductQuery.setKey("brandName");
        brandQueryList.add(brandNameProductQuery);

        brandQueryResponse.setBrandQueryList(brandQueryList);

        return brandQueryResponse;
    }

}
