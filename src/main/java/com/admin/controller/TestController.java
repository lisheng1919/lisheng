package com.admin.controller;

import com.admin.exception.ReturnMessageException;
import com.admin.interceptor.RequestAnnotation;
import com.admin.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lisheng
 * @version TestController, v0.1 2018/11/3 16:27
 */
@RestController
@Slf4j
public class TestController {
    @Autowired
    TestService testService;
    public  Long count;

    @RequestMapping("test")
    public Long hello() {
        count = testService.count();
        log.info("threadName:{},threadId:{}",Thread.currentThread().getName(),Thread.currentThread().getId());
        return testService.count();
    }

    @RequestMapping("test2")
    @RequestAnnotation(key="key",value ="value")
    public Long hello2() throws ReturnMessageException{
        count = testService.count();
        getTestService();
        log.info("`````````````````````````````````````{}",count);
        return testService.count();
    }



    public void getTestService() {

        Set s1 = new HashSet();
        s1.add("1");
        s1.add("2");
        s1.add("3");
        Set s2 = new HashSet();
        s2.add("1");
        s2.add("2");
        s2.add("3");
        s1.retainAll(s2);

        throw new ReturnMessageException("000","测试");
    }

    public static void main(String[] args) {
        Set s1 = new HashSet();
        s1.add("1");
        s1.add("2");
        s1.add("3");
        Set s2 = new HashSet();
        s2.add("1");
        s2.add("2");
        s1.retainAll(s2);
        System.out.println(s1);

    }
}
