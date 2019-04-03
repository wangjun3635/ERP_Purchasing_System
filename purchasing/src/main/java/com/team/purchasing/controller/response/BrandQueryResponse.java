package com.team.purchasing.controller.response;

import com.team.purchasing.bean.brandquery.BrandQuery;
import com.team.purchasing.common.GeneralResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Auther: 018399
 * @Date: 2019/4/3 09:29
 * @Description:
 */
@Data
@ApiModel(description = "品牌筛选条件响应实体类")
public class BrandQueryResponse extends GeneralResponse {

    @ApiModelProperty
    private List<BrandQuery> brandQueryList;

}
