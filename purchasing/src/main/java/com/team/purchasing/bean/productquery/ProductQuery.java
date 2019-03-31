package com.team.purchasing.bean.productquery;

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

    @ApiModelProperty(value = "货期 1:现货2：期货 筛选条件的时候直接传key 1 2")
    private List<Delivery> deliveryTypeList;

    @ApiModelProperty(value = "供应商信息: 供应商名称")
    private List<SupplierName> supplierNameList;

    @ApiModelProperty(value = "品牌信息: 品牌名称")
    private List<BrandName> brandNameList;

    @ApiModelProperty(value = "产品分类信息（prodcutTypeName）: 和产品表的firstLevel字段")
    private List<ProductTypeName> productTypeNameList;

}

