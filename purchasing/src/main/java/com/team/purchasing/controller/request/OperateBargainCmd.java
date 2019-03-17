package com.team.purchasing.controller.request;

import com.team.purchasing.bean.Bargain;
import com.team.purchasing.common.GeneralRequest;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "创建或者修改竞价请求实体类")
@Data
public class OperateBargainCmd extends GeneralRequest {

	@ApiModelProperty
	private Bargain bargain; 
	
}
