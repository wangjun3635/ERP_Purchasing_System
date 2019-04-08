package com.team.purchasing.service.erp;

import com.team.purchasing.bean.erp.Subject;

import java.util.List;

/**
 * @Auther: 018399
 * @Date: 2019/4/8 16:06
 * @Description:
 */
public interface SubjectService {

    public Integer addSubject(Subject subject);

    public List<Subject> querySubject(Subject subject);

    public Integer updateSubject(Subject subject);

}
