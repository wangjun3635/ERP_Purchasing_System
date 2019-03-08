package com.team.purchasing.controller.request;

import com.team.purchasing.bean.Bidding;
import com.team.purchasing.common.GeneralRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "操作竞价请求实体类")
@Data
public class OperateBiddingCmd extends GeneralRequest {

	@ApiModelProperty
	private Bidding bidding;
}
