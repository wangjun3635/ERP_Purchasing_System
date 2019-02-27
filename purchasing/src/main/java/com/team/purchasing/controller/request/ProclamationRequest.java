package com.team.purchasing.controller.request;

import com.team.purchasing.bean.Proclamation;
import com.team.purchasing.common.GeneralRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Auther: 018399
 * @Date: 2019/2/27 19:14
 * @Description:
 */
@Data
@ApiModel(description = "公告请求实体类")
public class ProclamationRequest extends GeneralRequest {

    @ApiModelProperty(value = "公告信息")
    private Proclamation proclamation;

}
