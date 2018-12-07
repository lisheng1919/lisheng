package com.admin.Job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @author lisheng
 * @version ExcuteJob, v0.1 2018/11/30 15:56
 */
@Slf4j
@Component
public class ExcuteJob {
    private Map<String, BaseJob> transferJobs = new HashMap();
    private static volatile Integer j = 0;
    @Resource
    public void init(BaseJob... jobs) {
        log.info("ExcuteJob.........");
        transferJobs.put("key1", new AbstractJob());
    }


    /*@PostConstruct
    public void excute() {
        log.info("执行开始");
        //获得当前时间
        long startTime=System.currentTimeMillis();
        int availProcessors = Runtime.getRuntime().availableProcessors();
        log.info("availProcessors is：{}", availProcessors);
        //根据cpu的核心数开启固定数量的线程处理任务。
        ExecutorService executorService = Executors.newFixedThreadPool(availProcessors);
        //最多同时可以有多少个任务交由线程处理。
        Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < 100; i++) {
            executorService.submit(() -> {
                try {
                    semaphore.acquire();
                    log.info("submit:{},thread:{}",j++,Thread.currentThread().getName());
                    Thread.sleep(1000);
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        //获得当前时间
        long endTime=System.currentTimeMillis();
        log.info("执行完毕，耗时:{}",endTime-startTime);
   }*/
}
