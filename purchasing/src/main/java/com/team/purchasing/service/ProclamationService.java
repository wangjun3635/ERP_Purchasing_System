package com.team.purchasing.service;

import com.team.purchasing.bean.Proclamation;

import java.util.List;

/**
 * @Auther:ynhuang
 * @Date:23/2/19 下午5:56
 */
public interface ProclamationService {

    public List<Proclamation> queryProclamationList(Proclamation proclamation);

    public int addProclamation(Proclamation proclamation);

}
