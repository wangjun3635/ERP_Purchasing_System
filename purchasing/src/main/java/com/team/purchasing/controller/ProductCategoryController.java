package com.team.purchasing.controller;

import com.team.purchasing.bean.ProductCategory;
import com.team.purchasing.common.MessageInfo;
import com.team.purchasing.controller.request.ProductCategoryRequest;
import com.team.purchasing.controller.response.ProclamationResponse;
import com.team.purchasing.controller.response.ProductCategoryResponse;
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
    public ProductCategoryResponse updateProductCategory(@RequestBody ProductCategoryRequest request){

        ProductCategory productCategory = request.getProductCategory();

        int result = productCategoryService.updateProductCategory(productCategory);

        ProductCategoryResponse productCategoryResponse = new ProductCategoryResponse();
        MessageInfo messageInfo = new MessageInfo();
        messageInfo.setCode("200");
        if(result == 1) {
            messageInfo.setMessageText("新增成功!");
        }else {
            messageInfo.setMessageText("新增失败!");
        }
        productCategoryResponse.setMessageInfo(messageInfo);

        return productCategoryResponse;
    }
}
