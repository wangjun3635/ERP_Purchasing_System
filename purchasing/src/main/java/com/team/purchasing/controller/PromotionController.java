package com.team.purchasing.controller;

import com.team.purchasing.bean.Promotion;
import com.team.purchasing.bean.shopcar.ShopCar;
import com.team.purchasing.common.MessageInfo;
import com.team.purchasing.controller.request.PromotionRequest;
import com.team.purchasing.controller.request.shopcar.ShopCarRequest;
import com.team.purchasing.controller.response.PromotionResponse;
import com.team.purchasing.service.PromotionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther:ynhuang
 * @Date:19/2/19 下午9:30
 */
@RestController
@RequestMapping("/promotion")
@Api(tags="促销活动接口")
@Slf4j
public class PromotionController {

    @Resource
    private PromotionService promotionService;

    @PostMapping("/queryProclamation")
    @ApiOperation(value="促销活动信息查询", notes = "促销活动信息查询")
    public PromotionResponse queryProclamationByPage(@RequestBody PromotionRequest request) {

        Promotion promotion = buildUserInfo(request);

        //更新page
        int count = promotionService.queryPromotionCount();
        promotion.getPage().init(count);

        List<Promotion> promotions = promotionService.queryPromotionList(promotion);


        //参数拼接
        PromotionResponse promotionResponse = new PromotionResponse();
        promotionResponse.setPromotionList(promotions);
        promotionResponse.setPage(promotion.getPage());

        return promotionResponse;
    }

    // TODO: 24/2/19 促销不需要审核，创建好后直接在商城展示, 促销要有图片【需要考虑图片的存储】
    // TODO: 1/3/19 图片存储考虑使用websocket做文件上传 
    @PostMapping("/addProclamation")
    @ApiOperation(value="促销信息添加,促销不需要审核，创建好后直接在商城展示", notes = "促销信息添加")
    public PromotionResponse addProclamation(@RequestBody PromotionRequest request){

        Promotion promotion = buildUserInfo(request);
        int result = promotionService.addPromotion(promotion);

        PromotionResponse promotionResponse = new PromotionResponse();
        MessageInfo messageInfo = new MessageInfo();
        messageInfo.setCode("200");
        if(result == 1) {
            messageInfo.setMessageText("新增成功!");
        }else {
            messageInfo.setMessageText("新增失败!");
        }
        promotionResponse.setMessageInfo(messageInfo);

        return promotionResponse;
    }

    private Promotion buildUserInfo(PromotionRequest promotionRequest) {

        Promotion promotion = promotionRequest.getPromotion();

        promotion.setCreateUserId(promotionRequest.getBaseUserInfo().getUserId() == null
                ? promotionRequest.getBaseUserInfo().getHcId()
                : promotionRequest.getBaseUserInfo().getUserId());
        promotion.setUpdateUserId(promotionRequest.getBaseUserInfo().getUserId() == null
                ? promotionRequest.getBaseUserInfo().getHcId()
                : promotionRequest.getBaseUserInfo().getUserId());
        return promotion;
    }

    
}
