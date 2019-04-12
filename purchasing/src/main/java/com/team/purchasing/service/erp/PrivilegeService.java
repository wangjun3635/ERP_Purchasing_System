package com.team.purchasing.service.erp;

import java.util.List;

import com.team.purchasing.bean.erp.Privilege;
import com.team.purchasing.controller.request.erp.OperatePrivilegeCmd;
import com.team.purchasing.controller.request.erp.QueryPrivilegeRequest;

public interface PrivilegeService {

	void createPrivilege(OperatePrivilegeCmd cmd);
	void updatePrivilege(OperatePrivilegeCmd cmd);
	void deletePrivilege(OperatePrivilegeCmd cmd);
	List<Privilege> queryPrivilegeList(QueryPrivilegeRequest request);
	
}
