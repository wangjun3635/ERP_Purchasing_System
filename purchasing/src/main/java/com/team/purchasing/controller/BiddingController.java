package com.team.purchasing.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	public @ResponseBody QueryBiddingListResponse queryBiddingList(@RequestBody QueryBiddingListRequest request) {
		
		
		Integer count = biddingService.countBiddingList(request);
		List<Bidding> biddingList = new ArrayList<>();
		if(count > 0) {
			request.getPage().init(count);
			
			biddingList = biddingService.queryBiddingList(request);
		}
		
		Page page = request.getPage();
		QueryBiddingListResponse response = new QueryBiddingListResponse();
		response.setBiddingList(biddingList);
		response.setPage(page);
		
		return response;
	}
	
	@ApiOperation(value="供应商查询竞价接口")
	@PostMapping("/queryBiddingListForSupplier")
	public @ResponseBody QueryBiddingListResponse queryBiddingListForSupplier(@RequestBody QueryBiddingListRequest request) {
		
		Integer count = biddingService.countBiddingListForSupplier(request);
		List<Bidding> biddingList = new ArrayList<>();
		if(count > 0) {
			request.getPage().init(count);
			biddingList = biddingService.queryBiddingListForSupplier(request);
		}
		
		QueryBiddingListResponse response = new QueryBiddingListResponse();
		Page page = request.getPage();
		response.setBiddingList(biddingList);
		response.setPage(page);
		
		return response;
	}
	
	@ApiOperation(value="创建竞价接口")
	@PostMapping("/createBidding")
	public @ResponseBody GeneralResponse createBidding(@RequestBody OperateBiddingCmd cmd) {
		GeneralResponse response = new GeneralResponse();
		
		Long id = biddingService.createBidding(cmd);
		
		response.getMessageInfo().setKey(id+"");
		return response;
	}
	
	@ApiOperation(value="创建竞价回复接口")
	@PostMapping("/createBiddingComment")
	public @ResponseBody GeneralResponse createBiddingComment(@RequestBody OperateBiddingCommentCmd cmd) {
		
		GeneralResponse response = new GeneralResponse();
		
		biddingService.createBiddingComment(cmd);
		
		return response;
	}
	
	@ApiOperation(value="查询竞价回复接口")
	@PostMapping("/queryBiddingCommentList")
	public @ResponseBody QueryBiddingCommentResponse queryBiddingCommentList(@RequestBody QueryBiddingCommentRequest request) {
		
		List<BiddingComment> list = new ArrayList<>();
		
		Integer count = biddingService.countBiddingCommentList(request);
		if(count > 0) {
			request.getPage().init(count);;
			list = biddingService.queryBiddingCommentList(request);
		}
		
		Page page = request.getPage();
		QueryBiddingCommentResponse response = new QueryBiddingCommentResponse();
		response.setBiddingCommentList(list);
		response.setPage(page);
		
		return response;
	}
	
	@ApiOperation(value="选中竞价回复")
	@PostMapping("/updateBiddingComment")
	public @ResponseBody GeneralResponse updateBiddingComment(@RequestBody OperateBiddingCommentCmd cmd) {
		GeneralResponse response = new GeneralResponse();
		
		biddingService.updateBiddingComment(cmd);
		
		return response;
	}
	
}
