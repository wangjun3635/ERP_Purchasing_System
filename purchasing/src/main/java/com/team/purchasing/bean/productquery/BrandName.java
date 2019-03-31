package com.team.purchasing.bean.productquery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Auther:ynhuang
 * @Date:31/3/19 上午11:27
 */
@Data
@ApiModel(value="产品筛选条件实体-> 品牌")
public class BrandName {

    @ApiModelProperty(value = "品牌信息: 品牌名称")
    private String name;
}
