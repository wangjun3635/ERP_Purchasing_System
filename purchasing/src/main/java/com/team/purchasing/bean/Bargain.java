package com.team.purchasing.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@ApiModel(description = "询价实体类")
public class Bargain {

	@ApiModelProperty(value = "主键id")
	private Long id;
	
	@ApiModelProperty(value = "产品id")
	private Long productId;
	
	@ApiModelProperty(value = "产品名称")
	private String productName;
	
	@ApiModelProperty(value = "品牌名称")
	private String brandName;
	
	@ApiModelProperty(value = "品牌id")
	private String brandId;
	
	@ApiModelProperty(value = "供应商id")
	private Long supplierId;
	
	@ApiModelProperty(value = "用户id")
	private Long userId;
	
	@ApiModelProperty(value = "医院学校id")
	private Long hcId;
	
	@ApiModelProperty(value = "单价")
	private BigDecimal unitPrice;
	
	@ApiModelProperty(value = "数量")
	private Integer quantity;
	
	@ApiModelProperty(value = "过期天数")
	private Integer expireDay;
	
	@ApiModelProperty(value = "备注")
	private String remark;
	
	@ApiModelProperty(value = "创建时间")
	private String createTime;
	
	@ApiModelProperty(value = "创建人id")
	private Long createUserId;
	
}
