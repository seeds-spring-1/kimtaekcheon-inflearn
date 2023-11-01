package com.seed.spring.inflearnstudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InflearnStudyController {
    // '/'url에 대해 GET요청이 수신될 때 이 함수가 실행됨
    @GetMapping("/")
    public String doSomething(Model model) {
        model.addAttribute("data", "Hello-data");

        // string형태로 전달하여 동적으로 view를 찾는다.
        // templates/에서 이 이름을 가진 view를 resolve하여 렌더링하게 된다?
        return "12344";
    }

    // get 요청할 때 params를 추가로 넘겨줄 때 읽어올 수 있다.
    // 근데 이러면 인자가 너무 많아질텐데, 좋은 방법이 있을까?
    @GetMapping("hello-mvc")
    public String doSomething2(@RequestParam(value = "name", required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }
}
