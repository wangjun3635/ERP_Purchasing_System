package com.team.purchasing.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "议价回复实体类")
@Data
public class BargainComment {

	@ApiModelProperty(value = "主键id")
	private Long id;
	
	@ApiModelProperty(value = "议价id")
	private Long bargainId;
	
	@ApiModelProperty(value = "供应商id")
	private Long supplierId;
	
	@ApiModelProperty(value = "有效天数")
	private Integer expireDay;
	
	@ApiModelProperty(value = "备注")
	private String remark;
	
	@ApiModelProperty(value = "创建时间")
	private String createTime;
	
	@ApiModelProperty(value = "创建人")
	private String createUserId;
	
	@ApiModelProperty(value = "修改时间")
	private String updateTime;
	
	@ApiModelProperty(value = "修改人")
	private String updateUserId;	
	
}
