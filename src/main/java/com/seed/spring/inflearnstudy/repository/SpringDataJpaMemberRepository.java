package com.seed.spring.inflearnstudy.repository;

import com.seed.spring.inflearnstudy.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// JpaRepository를 통해 구현체를 제공받을 수 있으니까 인터페이스만 작성해도 가능하다.
// JpsRepository안에 기본적인 메서드들이 제공되어 있다. 스프링이 구현체를 만들어 제공하나,
// 커스텀 메서드들은 다른 인터페이스에 구현하여 사용하여야 한다.
// 기본적인 메서드들은 문서를 보고 공부하기.
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    // findBy~형태로 작성하면
    // 구현체에서 자동으로 메서드를 구현한다.
    @Override
    Optional<Member> findByName(String name);
}
