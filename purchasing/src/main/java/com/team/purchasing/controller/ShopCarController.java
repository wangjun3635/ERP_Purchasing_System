package com.team.purchasing.controller;

import com.team.purchasing.bean.shopcar.ShopCar;
import com.team.purchasing.controller.request.shopcar.ShopCarRequest;
import com.team.purchasing.controller.response.shopcar.ShopCarResponse;
import com.team.purchasing.service.ShopCarService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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

        ShopCar shopCar = shopCarRequest.getShopCar();
        int result = shopCarService.addShopCarProduct(shopCar);

        ShopCarResponse shopCarResponse = new ShopCarResponse();
        shopCarResponse.getMessageInfo().setKey(String.valueOf(result));

        return shopCarResponse;
    }

    @PostMapping("/deleteShopCarProduct")
    @ApiOperation(value="删除购物车商品", notes = "删除购物车商品")
    public ShopCarResponse deleteShopCarProduct(@RequestBody ShopCarRequest shopCarRequest){

        ShopCar shopCar = shopCarRequest.getShopCar();
        int result = shopCarService.deleteShopCarProduct(shopCar);

        ShopCarResponse shopCarResponse = new ShopCarResponse();
        shopCarResponse.getMessageInfo().setKey(String.valueOf(result));

        return shopCarResponse;
    }

}
