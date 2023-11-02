package com.seed.spring.inflearnstudy.controller;

import com.seed.spring.inflearnstudy.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

// @Controller 요청을 받는 역할
// @Service 비즈니스 로직을 수행하는 역할
// @Repository DB와 상호작용하는 역할

// Controller, Service, Repository가 모두 자동으로 스프링이 관리할 수 있는
// 이유는, 세 개 모두 @Component 어노테이션으로 작성되었기 때문이다.
// 내부적으로 어떻게 관리되는지는 알 필요가 없다.
// 스프링 빈을 등록할 때에는 싱글톤으로 등록된다.

@Controller
public class MemberController {
    private final MemberService memberService;

    // 필드 주입
    // 중간에 어떤 로직이 들어가야한다면 사용할 수 없는 방법이다.
    // @Autowired private final MemberService memberService;

    // 생성자 주입
    // best practice
    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    // setter 주입
    // 항상 public으로 설정되어 있어야 한다.
    // 중간에 바뀔 가능성이 있으니까 좋지는 않다.
    // public void setMemberService(MemberService memberService) {
    //     this.memberService = memberService;
    // }
}
