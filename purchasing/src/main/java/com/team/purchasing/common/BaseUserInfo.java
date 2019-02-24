package com.team.purchasing.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "用户实体类")
public class BaseUserInfo {

	@ApiModelProperty(value = "用户id")
	private Long userId;
	
	@ApiModelProperty(value = "用户名")
	private String userName;
	
	@ApiModelProperty(value = "用户编号")
	private String userCode;
	
	@ApiModelProperty(value = "用户别名")
	private String nickUserName;
	
	@ApiModelProperty(value = "医院学校供应商id")
	private Long  hscId;
	
	@ApiModelProperty(value = "用户访问的ip地址")
	private String ip;
	
}
