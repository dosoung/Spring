package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true) //기본적으로 트랜잭션에서 실행되야한다. jpa는
@RequiredArgsConstructor //final있는 field만 가지고 생성자를 만들어준다.
public class MemberService {

    private final MemberRepository memberRepository;
    /**
     *회원가입
     */
    @Transactional
    public Long join(Member member) {

        validateDuplidateMember(member); //중복 회원 검증 비지니스로직
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplidateMember(Member member) {
        //EXCEPTION
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if(!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    //회원 전체조회
    //읽기용에는 readonly넣어주는게 좋다.

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }
    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }
}
