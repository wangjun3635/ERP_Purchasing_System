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
    public List<Proclamation> queryProclamationList(@Param("proclamation") Proclamation proclamation);

    public int addProclamation(@Param("proclamation") Proclamation proclamation);
}
