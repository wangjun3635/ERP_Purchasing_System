package com.team.purchasing.controller;

import com.team.purchasing.bean.productcomment.ProductComment;
import com.team.purchasing.common.MessageInfo;
import com.team.purchasing.controller.request.productcomment.ProductCommentRequest;
import com.team.purchasing.controller.response.PromotionResponse;
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
    public ProductCommentResponse addProductCategory(@RequestBody ProductCommentRequest request){

        ProductComment productComment = request.getProductComment();

        int result = productCommentService.addComment(productComment);

        ProductCommentResponse productCommentResponse = new ProductCommentResponse();
        MessageInfo messageInfo = new MessageInfo();
        messageInfo.setCode("200");
        if(result == 1) {
            messageInfo.setMessageText("新增成功!");
        }else {
            messageInfo.setMessageText("新增失败!");
        }
        productCommentResponse.setMessageInfo(messageInfo);

        return productCommentResponse;
    }

    @PostMapping("/queryProductComment")
    @ApiOperation(value="查询评价数据", notes = "查询评价数据")
    public ProductCommentResponse queryProductCategory(@RequestBody ProductCommentRequest request){

        ProductComment productComment = request.getProductComment();

        ProductCommentResponse productCommentResponse = new ProductCommentResponse();
        productCommentResponse.setProductComment(productCommentService.queryProductComment(productComment.getProductId()));

        return productCommentResponse;
    }

}
