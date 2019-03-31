package com.team.purchasing.bean.productquery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Auther:ynhuang
 * @Date:31/3/19 上午11:27
 */
@Data
@ApiModel(value="产品筛选条件实体->产品分类信息")
public class ProductTypeName {

    @ApiModelProperty(value = "产品分类信息（prodcutTypeName）: 和产品表的firstLevel字段")
    private String name;

}
