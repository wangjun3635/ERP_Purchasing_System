package com.team.purchasing.bean.erp;

import com.team.purchasing.utils.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Auther:ynhuang
 * @Date:6/4/19 下午8:09
 */
@Data
@ApiModel(value="课题实体")
public class Subject {

    @ApiModelProperty(value = "课题id")
    private Integer id;

    @ApiModelProperty(value = "课题名称")
    private String name;

    @ApiModelProperty(value = "经费来源")
    private String expenditure;

    @ApiModelProperty(value = "课题负责人")
    private Long owner;

    @ApiModelProperty(value = "扣款账号")
    private String account;

    @ApiModelProperty(value = "经费总额")
    private BigDecimal totalAmount;

    @ApiModelProperty(value = "经费余额")
    private BigDecimal restAmount;

    @ApiModelProperty(value = "项目经费开始时间")
    private String startDate;

    @ApiModelProperty(value = "项目经费结束时间")
    private String endDate;

    @ApiModelProperty(value = "审核[1:课题负责人审核2：监管部门审核]")
    private Integer audit;

    @ApiModelProperty(value = "创建时间")
    private String createTime;

    @ApiModelProperty(value = "创建用户id")
    private Integer createUserId;

    @ApiModelProperty(value = "更新时间")
    private String updateTime;

    @ApiModelProperty(value = "更新用户id")
    private Integer updateUserId;

    private Page page;

}
