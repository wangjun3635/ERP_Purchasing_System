package com.team.purchasing.bean;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class Bargain {

	@ApiModelProperty(value = "主键id")
	private Long id;
	
	@ApiModelProperty(value = "产品id")
	private Long productId;
	
	@ApiModelProperty(value = "供应商id")
	private Long supplierId;
	
	@ApiModelProperty(value = "单价")
	private BigDecimal unitPrice;
	
	@ApiModelProperty(value = "数量")
	private Integer quantity;
	
	@ApiModelProperty(value = "供应商类型")
	private Integer supplierCategory;
	
	@ApiModelProperty(value = "过期天数")
	private Integer expireDay;
	
	@ApiModelProperty(value = "备注")
	private String remark;
	
	@ApiModelProperty(value = "创建时间")
	private String CreateTime;
	
	@ApiModelProperty(value = "")
	private Long CreateUserId;
	
	@ApiModelProperty(value = "")
	private String UpdateTime;
	
	@ApiModelProperty(value = "")
	private Long UpdateUserId;

}
