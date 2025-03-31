package com.inspire12.likelionbackend.module.core.ioc.service;

import com.inspire12.likelionbackend.module.core.ioc.config.BeanComponentScanConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanShowService {

    public void showBean() {
//        ApplicationContext context =
//                new AnnotationConfigApplicationContext(CustomSimpleService.class);
//
//        // 빈 조회하기
//        CustomSimpleService myService = context.getBean(CustomSimpleService.class);
//        myService.sayName();

        // ApplicationContext (스프링 컨테이너) 생성
        ApplicationContext context =
                new AnnotationConfigApplicationContext(BeanComponentScanConfig.class);

        CustomAnnotationService myService = context.getBean(CustomAnnotationService.class);
        myService.sayName();
        // Spring 없이도 이렇게 빈을 생성할 수 있다. ApplicationContext로 설정 정보를 읽고 빈을 생성하고 관리되도록 등록할 수 있다.
    }
}
