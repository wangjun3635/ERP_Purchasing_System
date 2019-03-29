package com.team.purchasing.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Auther: 018399
 * @Date: 2019/3/29 13:37
 * @Description:
 */
@Data
@ApiModel(value="产品筛选条件实体")
public class ProductQuery {

    @ApiModelProperty(value = "货期 1:现货2：期货")
    private List<Integer> deliveryTypeList;

    @ApiModelProperty(value = "供应商信息: 供应商名称")
    private List<String> supplierNameList;

    @ApiModelProperty(value = "品牌信息: 品牌名称")
    private List<String> brandNameList;

    @ApiModelProperty(value = "产品分类信息（prodcutTypeName）: 和产品表的firstLevel字段")
    private List<String> productTypeNameList;

}
