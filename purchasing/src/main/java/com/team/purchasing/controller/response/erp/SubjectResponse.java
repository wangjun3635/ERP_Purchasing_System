package com.team.purchasing.controller.response.erp;

import com.team.purchasing.bean.erp.Subject;
import com.team.purchasing.common.GeneralResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Auther: 018399
 * @Date: 2019/4/8 16:31
 * @Description:
 */
@Data
@ApiModel(description = "课题响应实体类")
public class SubjectResponse extends GeneralResponse {

    @ApiModelProperty
    private List<Subject> subjectList;

}
