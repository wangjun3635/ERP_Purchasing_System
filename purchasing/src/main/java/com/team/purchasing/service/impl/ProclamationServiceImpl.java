package com.team.purchasing.service.impl;

import com.team.purchasing.bean.Proclamation;
import com.team.purchasing.mapper.ProclamationDao;
import com.team.purchasing.service.ProclamationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther:ynhuang
 * @Date:23/2/19 下午5:57
 */
@Service
@Slf4j
public class ProclamationServiceImpl implements ProclamationService {

    @Resource
    private ProclamationDao proclamationDao;

    @Override
    public List<Proclamation> queryProclamationList(Proclamation proclamation) {
        return proclamationDao.queryProclamationList(proclamation);
    }

    @Override
    @Transactional
    public int addProclamation(Proclamation proclamation) {
        try {
            int result = proclamationDao.addProclamation(proclamation);
            return result;
        }catch (Exception e) {
            log.error("添加数据失败,{}", proclamation, e);
            throw new RuntimeException(proclamation.toString()+", 添加数据失败");
        }


    }
}
