package com.team.purchasing.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Auther:ynhuang
 * @Date:16/3/19 下午12:24
 */
@Data
@ApiModel(value="产品品牌实体")
public class ProductBrand {

    @ApiModelProperty(value = "产品品牌id")
    private int id;

    @ApiModelProperty(value = "产品品牌name")
    private String name;

    @ApiModelProperty(value = "名称汉语拼音")
    private String chinesePhonetic;

    @ApiModelProperty(value = "品牌logo（图片路径或者是url）")
    private String logo;

    @ApiModelProperty(value = "品牌介绍")
    private String brandIntroduction;

    @ApiModelProperty(value = "删除标志（0未删除，1删除）")
    private int isValid;

    @ApiModelProperty(value = "创建时间")
    private String createTime;

    @ApiModelProperty(value = "创建人")
    private int createUserId;

    @ApiModelProperty(value = "最近更新时间")
    private String updateTime;

    @ApiModelProperty(value = "最近更新人")
    private int updateUserId;

}
