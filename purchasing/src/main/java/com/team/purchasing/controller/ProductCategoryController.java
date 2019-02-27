package com.team.purchasing.controller;

import com.team.purchasing.bean.ProductCategory;
import com.team.purchasing.controller.request.ProductCategoryRequest;
import com.team.purchasing.service.ProductCategoryService;
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
 * @Date:24/2/19 下午4:00
 */
@RestController
@RequestMapping("/productCategory")
@Api(tags="产品类型接口")
@Slf4j
public class ProductCategoryController {

    @Resource
    private ProductCategoryService productCategoryService;

    @PostMapping("/updateProductCategory")
    @ApiOperation(value="产品类型数据更新", notes = "产品类型数据更新")
    public int updateProductCategory(@RequestBody ProductCategoryRequest request){

        ProductCategory productCategory = request.getProductCategory();

        return productCategoryService.updateProductCategory(productCategory);
    }
}
