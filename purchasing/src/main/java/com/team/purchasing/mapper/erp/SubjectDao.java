package com.team.purchasing.mapper.erp;

import com.team.purchasing.bean.erp.Subject;

import java.util.List;

/**
 * @Auther: 018399
 * @Date: 2019/4/8 16:03
 * @Description:
 */
public interface SubjectDao {

    public Integer addSubject(Subject subject);

    public List<Subject> querySubject(Subject subject);

    public Integer querySubjectCount(Subject subject);

    public Integer updateSubject(Subject subject);

}
