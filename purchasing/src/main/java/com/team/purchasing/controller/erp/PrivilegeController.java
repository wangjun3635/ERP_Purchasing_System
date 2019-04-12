package com.team.purchasing.controller.erp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.team.purchasing.bean.erp.Privilege;
import com.team.purchasing.common.GeneralResponse;
import com.team.purchasing.common.InvalidExcepation;
import com.team.purchasing.controller.request.erp.OperatePrivilegeCmd;
import com.team.purchasing.controller.request.erp.QueryPrivilegeRequest;
import com.team.purchasing.controller.response.erp.queryPrivilegeResponse;
import com.team.purchasing.service.erp.PrivilegeService;

import io.swagger.annotations.Api;

@Api(value = "权限接口")
@RestController
@RequestMapping("/privilege")
public class PrivilegeController {
	
	@Autowired
	private PrivilegeService privilegeService;

	@RequestMapping(path = {"createPrivilege"}, method = RequestMethod.POST)
	public GeneralResponse createPrivilege(OperatePrivilegeCmd cmd) throws InvalidExcepation {
		
		if(cmd == null || cmd.getPrivilege() == null) {
			throw new InvalidExcepation("-1", "入参不能为空");
		}
		
		privilegeService.createPrivilege(cmd);
		
		GeneralResponse response = new GeneralResponse();
		response.getMessageInfo().setKey(cmd.getPrivilege().getId() + "");
		response.processSuccess();
		
		return response;
		
	}
	
	@RequestMapping(path = {"deletePrivilege"}, method = RequestMethod.POST)
	public GeneralResponse deletePrivilege(OperatePrivilegeCmd cmd) throws InvalidExcepation {
		
		if(cmd == null || cmd.getPrivilege() == null) {
			throw new InvalidExcepation("-1", "入参不能为空");
		}
		
		privilegeService.deletePrivilege(cmd);
		
		GeneralResponse response = new GeneralResponse();
		response.getMessageInfo().setKey(cmd.getPrivilege().getId() + "");
		response.processSuccess();
		
		return response;
		
	}
	
	@RequestMapping(path = {"updatePrivilege"}, method = RequestMethod.POST)
	public GeneralResponse updatePrivilege(OperatePrivilegeCmd cmd) throws InvalidExcepation {
		
		if(cmd == null || cmd.getPrivilege() == null) {
			throw new InvalidExcepation("-1", "入参不能为空");
		}
		
		privilegeService.updatePrivilege(cmd);
		
		GeneralResponse response = new GeneralResponse();
		response.getMessageInfo().setKey(cmd.getPrivilege().getId() + "");
		response.processSuccess();
		
		return response;
		
	}
	
	@RequestMapping(path = {"queryPrivilegeList"}, method = RequestMethod.POST)
	public queryPrivilegeResponse queryPrivilegeList(QueryPrivilegeRequest request) throws InvalidExcepation {
		
		if(request == null) {
			throw new InvalidExcepation("-1", "入参不能为空");
		}
		
		List<Privilege> privileges = privilegeService.queryPrivilegeList(request);
		
		queryPrivilegeResponse response = new queryPrivilegeResponse();
		response.setPrivilegeList(privileges);
		response.processSuccess();
		return response;
		
	}
	
}
