package com.seed.spring.inflearnstudy;

import com.seed.spring.inflearnstudy.aop.TimeTraceAop;
import com.seed.spring.inflearnstudy.domain.JpaMemberRepository;
import com.seed.spring.inflearnstudy.repository.MemberRepository;
import com.seed.spring.inflearnstudy.service.MemberService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 스프링이 설정클래스에 명시된 대로 자동으로 의존성을 주입해준다.
// Controller에서 Autowired로 의존성을 요구할 때 스프링이 이 설정 클래스를 통해
// 주입해준다.

// 상황에 따라 구현클래스를 변경해야 한다면,
//  -> 인터페이스는 그대로 두고 하위 구현체를 변경해야할 상황에서
// 이곳 설정 클래스에서만 변경해주면 끝난다.
// ** 다른 코드를 손대지 않고 변경할 수 있다. **
@Configuration
public class SpringConfig {
    private final MemberRepository memberRepository;
    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

    // TimeTraceAop클래스를 @Bean으로 등록하지 않은 이유
    // 이미 @Component 어노테이션으로 컴포넌트 스캔을 통해 등록하도록 작성했기 때문이다.
    // @Bean을 통해 여기서 등록할 수 있는 방법과
    // @Component으로 컴포넌트 스캔을 하는 방법이 있다.


//    @Bean
//    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
//    }
}
