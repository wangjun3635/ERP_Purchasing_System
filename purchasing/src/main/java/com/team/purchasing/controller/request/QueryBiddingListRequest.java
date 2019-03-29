package com.team.purchasing.controller.request;

import com.team.purchasing.common.GeneralRequest;
import com.team.purchasing.utils.Page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "查询竞价请求实体类")
@Data
public class QueryBiddingListRequest extends GeneralRequest{

	@ApiModelProperty(value = "院校id")
	private Long hcId;
	
	@ApiModelProperty(value = "供应商id")
	private Long supplierId;
	
	/**
	 * 供应商查询竞价是，只能查询到审核通过的，则供应商查询是该字段必须传入
	 * 值为： auditStatus:1
	 */
	@ApiModelProperty(value = "审批状态")
	private Integer auditStatus;
	
	@ApiModelProperty(value = "分页对象")
	private Page page;
}
