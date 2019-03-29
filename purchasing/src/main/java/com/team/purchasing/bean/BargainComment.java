package com.team.purchasing.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "询价回复实体类")
@Data
public class BargainComment {

	@ApiModelProperty(value = "主键id")
	private Long id;
	
	@ApiModelProperty(value = "议价id")
	private Long bargainId;
	
	@ApiModelProperty(value = "供应商id")
	private Long supplierId;
	
	@ApiModelProperty(value = "有效天数")
	private Integer expireDay;
	
	/*
	 * 用户是否可以进行下一步操作，
	 * 当用户的操作大于供应商给定的有效期时，就不能进行下一步操作    此时值为：isContine:0
	 */
	@ApiModelProperty
	private Integer isContine;
	
	@ApiModelProperty(value = "备注")
	private String remark;
	
	@ApiModelProperty(value = "创建时间")
	private String createTime;
	
	@ApiModelProperty(value = "创建人")
	private Long createUserId;
	
}
