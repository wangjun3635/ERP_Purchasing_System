package com.team.purchasing.mapper.erp;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team.purchasing.bean.erp.Privilege;
import com.team.purchasing.controller.request.erp.OperatePrivilegeCmd;
import com.team.purchasing.controller.request.erp.QueryPrivilegeRequest;

@Mapper
public interface PrivilegeDao {

	void createPrivilege(OperatePrivilegeCmd cmd);
	void updatePrivilege(OperatePrivilegeCmd cmd);
	void deletePrivilege(OperatePrivilegeCmd cmd);
	List<Privilege> queryPrivilegeList(QueryPrivilegeRequest request);
	
}
