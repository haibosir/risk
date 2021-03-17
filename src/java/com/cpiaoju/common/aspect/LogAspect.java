package com.cpiaoju.common.aspect;

import com.cpiaoju.common.annotation.Log;
import com.cpiaoju.common.shiro.ShiroUtils;
import com.cpiaoju.common.utils.HttpContextUtils;
import com.cpiaoju.common.utils.StringUtil;
import com.cpiaoju.common.utils.UserAgentGetter;
import com.cpiaoju.system.model.LoginRecord;
import com.cpiaoju.system.service.LoginRecordService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.time.LocalDateTime;

@Aspect
@Component
public class LogAspect {

    @Autowired
    LoginRecordService logService;


    @Pointcut("@annotation(com.cpiaoju.common.annotation.Log)")
    public void logPointCut() {
    }

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        // 执行方法
        Object result = point.proceed();
        // 执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;
        //异步保存日志
        saveLog(point);
        return result;
    }
    void saveLog(ProceedingJoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Log syslog = method.getAnnotation(Log.class);
        if (syslog != null){
            HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
            if(ShiroUtils.getUser().getUserId() != -1){
                UserAgentGetter agentGetter = new UserAgentGetter(request);
                LoginRecord loginRecord = new LoginRecord();
                loginRecord.setUserId(ShiroUtils.getUserId());
                loginRecord.setOsName(agentGetter.getOS());
                loginRecord.setDevice(agentGetter.getDevice());
                loginRecord.setBrowserType(agentGetter.getBrowser());
                loginRecord.setIpAddress(agentGetter.getIpAddr());
                loginRecord.setRemark(syslog.value());
                loginRecord.setCreateTime(LocalDateTime.now());
                logService.save(loginRecord);
            }
        }
    }
}
