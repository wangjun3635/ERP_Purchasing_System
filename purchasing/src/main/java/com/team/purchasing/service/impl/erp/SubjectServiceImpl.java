package com.team.purchasing.service.impl.erp;

import com.team.purchasing.bean.erp.Subject;
import com.team.purchasing.mapper.erp.SubjectDao;
import com.team.purchasing.service.erp.SubjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: 018399
 * @Date: 2019/4/8 16:07
 * @Description:
 */
@Service
@Slf4j
public class SubjectServiceImpl implements SubjectService {

    @Resource
    private SubjectDao subjectDao;

    @Override
    @Transactional
    public Integer addSubject(Subject subject) {

        try {

            Integer result = subjectDao.addSubject(subject);

            return result;

        }catch (Exception e) {
            log.error("subject数据插入失败:", e);
            throw new RuntimeException("subject数据插入失败");
        }
    }

    @Override
    public List<Subject> querySubject(Subject subject) {

        try {

            List<Subject> subjects = subjectDao.querySubject(subject);

            return subjects;

        }catch (Exception e) {
            log.error("subjects查询失败", e);
            throw new RuntimeException("subjects查询失败");
        }

    }

    @Override
    @Transactional
    public Integer updateSubject(Subject subject) {

        try {

            Integer result = subjectDao.updateSubject(subject);

            return result;

        }catch (Exception e) {
            log.error("课题负责人审批 监管部门审批 更新失败", e);
            throw new RuntimeException("课题负责人审批 监管部门审批 更新失败");
        }

    }

}
