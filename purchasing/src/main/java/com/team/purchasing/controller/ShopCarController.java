package com.team.purchasing.controller;

import com.team.purchasing.bean.shopcar.ShopCar;
import com.team.purchasing.common.MessageInfo;
import com.team.purchasing.controller.request.shopcar.ShopCarRequest;
import com.team.purchasing.controller.response.shopcar.ShopCarResponse;
import com.team.purchasing.service.ShopCarService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.annotation.Resource;

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

    @PostMapping("/deleteShopCarProduct")
    @ApiOperation(value="删除购物车商品", notes = "删除购物车商品")
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
    @ApiOperation(value="查询购物车商品", notes = "查询购物车商品")
    public ShopCarResponse queryShopCarListById(@RequestBody ShopCarRequest shopCarRequest){
    	
    	ShopCar shopCar = buildUserInfo(shopCarRequest);
    	List<ShopCar> shopCarList = shopCarService.queryShopCarList(shopCar);
    	
    	ShopCarResponse shopCarResponse = new ShopCarResponse();
    	shopCarResponse.setShopCars(shopCarList);
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
