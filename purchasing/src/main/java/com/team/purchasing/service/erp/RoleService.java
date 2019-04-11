package com.team.purchasing.service.erp;

import java.util.List;

import com.team.purchasing.bean.Role;
import com.team.purchasing.controller.request.erp.OperateRoleCmd;
import com.team.purchasing.controller.request.erp.QueryRoleListRequest;

public interface RoleService {

	void createRole(OperateRoleCmd cmd);
	
	void updateRole(OperateRoleCmd cmd);
	
	List<Role> queryRoleList(QueryRoleListRequest request);
	
	Integer countRoleList(QueryRoleListRequest request);
	
}
