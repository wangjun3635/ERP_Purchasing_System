package com.team.purchasing.mapper;


import com.team.purchasing.bean.Bargain;
import com.team.purchasing.bean.BargainComment;
import com.team.purchasing.controller.request.QueryBargainCommentListRequest;
import com.team.purchasing.controller.request.QueryBargainListRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BargainDao {

	public Long createBargain(Bargain bargain);
	
	public List<Bargain> queryBargainList(QueryBargainListRequest request);
	
	public Long countBargainList(QueryBargainListRequest request);
	
	public Long createBargainComment(BargainComment bargainComment);
	
	public List<BargainComment> queryBargainCommentList(QueryBargainCommentListRequest request);
}
