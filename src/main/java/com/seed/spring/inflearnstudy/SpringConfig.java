package com.seed.spring.inflearnstudy;

import com.seed.spring.inflearnstudy.repository.JdbcTemplateMemberRepository;
import com.seed.spring.inflearnstudy.repository.MemberRepository;
import com.seed.spring.inflearnstudy.repository.MemoryMemberRepository;
import com.seed.spring.inflearnstudy.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

// 스프링이 설정클래스에 명시된 대로 자동으로 의존성을 주입해준다.
// Controller에서 Autowired로 의존성을 요구할 때 스프링이 이 설정 클래스를 통해
// 주입해준다.

// 상황에 따라 구현클래스를 변경해야 한다면,
//  -> 인터페이스는 그대로 두고 하위 구현체를 변경해야할 상황에서
// 이곳 설정 클래스에서만 변경해주면 끝난다.
// ** 다른 코드를 손대지 않고 변경할 수 있다. **
@Configuration
public class SpringConfig {
    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
        return new JdbcTemplateMemberRepository(dataSource);
    }
}
