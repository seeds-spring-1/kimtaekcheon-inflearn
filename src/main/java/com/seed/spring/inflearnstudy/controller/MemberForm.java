package com.seed.spring.inflearnstudy.controller;

public class MemberForm {
    // html form에서 input의 name속성과 같은 이름을 갖는 멤버에
    // 값이 담겨서 전달될 것이다...?
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
