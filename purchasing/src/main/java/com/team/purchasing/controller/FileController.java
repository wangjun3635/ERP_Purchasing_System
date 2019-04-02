package com.team.purchasing.controller;

import com.team.purchasing.bean.FileInfo;
import com.team.purchasing.common.MessageInfo;
import com.team.purchasing.controller.response.file.FileResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @Auther: 018399
 * @Date: 2019/4/2 10:12
 * @Description:
 */
@RestController
@RequestMapping("/fileUpload")
@Api(tags="文件上传接口")
@Slf4j
public class FileController {

    @Value("${file.path}")
    private String filePath;

    @Value("${file.url}")
    private String url;

    @PostMapping("/uploadFile")
    @ApiOperation(value="文件上传", notes = "文件上传")
    public FileResponse upload(@RequestParam("file") MultipartFile file){

        String originalFilename = file.getOriginalFilename();
        String[] split = originalFilename.split("\\.");
        String fileType = split[1];
        //String filePath = "/Users/itinypocket/workspace/temp/";
        String uuid = UUID.randomUUID().toString();
        File dest = new File(filePath + uuid + "." + fileType);

        FileResponse fileResponse = new FileResponse();
        MessageInfo messageInfo = new MessageInfo();
        messageInfo.setCode("200");

        try {
            file.transferTo(dest);
            log.info("上传成功");
            messageInfo.setMessageText("上传成功");
        } catch (IOException e) {
            log.error("图片上传失败 : ", e);
            messageInfo.setMessageText("上传失败");
        }

        fileResponse.setMessageInfo(messageInfo);

        FileInfo fileInfo = new FileInfo();
        fileInfo.setName(uuid);
        fileInfo.setType(fileType);
        fileInfo.setUrl(url + uuid + "." + fileType);
        fileResponse.setFileInfo(fileInfo);

        return fileResponse;
    }

}
