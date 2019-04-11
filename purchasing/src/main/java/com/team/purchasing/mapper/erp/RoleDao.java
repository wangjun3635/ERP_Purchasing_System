package com.team.purchasing.mapper.erp;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team.purchasing.bean.Role;
import com.team.purchasing.controller.request.erp.OperateRoleCmd;
import com.team.purchasing.controller.request.erp.QueryRoleListRequest;

@Mapper
public interface RoleDao {
	
	void createRole(OperateRoleCmd cmd);
	
	void updateRole(OperateRoleCmd cmd);
	
	Integer countRoleList(QueryRoleListRequest request);
	
	List<Role> queryRoleList(QueryRoleListRequest request);

}
