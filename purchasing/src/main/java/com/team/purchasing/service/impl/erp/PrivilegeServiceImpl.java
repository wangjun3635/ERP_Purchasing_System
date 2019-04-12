package com.team.purchasing.service.impl.erp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.purchasing.bean.erp.Privilege;
import com.team.purchasing.controller.request.erp.OperatePrivilegeCmd;
import com.team.purchasing.controller.request.erp.QueryPrivilegeRequest;
import com.team.purchasing.mapper.erp.PrivilegeDao;
import com.team.purchasing.service.erp.PrivilegeService;

@Service
public class PrivilegeServiceImpl implements PrivilegeService {

	@Autowired
	private PrivilegeDao privilegeDao;
	
	@Override
	public void createPrivilege(OperatePrivilegeCmd cmd) {
		
		privilegeDao.createPrivilege(cmd);
	}

	@Override
	public void updatePrivilege(OperatePrivilegeCmd cmd) {
		privilegeDao.updatePrivilege(cmd);

	}

	@Override
	public void deletePrivilege(OperatePrivilegeCmd cmd) {
		privilegeDao.deletePrivilege(cmd);
		
	}
	
	@Override
	public List<Privilege> queryPrivilegeList(QueryPrivilegeRequest request) {
		List<Privilege> privileges = privilegeDao.queryPrivilegeList(request);
		return privileges;
	}

}
