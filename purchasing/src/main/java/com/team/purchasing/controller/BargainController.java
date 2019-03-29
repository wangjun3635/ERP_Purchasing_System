package com.team.purchasing.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.team.purchasing.bean.Bargain;
import com.team.purchasing.bean.BargainComment;
import com.team.purchasing.common.GeneralResponse;
import com.team.purchasing.common.InvalidExcepation;
import com.team.purchasing.controller.request.BargainCommentCmd;
import com.team.purchasing.controller.request.OperateBargainCmd;
import com.team.purchasing.controller.request.QueryBargainCommentListRequest;
import com.team.purchasing.controller.request.QueryBargainListRequest;
import com.team.purchasing.controller.response.QueryBargainCommentListResponse;
import com.team.purchasing.controller.response.QueryBargainListResponse;
import com.team.purchasing.service.BargainService;
import com.team.purchasing.utils.DateUtil;
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
	public @ResponseBody GeneralResponse createBargainComment(@RequestBody BargainCommentCmd cmd) throws InvalidExcepation {
		
		if(cmd.getBargainComment().getBargainId() == null) {
			throw new InvalidExcepation("-1","询价Id为空！");
		}
		//---start 校验是否在规定时间内回复询价
		Page page = new Page();
		page.setCurrentNum(20);
		page.setCurrentPage(1);
		page.init(1);
		QueryBargainListRequest request = new QueryBargainListRequest();
		request.setId(cmd.getBargainComment().getBargainId());
		request.setPage(page);
			
		List<Bargain> bargainList = bargainService.queryBargainList(request);
		if(!CollectionUtils.isEmpty(bargainList)) {
			Integer bargainExpiryDay = bargainList.get(0).getExpireDay();
			Date bargainCreateTine = DateUtil.parseDate(bargainList.get(0).getCreateTime());
			// 过期时间
			Date bargainExpiryTime = DateUtil.addDay(bargainCreateTine, bargainExpiryDay);
			
			if(!DateUtil.isMax(bargainExpiryTime, new Date())) {
				throw new InvalidExcepation("-1","不能进行回复，已经超过回复时间！");
			}
		}else {
			throw new InvalidExcepation("-1","没有对应的询价");
		}
		//---end  校验结束
		
		Long id = bargainService.createBargainComment(cmd);
		GeneralResponse response = new GeneralResponse();
		response.getMessageInfo().setKey(id+"");
		
		return response;
	}
	
	@ApiOperation(value="查询询价回复接口")
	@PostMapping("/queryBargainCommentList")
	public @ResponseBody QueryBargainCommentListResponse queryBargainCommentList(@RequestBody QueryBargainCommentListRequest request) throws InvalidExcepation {
		
		QueryBargainCommentListResponse response = new QueryBargainCommentListResponse();
		
		List<BargainComment> list = bargainService.queryBargainCommentList(request);
		
		if(!CollectionUtils.isEmpty(list)) {
			// 判断用户是否可以进行下一步操作
			for (BargainComment bargainComment : list) {
				Integer bargainCommentExpiryDay = bargainComment.getExpireDay();
				Date bargainCommentCreateTine = DateUtil.parseDate(bargainComment.getCreateTime());
				// 过期时间
				Date bargainCommentExpiryTime = DateUtil.addDay(bargainCommentCreateTine, bargainCommentExpiryDay);
				
				if(!DateUtil.isMax(bargainCommentExpiryTime, new Date())) {
					bargainComment.setIsContine(0);
				}else {
					bargainComment.setIsContine(1);
				}
			}
		}
		
		response.setList(list);
		return response;
	}
	
}
