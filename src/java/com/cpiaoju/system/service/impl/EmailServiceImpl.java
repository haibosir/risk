/*
package com.cpiaoju.system.service.impl;

import com.cpiaoju.system.service.EmailService;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.ClasspathResourceLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Map;

*/
/**
 * Created by huhb on 2019-06-19 下午 4:07.
 *//*

@Service
public class EmailServiceImpl implements EmailService {
    private static final String FROM_EMAIL = "huhb1002@163.com";  // 发件人
    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendTextEmail(String title, String content, String[] toEmails) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(FROM_EMAIL);
        message.setTo(toEmails);
        message.setSubject(title);
        message.setText(content);
        mailSender.send(message);
    }

    @Override
    public void sendFullTextEmail(String title, String html, String[] toEmails) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom(FROM_EMAIL);
        helper.setTo(toEmails);
        helper.setSubject(title);
        // 发送邮件
        helper.setText(html, true);
        mailSender.send(mimeMessage);
    }

    @Override
    public void sendHtmlEmail(String title, String htmlPath, Map<String, Object> map, String[] toEmails) throws MessagingException, IOException {
        ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader("templates/");
        Configuration cfg = Configuration.defaultConfiguration();
        GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
        Template t = gt.getTemplate(htmlPath);  // 加载html模板
        t.binding(map);  // 填充数据
        String html = t.render();  // 获得渲染后的html
        sendFullTextEmail(title, html, toEmails);  // 发送邮件
    }
}
*/
