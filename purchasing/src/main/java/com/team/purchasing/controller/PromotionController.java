package com.team.purchasing.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.team.purchasing.bean.Promotion;
import com.team.purchasing.controller.request.PromotionRequest;
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

    @PostMapping("/getProclamation")
    @ApiOperation(value="促销活动信息查询", notes = "促销活动信息查询")
    public PromotionResponse queryProclamationByPage(@RequestBody PromotionRequest request) {

        Promotion promotion = request.getPromotion();

        //更新page
        int count = promotionService.queryPromotionCount();
        promotion.getPage().init(count);

        List<Promotion> promotions = promotionService.queryPromotionList(promotion);


        //参数拼接
        PromotionResponse promotionResponse = new PromotionResponse();
        promotionResponse.setPromotionList(promotions);

        return promotionResponse;
    }

    // TODO: 24/2/19 促销不需要审核，创建好后直接在商城展示, 促销要有图片【需要考虑图片的存储】
    @PostMapping("/addProclamation")
    @ApiOperation(value="公告信息添加", notes = "公告信息添加")
    public int addProclamation(@RequestBody Promotion promotion){
        int result = promotionService.addPromotion(promotion);
        return result;
    }

    
}
