package com.team.purchasing.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@ApiModel(description = "竞价实体类")
public class Bidding {

	@ApiModelProperty(value = "主键id")
	private Long id;
	
	@ApiModelProperty(value = "院校id")
	private Long hcId;
	
	@ApiModelProperty(value = "品牌名")
	private String brandName;
	
	@ApiModelProperty(value = "药品名")
	private String drugName;
	
	@ApiModelProperty(value = "单价")
	private BigDecimal unit;
	
	@ApiModelProperty(value = "数量")
	private Integer quantity;
	
	@ApiModelProperty(value = "供应商类型类表")
	private List<SupplierCategory> supplierCategoryList;
	
	@ApiModelProperty(value = "供应商回复有效天数")
	private Integer expireDay;
	
	@ApiModelProperty(value = "审批状态")
	private Integer auditStatus;
	
	@ApiModelProperty(value = "备注")
	private String remark;
	
	@ApiModelProperty(value = "创建时间")
	private String createTime;
	
	@ApiModelProperty(value = "创建人")
	private Long createUserId;
	
//	@ApiModelProperty(value = "修改时间")
//	private String updateTime;
//	
//	@ApiModelProperty(value = "修改人")
//	private String updateUserId;

}
