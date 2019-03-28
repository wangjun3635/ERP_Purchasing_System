package com.team.purchasing.bean.productcomment;

import com.team.purchasing.utils.Page;
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
    private Integer id;

    @ApiModelProperty(value = "商品id")
    private Integer productId;

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "用户别名")
    private String userNickName;

    @ApiModelProperty(value = "评价星数：0->5")
    private Integer star;

    @ApiModelProperty(value = "评价内容")
    private String comment;

    @ApiModelProperty(value = "创建时间")
    private String createTime;

    @ApiModelProperty(value = "创建人")
    private Integer createUserId;

    @ApiModelProperty(value = "最近更新时间")
    private String updateTime;

    @ApiModelProperty(value = "最近更新人")
    private Integer updateUserId;

    private Page page;



}
