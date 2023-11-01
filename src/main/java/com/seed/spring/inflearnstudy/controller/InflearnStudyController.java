package com.seed.spring.inflearnstudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InflearnStudyController{
    // '/'url에 대해 GET요청이 수신될 때 이 함수가 실행됨
    @GetMapping("/")
    public String doSomething(Model model){
        model.addAttribute("data", "Hello-data");

        // string형태로 전달하여 동적으로 view를 찾는다.
        // templates/에서 이 이름을 가진 view를 resolve하여 렌더링하게 된다?
        return "12344";
    }
}
