package com.team.purchasing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.team.purchasing.bean.Bargain;
import com.team.purchasing.common.GeneralResponse;
import com.team.purchasing.controller.request.QueryBargainListRequest;
import com.team.purchasing.controller.response.QueryBargainListResponse;
import com.team.purchasing.service.BargainService;

public class BargainController {
	
	@Autowired
	private BargainService bargainService;
	
	public GeneralResponse createBargain(Bargain bargain) {
		
		GeneralResponse response = new GeneralResponse();
		
		Long id = bargainService.createBargain(bargain);
		response.getMessageInfo().setKey(id+"");
		
		return response;
	}
	
	public QueryBargainListResponse queryBargainList(QueryBargainListRequest request) {
		
		QueryBargainListResponse response = new QueryBargainListResponse();
		
		List<Bargain> bargainList = bargainService.queryBargainList(request);
		Long count = bargainService.countBargainList(request);
		
		response.setBargainList(bargainList);
		return response;
	}
	
}
