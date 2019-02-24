package com.team.purchasing.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "请求基本类")
public class GeneralRequest {

	@ApiModelProperty
	private BaseUserInfo baseUserInfo;
	
}
