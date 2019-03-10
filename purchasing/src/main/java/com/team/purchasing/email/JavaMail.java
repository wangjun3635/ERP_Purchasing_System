package com.team.purchasing.email;

import lombok.extern.slf4j.Slf4j;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * @Auther:ynhuang
 * @Date:10/3/19 下午6:09
 * java邮件发送
 */
@Slf4j
public class JavaMail {

    //指定发送邮件的主机为 smtp.qq.com
    private static final String HOST = "smtp.qq.com";

    /**
     *
     * @param from 发送者 867120103@qq.com
     * @param to    接收者
     * @param fromPasswd 发送者密码 gpbcltdvrzlmbchb
     * @param title 邮件标题
     * @param context 邮件正文
     * @return
     */
    public static String sendMail(String from,
                                  String to,
                                  String fromPasswd,
                                  String title,
                                  String context) throws MessagingException {
        // 获取系统属性
        Properties properties = System.getProperties();

        // 设置邮件服务器
        properties.setProperty("mail.smtp.host", HOST);

        properties.put("mail.smtp.auth", "true");
        // 获取默认session对象
        Session session = Session.getDefaultInstance(properties,new Authenticator(){
            public PasswordAuthentication getPasswordAuthentication()
            {
                //发件人邮件用户名、授权码
                return new PasswordAuthentication(from, fromPasswd);
            }
        });

        try {
            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);

            // Set From: 头部头字段
            message.setFrom(new InternetAddress(from));

            // Set To: 头部头字段
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));

            // Set Subject: 头部头字段
            message.setSubject(title);

            // 设置消息体
            message.setText(context);

            // 发送消息e
            Transport.send(message);
        }catch (Exception e) {
            log.error("消息发送失败:", "错误", e);
            throw e;
        }

        return "Sent message successfully....from runoob.com";
    }

}
