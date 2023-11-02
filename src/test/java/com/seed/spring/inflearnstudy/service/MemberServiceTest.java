package com.seed.spring.inflearnstudy.service;

import com.seed.spring.inflearnstudy.domain.Member;
import com.seed.spring.inflearnstudy.repository.MemberRepository;
import com.seed.spring.inflearnstudy.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MemberServiceTest {
    MemberService memberService;
    MemberRepository memberRepository;

    @BeforeEach()
    void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }


    @AfterEach
    void clear() {
        // repository의 store변수가 static이라서 초기화를 할 수 있다.
        memberRepository.clearStore();
    }
    @Test
    void join() {
        // given
        // 주어진 상황에서
        Member member = new Member();
        member.setName("asdf");

        // when
        // 어떤 일이 일어나면
        Long saveId = memberService.join(member);

        // then
        // 결과는 이렇다
        assertThat(memberService.findOne(saveId).get().getName()).isEqualTo(member.getName());
    }

    @Test
    void 중복된_이름을_가진_회원가입(){
        // given
        Member member1 = new Member();
        member1.setName("spring");
        Member member2 = new Member();
        member2.setName("spring");

        // when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        // then
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }

    @Test
    void findMembers(){

    }

    @Test
    void findOne() {

    }
}
