package com.team.purchasing.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "供应商类型")
@Data
public class SupplierCategory {

	@ApiModelProperty(value="供应商类型id")
	private Long id;
	
	@ApiModelProperty(value = "供应商类型名称")
	private String name;
}
