package com.team.purchasing.bean.productquery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Auther:ynhuang
 * @Date:31/3/19 上午11:26
 */
@Data
@ApiModel(value="产品筛选条件实体-> 供应商名称")
public class SupplierName {
    @ApiModelProperty(value = "供应商信息: 供应商名称")
    private String name;
}
