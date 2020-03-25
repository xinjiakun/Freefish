package com.buy.fish.common.pojo;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendEmail {

    public static void email(String email,Integer authcode)throws Exception {
        Properties properties = new Properties();
        properties.setProperty("mail.transport.protocol", "smtp");//发送邮件协议
        properties.setProperty("mail.smtp.auth", "true");//需要验证
        //properties.setProperty("mail.debug", "true");//设置debug模式 后台输出邮件发送的过程
        Session session = Session.getInstance(properties);
        session.setDebug(true);//debug模式
        //邮件信息
        Message messgae = new MimeMessage(session);
        messgae.setFrom(new InternetAddress("测试@sina.com"));//设置发送人
        messgae.setText("你的验证码为："+authcode+"。请注意，验证码有效时间为2分钟！！！");//设置邮件内容
        messgae.setSubject("邮箱验证");//设置邮件主题
        //发送邮件
        Transport tran = session.getTransport();
        tran.connect("smtp.sina.com", 25, "邮箱账户", "邮箱授权码");//连接到新浪邮箱服务器
        // tran.connect("smtp.qq.com",587, "Michael8@qq.vip.com", "xxxx");//连接到QQ邮箱服务器
        tran.sendMessage(messgae, new Address[]{ new InternetAddress(email)});//设置邮件接收人
        tran.close();
    }

    /**
     *
     * @return
     */
//    public static void sendMail(String to, String code){
//        //1.创建连接对象，连接到邮箱服务器
//        Properties props = new Properties();
//        Session session = Session.getInstance()
//    }

    public boolean changeEmail(){
        // 收件人电子邮箱
        String to = "1278326550@qq.com";

        // 发件人电子邮箱
        String from = "m13932208353@163.com";

        // 指定发送邮件的主机为 localhost
        String host = "localhost";

        // 获取系统属性
        Properties properties = System.getProperties();

        // 设置邮件服务器
        properties.setProperty("mail.163.host", host);

        // 获取默认session对象
        Session session = Session.getDefaultInstance(properties);

        try{
            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);

            // Set From: 头部头字段
            message.setFrom(new InternetAddress(from));

            // Set To: 头部头字段
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));

            // Set Subject: 头部头字段
            message.setSubject("This is the Subject Line!");

            // 设置消息体
            message.setText("This is actual message");

            // 发送消息
            Transport.send(message);
            System.out.println("Sent message successfully....");
            return true;
        }catch (MessagingException mex) {
            mex.printStackTrace();
            return false;
        }

    }
}
