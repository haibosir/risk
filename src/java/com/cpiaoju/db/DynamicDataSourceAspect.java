/*
package com.cpiaoju.db;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

*/
/**
 * @ClassName DynamicDataSourceAspect
 * @Description //数据源动态切换AOP
 **//*

@Aspect
@Component
public class DynamicDataSourceAspect implements Ordered {

    protected static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceAspect.class);

    */
/**
     * 选择切入点为DataSource注解
     *//*

    @Pointcut("@annotation(com.cpiaoju.db.DataSource)"
            + "|| @within(com.cpiaoju.db.DataSource)")
    public void dsPointCut() {
    }

    @Around("dsPointCut()")
    public Object  around(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        DataSource ds = method.getAnnotation(DataSource.class);
        if(ds == null){
            DynamicDataSourceHelper.setDataSourceType(DataSourceNames.FIRST);
            logger.debug("set datasource is " + DataSourceNames.FIRST);
        }else {
            DynamicDataSourceHelper.setDataSourceType(ds.value());
            logger.debug("set datasource is " + ds.value());
        }

        try {
            return joinPoint.proceed();
        } finally {
            DynamicDataSourceHelper.clearDataSourceType();
            logger.debug("clean datasource");
        }
    }

    @Override
    public int getOrder() {
        return 1;
    }

}
*/
