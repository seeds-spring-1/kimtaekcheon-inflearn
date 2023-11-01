package com.seed.spring.inflearnstudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    // ResponseBody 어노테이션은 템플릿을 반환하는게 아니라 데이터만 반환한다.
    // 데이터를 반환할 때 JSON형태로 변환하여 반환한다.
    // 근데 문자열만 전달된다면 그냥 문자열만 반환한다.
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello-" + name;
    }

    @GetMapping("api/")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;
        public String getName(){return name;}
        public void setName(String name) {this.name = name;}
    }
}
