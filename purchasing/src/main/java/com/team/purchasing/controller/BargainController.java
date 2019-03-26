package com.team.purchasing.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.team.purchasing.bean.Bargain;
import com.team.purchasing.bean.BargainComment;
import com.team.purchasing.common.GeneralResponse;
import com.team.purchasing.controller.request.BargainCommentCmd;
import com.team.purchasing.controller.request.OperateBargainCmd;
import com.team.purchasing.controller.request.QueryBargainCommentListRequest;
import com.team.purchasing.controller.request.QueryBargainListRequest;
import com.team.purchasing.controller.response.QueryBargainCommentListResponse;
import com.team.purchasing.controller.response.QueryBargainListResponse;
import com.team.purchasing.service.BargainService;
import com.team.purchasing.utils.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/bargain")
@Api(tags="询价接口")
@Slf4j
public class BargainController {
	
	@Autowired
	private BargainService bargainService;
	
	@ApiOperation(value="创建询价接口")
	@PostMapping("/createBargain")
	public @ResponseBody GeneralResponse createBargain(@RequestBody OperateBargainCmd cmd) {
		
		GeneralResponse response = new GeneralResponse();
		
		Long id = bargainService.createBargain(cmd);
		response.getMessageInfo().setKey(id+"");
		
		return response;
	}
	
	@ApiOperation(value="查询询价接口")
	@PostMapping("/queryBargainList")
	public @ResponseBody QueryBargainListResponse queryBargainList(@RequestBody QueryBargainListRequest request) {
		
		List<Bargain> bargainList = new ArrayList<>();
		Long count = bargainService.countBargainList(request);
		if(count > 0){
			request.getPage().init(Integer.valueOf(count.toString()));
			
			bargainList = bargainService.queryBargainList(request);
		}
		
		Page page = request.getPage();
		QueryBargainListResponse response = new QueryBargainListResponse();
		response.setBargainList(bargainList);
		response.setPage(page);
		return response;
	}
	
	@ApiOperation(value="创建询价回复接口")
	@PostMapping("/createBargainComment")
	public @ResponseBody GeneralResponse createBargainComment(@RequestBody BargainCommentCmd cmd) {
		
		GeneralResponse response = new GeneralResponse();
		
		Long id = bargainService.createBargainComment(cmd);
		response.getMessageInfo().setKey(id+"");
		
		return response;
	}
	
	@ApiOperation(value="查询询价回复接口")
	@PostMapping("/queryBargainCommentList")
	public @ResponseBody QueryBargainCommentListResponse queryBargainCommentList(@RequestBody QueryBargainCommentListRequest request) {
		
		QueryBargainCommentListResponse response = new QueryBargainCommentListResponse();
		
		List<BargainComment> list = bargainService.queryBargainCommentList(request);
		response.setList(list);
		return response;
	}
	
}
