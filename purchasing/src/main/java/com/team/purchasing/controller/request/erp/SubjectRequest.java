package com.team.purchasing.controller.request.erp;

import com.team.purchasing.bean.erp.Subject;
import com.team.purchasing.common.GeneralRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Auther: 018399
 * @Date: 2019/4/8 16:30
 * @Description:
 */
@Data
@ApiModel(description = "课题请求实体类")
public class SubjectRequest extends GeneralRequest {

    @ApiModelProperty(value = "课题信息")
    private Subject subject;

}
