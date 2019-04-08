package com.team.purchasing.controller.erp;

import com.team.purchasing.bean.erp.Subject;
import com.team.purchasing.common.MessageInfo;
import com.team.purchasing.controller.request.erp.SubjectRequest;
import com.team.purchasing.controller.response.erp.SubjectResponse;
import com.team.purchasing.service.erp.SubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: 018399
 * @Date: 2019/4/8 16:00
 * @Description:
 */
@RestController
@RequestMapping("/subject")
@Api(tags="课题接口")
public class SubjectController {

    @Resource
    private SubjectService subjectService;

    @PostMapping("/addSubject")
    @ApiOperation(value="新增subject", notes = "新增subject")
    public SubjectResponse addSubject(@RequestBody SubjectRequest subjectRequest){

        Subject subject = subjectRequest.getSubject();

        SubjectResponse subjectResponse = new SubjectResponse();
        MessageInfo messageInfo = new MessageInfo();
        messageInfo.setCode("200");

        Integer result = subjectService.addSubject(subject);

        if("0".equals(result.toString())){
            messageInfo.setMessageText("添加失败");
        }else {
            messageInfo.setMessageText("添加成功");
        }

        subjectResponse.setMessageInfo(messageInfo);

        return subjectResponse;
    }

    @PostMapping("/querySubject")
    @ApiOperation(value="查询subject, 不传参数默认查询所有数据", notes = "查询subject")
    public SubjectResponse querySubject(@RequestBody SubjectRequest subjectRequest){

        Subject subject = subjectRequest.getSubject();

        Integer count = subjectService.querySubjectCount(subject);
        subject.getPage().init(count);

        SubjectResponse subjectResponse = new SubjectResponse();

        List<Subject> subjects = subjectService.querySubject(subject);

        subjectResponse.setSubjectList(subjects);

        return subjectResponse;
    }

    @PostMapping("/updateSubject")
    @ApiOperation(value="更新subject，更新信息为：课题负责人审批 监管部门审批 状态统一接口", notes = "更新subject")
    public SubjectResponse updateSubject(@RequestBody SubjectRequest subjectRequest){

        Subject subject = subjectRequest.getSubject();

        SubjectResponse subjectResponse = new SubjectResponse();
        MessageInfo messageInfo = new MessageInfo();
        messageInfo.setCode("200");

        Integer result = subjectService.updateSubject(subject);

        if("0".equals(result.toString())){
            messageInfo.setMessageText("更新失败");
        }else {
            messageInfo.setMessageText("更新成功");
        }

        subjectResponse.setMessageInfo(messageInfo);

        return subjectResponse;
    }

}
