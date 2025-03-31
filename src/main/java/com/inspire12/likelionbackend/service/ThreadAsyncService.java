package com.inspire12.likelionbackend.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public class ThreadAsyncService { // 비동기 서비스
    private final Logger log = LoggerFactory.getLogger(this.getClass().getName());

    @Async
    public void getHello(){
        log.info("executing Thread Name .. [{}]", Thread.currentThread().getName());
        try {
            Thread.sleep(1000); // 1초간 정지
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
