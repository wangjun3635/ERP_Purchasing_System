package com.team.purchasing.bean;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description="竞价回复实体类")
@Data
public class BiddingComment {
	
	@ApiModelProperty(value = "主键id")
	private Long id;
	
	@ApiModelProperty(value = "竞价id")
	private Long biddingId;
	
	@ApiModelProperty(value = "供应商id")
	private Long supplierId;
	
	@ApiModelProperty(value = "供应商名称")
	private String supplierName;
	
	@ApiModelProperty(value = "单价")
	private BigDecimal unitPrice;
	
	@ApiModelProperty(value = "备注")
	private String remark;
	
	@ApiModelProperty(value = "是否被选中 [1:选中 0：未选中]")
	private Integer isSelected;
	
	@ApiModelProperty(value = "创建时间")
	private String createTime;
	
	@ApiModelProperty(value = "创建人")
	private Long createUserId;
	
	@ApiModelProperty(value = "创建时间")
	private String updateTime;
	
	@ApiModelProperty(value = "创建用户")
	private Long updateUserId;
	
}
