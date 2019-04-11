package com.team.purchasing.controller.erp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.team.purchasing.bean.Role;
import com.team.purchasing.common.GeneralResponse;
import com.team.purchasing.common.InvalidExcepation;
import com.team.purchasing.controller.request.erp.OperateRoleCmd;
import com.team.purchasing.controller.request.erp.QueryRoleListRequest;
import com.team.purchasing.controller.response.erp.QueryRoleListRespnse;
import com.team.purchasing.service.erp.RoleService;
import com.team.purchasing.utils.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "角色接口")
@RestController
@RequestMapping(value = "role")
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@ApiOperation(value = "创建角色")
	@RequestMapping(path = {"createRole"},method = RequestMethod.POST)
	public @ResponseBody GeneralResponse createRole(@RequestBody OperateRoleCmd cmd) {
		
		roleService.createRole(cmd);
		
		GeneralResponse generalResponse = new GeneralResponse();
		generalResponse.processSuccess();
		generalResponse.getMessageInfo().setKey(cmd.getRole().getId()+"");
		return generalResponse;
	}

	@ApiOperation(value = "更新角色")
	@RequestMapping(path = {"updateRole"},method = RequestMethod.POST)
	public @ResponseBody GeneralResponse updateRole(@RequestBody OperateRoleCmd cmd) {
		roleService.updateRole(cmd);
		
		GeneralResponse generalResponse = new GeneralResponse();
		generalResponse.processSuccess();
		generalResponse.getMessageInfo().setKey(cmd.getRole().getId()+"");
		return generalResponse;
	}

	@ApiOperation(value = "查询角色列表")
	@RequestMapping(path = {"queryRoleList"},method = RequestMethod.POST)
	public @ResponseBody QueryRoleListRespnse queryRoleList(@RequestBody QueryRoleListRequest request) throws InvalidExcepation {
		
		if(request == null ) {
			throw new InvalidExcepation("-1", "参数不能为空！");
		}
		
		Integer count = roleService.countRoleList(request);
		
		List<Role> roleList = new ArrayList<>();
		if(count > 0 ) {
			if(request.getPage() == null) {
				request.setPage(new Page(1, 10));
			}
			request.getPage().init(count);
			roleList = roleService.queryRoleList(request);
		}
		
		QueryRoleListRespnse response = new QueryRoleListRespnse();
		response.setRoleList(roleList);
		response.setPage(request.getPage());
		return response;
	}
	
}
