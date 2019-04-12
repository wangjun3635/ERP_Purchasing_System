package com.team.purchasing.bean.erp;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "权限对象")
public class Privilege {

	@ApiModelProperty(value = "自增主键")
	private Long id;
	
	@ApiModelProperty(value = "权限名称")
	private String  name;		 
	
	@ApiModelProperty(value = "权限描述")
	private String description;	 
	
	@ApiModelProperty(value = "父级权限id[一级菜单该值为0]")
	private String parentId;	 
			
	@ApiModelProperty(value = "排序")
	private Long sort;		 	
	
	@ApiModelProperty(value = "备注")
	private String remark;		 
	
	@ApiModelProperty(value = "是否有效(1：有效  0：无效)")
	private Integer isValid;		 	
	
	@ApiModelProperty(value = "创建时间")
	private String createTime;	
	
	@ApiModelProperty(value = "创建人")
	private Long createUserId; 
	
	@ApiModelProperty(value = "最近更新时间")
	private String updateTime;	 
	
	@ApiModelProperty(value = "最近更新人")
	private Long updateUserId; 
	
	@ApiModelProperty(value = "自权限列表")
	private List<Privilege> subPrivileges;
	
}
