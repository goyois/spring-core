package spring.core;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import spring.core.member.Grade;
import spring.core.member.Member;
import spring.core.member.MemberService;
import spring.core.member.MemberServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

class MemberAppTest {


    private final MemberService memberService;

    public MemberAppTest(MemberService memberService) {
        this.memberService = memberService;
    }

    @Test
    void join() {

        //given
        Member member = new Member(1L,"memberA", Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then
        Assertions.assertThat(member).isEqualTo(findMember);

    }

}