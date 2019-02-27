package com.team.purchasing.controller.request;

import com.team.purchasing.bean.Promotion;
import com.team.purchasing.common.GeneralRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Auther: 018399
 * @Date: 2019/2/27 19:06
 * @Description:
 */
@Data
@ApiModel(description = "促销活动请求实体类")
public class PromotionRequest extends GeneralRequest {

    @ApiModelProperty(value = "促销活动信息")
    private Promotion promotion;

}
