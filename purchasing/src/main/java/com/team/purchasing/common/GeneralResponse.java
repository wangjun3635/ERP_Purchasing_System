package com.team.purchasing.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "响应实体类")
public class GeneralResponse {

	@ApiModelProperty
	private MessageInfo messageInfo;
	
	public GeneralResponse() {
		this.messageInfo = new MessageInfo();
	}
}
