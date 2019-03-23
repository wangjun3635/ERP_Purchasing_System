package com.team.purchasing.bean;

import com.team.purchasing.utils.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: 018399
 * @Date: 2019/3/23 14:25
 * @Description: 商品收藏夹
 */
@Data
@ApiModel(value="商品收藏夹实体")
public class ProductCollection implements Serializable {

    @ApiModelProperty(value = "商品收藏夹id")
    private int id;

    @ApiModelProperty(value = "商品id")
    private int productId;

    @ApiModelProperty(value = "医院或者院校id")
    private int hcId;

    @ApiModelProperty(value = "用户id")
    private int userId;

    @ApiModelProperty(value = "删除标志（0未删除，1删除）")
    private int isValid;

    @ApiModelProperty(value = "创建时间")
    private String createTime;

    @ApiModelProperty(value = "创建用户id")
    private int createUserId;

    @ApiModelProperty(value = "更新时间")
    private String modifyTime;

    @ApiModelProperty(value = "更新用户id")
    private int modifyUserId;

    private Page page;
}
