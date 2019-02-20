package com.ynhuang.websocket.demo;

import lombok.extern.slf4j.Slf4j;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

/**
 * @Auther:ynhuang
 * @Date:20/2/19 下午9:24
 *
 * https://blog.csdn.net/shangmingtao/article/details/75810099
 *
 * 使用websocket需要考虑的问题：
 *  1、浏览器的兼容问题，兼容的环境版本：在Spring框架中使用WebSocket，
 *  需要 Spring4以上的版本；Spring4最低支持 jdk6，官方建议使用 jdk7+
 *  2、web容器版本，tomcat7.0+，jetty9.1+，webLogic12.1.3+
 *
 *  3、对于达到一定时间，连接被断开，一是合理设置nginx的超时时间，二是采用
 *  应用层心跳，假如设置10min/次
 *
 *  4、对于客户端异常、以及服务端异常怎么处理？
 *
 *  5、确定当前连接设置的最大连接数
 *
 *  6、数据传输的粘包问题？
 *
 */
@ServerEndpoint("/connect/{userId}")
@Slf4j
public class WebSocketServer {

    /*
  New Connected
   */
    @OnOpen
    public void onOpen(@PathParam("userId") String userId ,
                       Session session){
        log.info("[WebSocketServer] Connected : userId = "+ userId);
        WebSocketUtils.add(userId , session);
    }

    /*
    Send Message
     */
    @OnMessage
    public String onMessage(@PathParam("userId") String userId,
                            String message) {
        log.info("[WebSocketServer] Received Message : userId = "+ userId + " , message = " + message);
        if (message.equals("&")){
            return "&";
        }else{
            WebSocketUtils.receive(userId , message);
            return "Got your message ("+ message +").";
        }
    }

    /*
    Errot
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
