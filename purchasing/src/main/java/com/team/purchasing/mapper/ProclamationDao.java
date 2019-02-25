package com.team.purchasing.mapper;

import com.team.purchasing.bean.Proclamation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther:ynhuang
 * @Date:23/2/19 下午5:43
 */
public interface ProclamationDao {

    //查询公告信息
    public List<Proclamation> queryProclamationList(Proclamation proclamation);

    //添加一条公告信息
    public int addProclamation(Proclamation proclamation);

    //总条数查询
    public int queryProclamationCount();
}
