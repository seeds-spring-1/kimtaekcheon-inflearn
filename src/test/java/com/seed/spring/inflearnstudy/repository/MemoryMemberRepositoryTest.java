package com.seed.spring.inflearnstudy.repository;

import com.seed.spring.inflearnstudy.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*; // static함수 전부 import?

class MemoryMemberRepositoryTest {
    MemberRepository repository = new MemoryMemberRepository();

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);
        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("t1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("t2");
        repository.save(member2);

        Member result = repository.findByName("t1").get();
        assertThat(result).isEqualTo(member1);
        assertThat(result).isNotEqualTo(member2);

        result = repository.findByName("t2").get();
        assertThat(result).isNotEqualTo(member2);
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("m1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("m2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
