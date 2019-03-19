package com.team.purchasing.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team.purchasing.bean.Bargain;
import com.team.purchasing.bean.BargainComment;
import com.team.purchasing.controller.request.BargainCommentCmd;
import com.team.purchasing.controller.request.OperateBargainCmd;
import com.team.purchasing.controller.request.QueryBargainCommentListRequest;
import com.team.purchasing.controller.request.QueryBargainListRequest;

@Mapper
public interface BargainDao {

	public Long createBargain(OperateBargainCmd cmd);
	
	public List<Bargain> queryBargainList(QueryBargainListRequest request);
	
	public Long countBargainList(QueryBargainListRequest request);
	
	public Long createBargainComment(BargainCommentCmd cmd);
	
	public List<BargainComment> queryBargainCommentList(QueryBargainCommentListRequest request);
}
