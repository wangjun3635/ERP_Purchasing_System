package com.team.purchasing.controller.request;

import com.team.purchasing.utils.Page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "查询议价请求实体类")
@Data
public class QueryBiddingListRequest {

	@ApiModelProperty(value = "院校id")
	private Long hcId;
	
	@ApiModelProperty(value = "供应商id")
	private Long supplierId;
	
	@ApiModelProperty(value = "分页对象")
	private Page page;
}
