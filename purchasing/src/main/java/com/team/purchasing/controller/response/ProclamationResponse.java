package com.team.purchasing.controller.response;

import com.team.purchasing.bean.Proclamation;
import com.team.purchasing.common.GeneralResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Auther: 018399
 * @Date: 2019/2/27 19:17
 * @Description:
 */
@Data
@ApiModel(description = "查询公告响应实体类")
public class ProclamationResponse extends GeneralResponse {

    @ApiModelProperty
    private List<Proclamation> proclamationList;
}
