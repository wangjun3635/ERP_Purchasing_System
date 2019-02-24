package com.team.purchasing.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "响应信息实体类")
public class MessageInfo {

	@ApiModelProperty(value = "响应码")
	protected String code;
	
	@ApiModelProperty(value = "")
    protected String key;
	
	@ApiModelProperty(value = "响应内容")
    protected String messageText;
	
}
