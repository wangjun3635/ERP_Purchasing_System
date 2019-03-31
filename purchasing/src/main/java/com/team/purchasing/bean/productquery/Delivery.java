package com.team.purchasing.bean.productquery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Auther:ynhuang
 * @Date:31/3/19 上午11:25
 */
@Data
@ApiModel(value="产品筛选条件实体 - 期货")
public class Delivery {

    @ApiModelProperty(value = "key 1 2")
    private String key;

    @ApiModelProperty(value = "1:现货2：期货")
    private String values;
}
