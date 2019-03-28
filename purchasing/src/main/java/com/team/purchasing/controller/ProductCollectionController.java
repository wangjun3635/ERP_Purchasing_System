package com.team.purchasing.controller;

import com.team.purchasing.bean.ProductCollection;
import com.team.purchasing.common.MessageInfo;
import com.team.purchasing.controller.request.ProductCollectionRequest;
import com.team.purchasing.controller.response.ProductCollectionResponse;
import com.team.purchasing.service.ProductCollectionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: 018399
 * @Date: 2019/3/23 14:37
 * @Description:
 */
@RestController
@RequestMapping("/productCollection")
@Api(tags="产品收藏夹接口")
public class ProductCollectionController {

    @Resource
    private ProductCollectionService productCollectionService;

    @PostMapping("/queryProductCollection")
    @ApiOperation(value="产品收藏夹查询", notes = "产品收藏夹查询")
    public ProductCollectionResponse queryProductCollection(@RequestBody ProductCollectionRequest request){

        ProductCollection productCollection = request.getProductCollection();

        //1 更新page
        Integer count = productCollectionService.queryProductCollectionCount(productCollection);

        productCollection.getPage().init(count);

        List<ProductCollection> productCollections = productCollectionService.queryProductCollectionList(productCollection);

        ProductCollectionResponse productCollectionResponse = new ProductCollectionResponse();
        productCollectionResponse.setProductCollections(productCollections);
        productCollectionResponse.setPage(productCollection.getPage());

        return productCollectionResponse;
    }

    @PostMapping("/addProductCollection")
    @ApiOperation(value="产品收藏夹添加", notes = "产品收藏夹添加")
    public ProductCollectionResponse addProductCollection(@RequestBody ProductCollectionRequest request){

        ProductCollection productCollection = request.getProductCollection();

        int result = productCollectionService.addProductCollection(productCollection);

        ProductCollectionResponse productCollectionResponse = new ProductCollectionResponse();

        MessageInfo messageInfo = new MessageInfo();
        messageInfo.setCode("200");
        if(result != 0){
            messageInfo.setMessageText("添加成功");
        }else {
            messageInfo.setMessageText("添加失败");
        }
        productCollectionResponse.setMessageInfo(messageInfo);

        return productCollectionResponse;
    }

    @PostMapping("/updateProductCollection")
    @ApiOperation(value="产品收藏夹更新", notes = "产品收藏夹更新")
    public ProductCollectionResponse updateProductCollection(@RequestBody ProductCollectionRequest request){

        ProductCollection productCollection = request.getProductCollection();

        int result = productCollectionService.updateProductCollection(productCollection);

        ProductCollectionResponse productCollectionResponse = new ProductCollectionResponse();

        MessageInfo messageInfo = new MessageInfo();
        messageInfo.setCode("200");
        if(result != 0){
            messageInfo.setMessageText("更新成功");
        }else {
            messageInfo.setMessageText("更新失败");
        }
        productCollectionResponse.setMessageInfo(messageInfo);

        return productCollectionResponse;
    }

    @PostMapping("/deleteProductCollection")
    @ApiOperation(value="产品收藏夹删除", notes = "产品收藏夹删除")
    public ProductCollectionResponse deleteProductCollection(@RequestBody ProductCollectionRequest request){

        ProductCollection productCollection = request.getProductCollection();

        int result = productCollectionService.deleteProductCollection(productCollection);

        ProductCollectionResponse productCollectionResponse = new ProductCollectionResponse();

        MessageInfo messageInfo = new MessageInfo();
        messageInfo.setCode("200");
        if(result != 0){
            messageInfo.setMessageText("删除成功");
        }else {
            messageInfo.setMessageText("删除失败");
        }
        productCollectionResponse.setMessageInfo(messageInfo);

        return productCollectionResponse;
    }

}
