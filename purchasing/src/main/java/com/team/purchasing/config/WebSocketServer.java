package com.team.purchasing.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * @Auther:ynhuang
 * @Date:1/3/19 下午11:27
 */
@ServerEndpoint(value = "/upload/{userId}")
@Component
@Slf4j
// TODO: 1/3/19 需要一点的是：如果设置了拦截器，该请求路径一定要设置为允许
public class WebSocketServer {

    /*
     New Connected
    */
    @OnOpen
    public void onOpen(@PathParam("userId") String userId ,
                       Session session){

        log.info("[WebSocketServer] Connected : userId = "+ userId);

        //1 当前session最大文件传输大小
        session.setMaxBinaryMessageBufferSize(5 * 1024 * 1024);

        //2 添加进入聊天室的用户
        WebSocketUtils.add(userId , session);
    }

    @OnMessage
    public String onMessage(@PathParam("userId") String userId,
                            ByteBuffer message, Session session) throws IOException {

        //1 存储文件到服务器路径
        File file = new File("filepath");

        //2 输入流
        FileOutputStream fe = new FileOutputStream(file,true);

        //3 写文件
        fe.write(message.array());
        fe.flush();
        fe.close();


        return "success";

    }

    /*
    Error
     */
    @OnError
    public void onError(@PathParam("userId") String userId,
                        Throwable throwable,
                        Session session) {
        log.info("[WebSocketServer] Connection Exception : userId = "+ userId + " , throwable = " + throwable.getMessage());
        WebSocketUtils.remove(userId);
    }

    /*
    Close Connection
     */
    @OnClose
    public void onClose(@PathParam("userId") String userId,
                        Session session) {
        log.info("[WebSocketServer] Close Connection : userId = " + userId);
        WebSocketUtils.remove(userId);
    }

}
