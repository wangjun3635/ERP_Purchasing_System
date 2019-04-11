package com.team.purchasing.service.impl.erp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.purchasing.bean.Role;
import com.team.purchasing.controller.request.erp.OperateRoleCmd;
import com.team.purchasing.controller.request.erp.QueryRoleListRequest;
import com.team.purchasing.mapper.erp.RoleDao;
import com.team.purchasing.service.erp.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;
	
	@Override
	public void createRole(OperateRoleCmd cmd) {
		roleDao.createRole(cmd);
	}

	@Override
	public void updateRole(OperateRoleCmd cmd) {
		roleDao.updateRole(cmd);
	}

	@Override
	public Integer countRoleList(QueryRoleListRequest request) {
		Integer count = roleDao.countRoleList(request);
		return count;
	}
	
	@Override
	public List<Role> queryRoleList(QueryRoleListRequest request) {
		List<Role> roleList = roleDao.queryRoleList(request);
		return roleList;
	}

}
