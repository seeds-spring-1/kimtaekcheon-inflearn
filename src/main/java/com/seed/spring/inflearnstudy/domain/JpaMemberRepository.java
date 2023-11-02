package com.seed.spring.inflearnstudy.domain;

import com.seed.spring.inflearnstudy.repository.MemberRepository;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository {
    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        // 대문자로 쓰니까 Symbol을 해석할 수 없다고 한다.
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();

        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        // sql쿼리가 아니다?
        // SELECT * FROM MEMBER 라고 할 텐데 * 자리에 변수가 그냥 들어간다...
        return em.createQuery("SELECT M from Member M", Member.class).getResultList();
    }

    @Override
    public void clearStore() {
        em.createQuery("DELETE FROM Member");
    }
}
