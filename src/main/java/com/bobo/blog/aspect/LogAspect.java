package com.bobo.blog.aspect;

import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LogAspect {

    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.bobo.blog.web.*.*(..))")
    public void log(){

    }

    @Before("log()")
    public void doBefore(){
        logger.info("-------doBefore-----------");
    }

    @After("log()")
    public void doAfter(){
        logger.info("-------doAfter-----------");
    }

    @AfterReturning(returning = "result",pointcut = "log()")
    public void doAfterReturing(Object result){
        logger.info("Return: {}",result);
    }
}
