package com.inspire12.likelionbackend.module.core.security.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/security")
@RestController
public class SecurityController {

    private static final Logger log = LoggerFactory.getLogger(SecurityController.class);

    @GetMapping("/")
    public String home() {
        log.info("1234");
        return "홈 화면 - 로그인 필요 없음";
    }

    @GetMapping("/secure")
    public String getSecure() {
        return "로그인된 사용자만 접근 가능";
    }

    @PostMapping("/secure")
    public String doSecure() {
        return "로그인된 사용자만 접근 가능";
    }
}
