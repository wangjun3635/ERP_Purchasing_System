package com.team.purchasing.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.purchasing.bean.Bidding;
import com.team.purchasing.bean.BiddingComment;
import com.team.purchasing.common.GeneralResponse;
import com.team.purchasing.controller.request.OperateBiddingCmd;
import com.team.purchasing.controller.request.OperateBiddingCommentCmd;
import com.team.purchasing.controller.request.QueryBiddingCommentRequest;
import com.team.purchasing.controller.request.QueryBiddingListRequest;
import com.team.purchasing.controller.response.QueryBiddingCommentResponse;
import com.team.purchasing.controller.response.QueryBiddingListResponse;
import com.team.purchasing.service.BiddingService;
import com.team.purchasing.utils.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/bidding")
@Api(tags="竞价接口")
@Slf4j
public class BiddingController {

	@Autowired
	private BiddingService biddingService; 
	
	@ApiOperation(value="查询竞价接口")
	@PostMapping("/queryBiddingList")
	public QueryBiddingListResponse queryBiddingList(QueryBiddingListRequest request) {
		
		QueryBiddingListResponse response = new QueryBiddingListResponse();
		
		Integer count = biddingService.countBiddingList(request);
		List<Bidding> biddingList = new ArrayList<>();
		if(count > 0) {
			biddingList = biddingService.queryBiddingList(request);
		}
		Page page = request.getPage();
		page.setTotal(count);
		response.setBiddingList(biddingList);
		response.setPage(page);
		
		return response;
	}
	
	@ApiOperation(value="供应商查询竞价接口")
	@PostMapping("/queryBiddingListForSupplier")
	public QueryBiddingListResponse queryBiddingListForSupplier(QueryBiddingListRequest request) {
		QueryBiddingListResponse response = new QueryBiddingListResponse();
		
		Integer count = biddingService.countBiddingListForSupplier(request);
		List<Bidding> biddingList = new ArrayList<>();
		if(count > 0) {
			biddingList = biddingService.queryBiddingListForSupplier(request);
		}
		Page page = request.getPage();
		page.setTotal(count);
		response.setBiddingList(biddingList);
		response.setPage(page);
		
		return response;
	}
	
	@ApiOperation(value="创建竞价接口")
	@PostMapping("/createBidding")
	public GeneralResponse createBidding(OperateBiddingCmd cmd) {
		GeneralResponse response = new GeneralResponse();
		
		Long id = biddingService.createBidding(cmd);
		
		response.getMessageInfo().setKey(id+"");
		return response;
	}
	
	@ApiOperation(value="创建竞价回复接口")
	@PostMapping("/createBiddingComment")
	public GeneralResponse createBiddingComment(OperateBiddingCommentCmd cmd) {
		GeneralResponse response = new GeneralResponse();
		
		biddingService.createBiddingComment(cmd);
		
		return response;
	}
	
	@ApiOperation(value="查询竞价回复接口")
	@PostMapping("/queryBiddingCommentList")
	public QueryBiddingCommentResponse queryBiddingCommentList(QueryBiddingCommentRequest request) {
		
		
		List<BiddingComment> list = new ArrayList<>();
		
		Integer count = biddingService.countBiddingCommentList(request);
		if(count > 0) {
			list = biddingService.queryBiddingCommentList(request);
		}
		
		Page page = request.getPage();
		page.setTotal(count);
		
		QueryBiddingCommentResponse response = new QueryBiddingCommentResponse();
		response.setBiddingCommentList(list);
		response.setPage(page);
		
		return response;
	}
	
	@ApiOperation(value="选中竞价回复")
	@PostMapping("/updateBiddingComment")
	public GeneralResponse updateBiddingComment(OperateBiddingCommentCmd cmd) {
		GeneralResponse response = new GeneralResponse();
		
		biddingService.updateBiddingComment(cmd);
		
		return response;
	}
	
}
