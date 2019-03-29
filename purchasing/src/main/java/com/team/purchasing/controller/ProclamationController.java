package com.team.purchasing.controller;

import com.team.purchasing.bean.Proclamation;
import com.team.purchasing.bean.ProductCategory;
import com.team.purchasing.common.MessageInfo;
import com.team.purchasing.controller.request.ProclamationRequest;
import com.team.purchasing.controller.request.ProductCategoryRequest;
import com.team.purchasing.controller.response.ProclamationResponse;
import com.team.purchasing.service.ProclamationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther:ynhuang
 * @Date:23/2/19 下午5:12
 * 公告信息controller
 */
@RestController
@RequestMapping("/proclamation")
@Api(tags="公告信息接口")
@Slf4j
public class ProclamationController {

    @Resource
    private ProclamationService proclamationService;

    // TODO: 24/2/19 创建公告之后，不能立刻在商城上显示，需要审核通过之后才能在商城展示

    @PostMapping("/queryProclamation")
    @ApiOperation(value="公告信息查询,只能查询审核通过的数据auditStatus=1", notes = "公告信息查询")
    public ProclamationResponse queryProclamationByPage(@RequestBody ProclamationRequest request) {

        Proclamation proclamation = request.getProclamation();

        //1 更新page
        int count = proclamationService.queryProclamationCount();
        proclamation.getPage().init(count);

        //2 查询数据
        List<Proclamation> proclamations
                = proclamationService.queryProclamationList(proclamation);

        ProclamationResponse proclamationResponse = new ProclamationResponse();
        proclamationResponse.setProclamationList(proclamations);
        proclamationResponse.setPage(proclamation.getPage());

        return proclamationResponse;
    }

    @PostMapping("/addProclamation")
    @ApiOperation(value="公告信息添加", notes = "公告信息添加")
    public ProclamationResponse addProclamation(@RequestBody ProclamationRequest request){

        Proclamation proclamation = buildUserInfo(request);

        int result = proclamationService.addProclamation(proclamation);

        ProclamationResponse proclamationResponse = new ProclamationResponse();
        MessageInfo messageInfo = new MessageInfo();
        messageInfo.setCode("200");
        if(result == 1) {
            messageInfo.setMessageText("新增成功!");
        }else {
            messageInfo.setMessageText("新增失败!");
        }
        proclamationResponse.setMessageInfo(messageInfo);

        return proclamationResponse;
    }

    private Proclamation buildUserInfo(ProclamationRequest proclamationRequest) {

        Proclamation proclamation = proclamationRequest.getProclamation();

        proclamation.setCreateUserId(proclamationRequest.getBaseUserInfo().getUserId() == null
                ? proclamationRequest.getBaseUserInfo().getHcId()
                : proclamationRequest.getBaseUserInfo().getUserId());
        proclamation.setUpdateUserId(proclamationRequest.getBaseUserInfo().getUserId() == null
                ? proclamationRequest.getBaseUserInfo().getHcId()
                : proclamationRequest.getBaseUserInfo().getUserId());

        return proclamation;
    }

}
