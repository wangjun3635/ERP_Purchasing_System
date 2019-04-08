package com.team.purchasing.bean.erp;

import com.team.purchasing.utils.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Auther: 018399
 * @Date: 2019/4/8 17:07
 * @Description:
 */
@Data
@ApiModel(value="用户实体")
public class User {

    @ApiModelProperty(value = "用户id")
    private Long id;

    @ApiModelProperty(value = "医院学校供应商id")
    private Long hcId;

    @ApiModelProperty(value = "客户类型 1：医院 2:学校 3:晟誉内部")
    private Integer type;

    @ApiModelProperty(value = "账户类型（1：订货人2:收货人3：课题负责人4：科研处5：采购处6：财务处）")
    private Integer accountType;

    @ApiModelProperty(value = "客户编号")
    private String code;

    @ApiModelProperty(value = "客户别名")
    private String nickName;

    @ApiModelProperty(value = "客户名称")
    private String name;

    @ApiModelProperty(value = "客户密码")
    private String password;

    @ApiModelProperty(value = "手机号码")
    private String tel;

    @ApiModelProperty(value = "删除标志（0未删除，1删除）")
    private Integer isvalId;

    @ApiModelProperty(value = "创建时间")
    private String createTime;

    @ApiModelProperty(value = "创建用户id")
    private Long createUserId;

    @ApiModelProperty(value = "更新时间")
    private String updateTime;

    @ApiModelProperty(value = "更新用户id")
    private Long updateUserId;

    private Page page;

}
