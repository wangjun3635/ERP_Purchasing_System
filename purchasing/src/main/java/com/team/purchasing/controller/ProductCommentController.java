package com.team.purchasing.controller;

import com.team.purchasing.bean.productcomment.ProductComment;
import com.team.purchasing.controller.request.productcomment.ProductCommentRequest;
import com.team.purchasing.controller.response.productcomment.ProductCommentResponse;
import com.team.purchasing.service.ProductCommentService;
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
 * @Date:4/3/19 下午9:31
 */
@RestController
@RequestMapping("/productComment")
@Api(tags="评价处理接口")
@Slf4j
public class ProductCommentController {

    @Resource
    private ProductCommentService productCommentService;

    @PostMapping("/addProductComment")
    @ApiOperation(value="添加评价数据", notes = "添加评价数据")
    public int updateProductCategory(@RequestBody ProductCommentRequest request){

        ProductComment productComment = request.getProductComment();

        return productCommentService.addComment(productComment);
    }

    @PostMapping("/queryProductComment")
    @ApiOperation(value="添加评价数据", notes = "添加评价数据")
    public ProductCommentResponse queryProductCategory(@RequestBody ProductCommentRequest request){

        ProductComment productComment = request.getProductComment();

        ProductCommentResponse productCommentResponse = new ProductCommentResponse();
        productCommentResponse.setProductComment(productCommentService.queryProductComment(productComment.getProductId()));

        return productCommentResponse;
    }

}
