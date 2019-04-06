package com.team.purchasing.bean.productcollection;

import com.team.purchasing.bean.Product;
import com.team.purchasing.utils.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Auther:ynhuang
 * @Date:6/4/19 下午10:12
 */
@Data
@ApiModel(value="商品收藏夹返回实体，加入产品详细信息")
public class ProductCollectionRelationProduct {

    @ApiModelProperty(value = "商品收藏夹id")
    private Integer id;

    @ApiModelProperty(value = "商品信息")
    private Product product;

    @ApiModelProperty(value = "医院或者院校id")
    private Long hcId;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "删除标志（0未删除，1删除）")
    private Integer isValid;

    @ApiModelProperty(value = "创建时间")
    private String createTime;

    @ApiModelProperty(value = "创建用户id")
    private Long createUserId;

    @ApiModelProperty(value = "更新时间")
    private String modifyTime;

    @ApiModelProperty(value = "更新用户id")
    private Long modifyUserId;

    private Page page;

}
