package com.team.purchasing.controller.request;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "查询议价请求实体类")
public class QueryBiddingListRequest {

	@ApiModelProperty(value = "院校id")
	private Long hcId;
	
	@ApiModelProperty(value = "供应商类型类表")
	private List<Integer> supplierCategoryList;
}
