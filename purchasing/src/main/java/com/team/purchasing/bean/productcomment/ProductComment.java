package com.team.purchasing.bean.productcomment;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Auther:ynhuang
 * @Date:4/3/19 下午9:16
 * 产品评价实体类
 */
@Data
@ApiModel(value="产品评价实体")
public class ProductComment {

    @ApiModelProperty(value = "产品评价id")
    private int id;

    @ApiModelProperty(value = "商品id")
    private int productId;

    @ApiModelProperty(value = "用户id")
    private int userId;

    @ApiModelProperty(value = "用户别名")
    private String userNickName;

    @ApiModelProperty(value = "评价星数：0->5")
    private int star;

    @ApiModelProperty(value = "评价内容")
    private String comment;

    @ApiModelProperty(value = "创建时间")
    private String createTime;

    @ApiModelProperty(value = "创建人")
    private int createUserId;

    @ApiModelProperty(value = "最近更新时间")
    private String updateTime;

    @ApiModelProperty(value = "最近更新人")
    private int updateUserId;



}
