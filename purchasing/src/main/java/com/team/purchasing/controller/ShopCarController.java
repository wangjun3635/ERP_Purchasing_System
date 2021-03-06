package com.team.purchasing.controller;

import com.team.purchasing.bean.Product;
import com.team.purchasing.bean.ProductSupplierRelation;
import com.team.purchasing.bean.shopcar.ShopCar;
import com.team.purchasing.bean.shopcar.ShopCarBatchDelete;
import com.team.purchasing.bean.shopcar.ShopCarProduct;
import com.team.purchasing.common.MessageInfo;
import com.team.purchasing.controller.request.shopcar.ShopCarDelteBatchRequest;
import com.team.purchasing.controller.request.shopcar.ShopCarRequest;
import com.team.purchasing.controller.response.shopcar.ShopCarResponse;
import com.team.purchasing.service.ProductService;
import com.team.purchasing.service.ShopCarService;
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
 * @Date:1/3/19 下午9:44
 */
@RestController
@RequestMapping("/shopCar")
@Api(tags="购物车接口")
@Slf4j
public class ShopCarController {

    @Resource
    private ShopCarService shopCarService;
    
    @Resource
    private ProductService productService;

    @PostMapping("/addShopCarProduct")
    @ApiOperation(value="添加购物车商品", notes = "添加购物车商品")
    public ShopCarResponse addShopCarProduct(@RequestBody ShopCarRequest shopCarRequest){

        ShopCar shopCar = buildUserInfo(shopCarRequest);
        
        int result = shopCarService.addShopCarProduct(shopCar);

        ShopCarResponse shopCarResponse = new ShopCarResponse();
        MessageInfo messageInfo = new MessageInfo();
        messageInfo.setCode("200");
        if(result == 1) {
            messageInfo.setMessageText("添加成功!");
        }else {
            messageInfo.setMessageText("添加失败!");
        }
        shopCarResponse.setMessageInfo(messageInfo);

        return shopCarResponse;
    }

    @PostMapping("/batchDeleteShopCarProduct")
    @ApiOperation(value="批量删除购物车商品 通过用户id或者购物车id删除购物车信息")
    public ShopCarResponse batchDeleteShopCarProduct(@RequestBody ShopCarDelteBatchRequest shopCarDelteBatchRequest){


        List<ShopCarBatchDelete> shopCarBatchDeletes = shopCarDelteBatchRequest.getShopCarBatchDeletes();

        int result = shopCarService.batchDeleteShopCarProduct(shopCarBatchDeletes);

        ShopCarResponse shopCarResponse = new ShopCarResponse();
        MessageInfo messageInfo = new MessageInfo();
        messageInfo.setCode("200");
        if(result == 1) {
            messageInfo.setMessageText("删除成功!");
        }else {
            messageInfo.setMessageText("删除失败!");
        }
        shopCarResponse.setMessageInfo(messageInfo);

        return shopCarResponse;
    }

    @PostMapping("/deleteShopCarProduct")
    @ApiOperation(value="删除购物车商品 通过用户id或者购物车id删除购物车信息", notes = "删除购物车商品 通过用户id或者购物车id删除购物车信息")
    public ShopCarResponse deleteShopCarProduct(@RequestBody ShopCarRequest shopCarRequest){

        ShopCar shopCar = buildUserInfo(shopCarRequest);
        int result = shopCarService.deleteShopCarProduct(shopCar);

        ShopCarResponse shopCarResponse = new ShopCarResponse();
        MessageInfo messageInfo = new MessageInfo();
        messageInfo.setCode("200");
        if(result == 1) {
            messageInfo.setMessageText("删除成功!");
        }else {
            messageInfo.setMessageText("删除失败!");
        }
        shopCarResponse.setMessageInfo(messageInfo);

        return shopCarResponse;
    }
    
    @PostMapping("/queryShopCarListById")
    @ApiOperation(value="查询购物车商品 可以通过用户id和商品id查询购物车信息", notes = "查询购物车商品 可以通过用户id和商品id查询购物车信息")
    public ShopCarResponse queryShopCarListById(@RequestBody ShopCarRequest shopCarRequest){
    	
    	ShopCar shopCar = buildUserInfo(shopCarRequest);

        ShopCarResponse shopCarResponse = new ShopCarResponse();
    	//1 设置分页信息
        int count = shopCarService.queryShopCatCount(shopCar);
        shopCar.getPage().init(count);

        //2 查询购物车信息
        List<ShopCar> shopCarList = shopCarService.queryShopCarList(shopCar);

        //3 shopCarProduct集合组装
        List<ShopCarProduct> shopCarProductList = new ArrayList<>();

    	//4 通过产品id获取产品信息
        shopCarList.stream()
                .filter(shopCarBean -> shopCarBean.getProductId() != null)
                .forEach(shopCarBean -> {
                    Integer productId = shopCarBean.getProductId();
                    ProductSupplierRelation productSupplierRelation = new ProductSupplierRelation();
                    productSupplierRelation.setProductId(productId);
                    Page page = new Page();
                    page.setCurrentNum(9999);
                    page.setRowNumber(0);
                    productSupplierRelation.setPage(page);
                    //4.1 查询产品信息
                    List<Product> products = productService.queryProductList(productSupplierRelation);

                    ShopCarProduct shopCarProduct = new ShopCarProduct();
                    if(!CollectionUtils.isEmpty(products)){
                        Product product = products.get(0);
                        shopCarProduct.setProduct(product);
                        shopCarProduct.setId(shopCarBean.getId());
                        shopCarProduct.setHSCId(shopCarBean.getHSCId());
                        shopCarProduct.setUserId(shopCarBean.getUserId());
                        shopCarProduct.setQuantity(shopCarBean.getQuantity());
                        shopCarProduct.setIsValid(shopCarBean.getIsValid());
                        shopCarProduct.setCreateTime(shopCarBean.getCreateTime());
                        shopCarProduct.setCreateUserId(shopCarBean.getCreateUserId());
                        shopCarProduct.setUpdateTime(shopCarBean.getUpdateTime());
                        shopCarProduct.setUpdateUserId(shopCarBean.getUpdateUserId());
                        shopCarProduct.setPage(shopCarBean.getPage());
                    }

                    shopCarProductList.add(shopCarProduct);

                });

        shopCarResponse.setShopCarProducts(shopCarProductList);
        shopCarResponse.setPage(shopCar.getPage());
    	
    	return shopCarResponse;
    }

    private ShopCar buildUserInfo(ShopCarRequest shopCarRequest) {

        ShopCar shopCar = shopCarRequest.getShopCar();

        shopCar.setUserId(shopCarRequest.getBaseUserInfo().getUserId());
        shopCar.setHSCId(shopCarRequest.getBaseUserInfo().getHcId());

        shopCar.setCreateUserId(shopCarRequest.getBaseUserInfo().getUserId() == null
                ? shopCarRequest.getBaseUserInfo().getHcId() : shopCarRequest.getBaseUserInfo().getUserId());
        shopCar.setUpdateUserId(shopCarRequest.getBaseUserInfo().getUserId() == null
                ? shopCarRequest.getBaseUserInfo().getHcId() : shopCarRequest.getBaseUserInfo().getUserId());

        return shopCar;
    }

}
