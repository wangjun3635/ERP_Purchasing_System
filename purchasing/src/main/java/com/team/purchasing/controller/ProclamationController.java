package com.team.purchasing.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.team.purchasing.bean.Proclamation;
import com.team.purchasing.service.ProclamationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/getProclamation")
    @ApiOperation(value="公告信息查询", notes = "公告信息查询")
    public String queryProclamationByPage(@RequestBody Proclamation proclamation) {

        //1 更新page
        proclamation.getPage().setRowNumber();
        int count = proclamationService.queryProclamationCount();
        proclamation.getPage().setTotal(count);

        //2 查询数据
        List<Proclamation> proclamations
                = proclamationService.queryProclamationList(proclamation);

        ObjectMapper objectMapper = new ObjectMapper();
        String proclamationJson;
        try {
            proclamationJson
                    = objectMapper.writeValueAsString(proclamations);
        } catch (JsonProcessingException e) {
            log.error("json转换错误,当前proclamations为：{}", proclamations, e);
            throw new RuntimeException("json error");
        }

        return proclamationJson;
    }

    @PostMapping("/addProclamation")
    @ApiOperation(value="公告信息添加", notes = "公告信息添加")
    public int addProclamation(@RequestBody Proclamation proclamation){
        int result = proclamationService.addProclamation(proclamation);
        return result;
    }

}
