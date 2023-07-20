package spring.core.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import spring.core.member.Grade;
import spring.core.member.Member;
import spring.core.member.MemberService;
import spring.core.member.MemberServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

class OrderAppTest {

    private final MemberService memberService;
    private final OrderService orderService;

    public OrderAppTest(MemberService memberService, OrderService orderService) {
        this.memberService = memberService;
        this.orderService = orderService;
    }

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId,"itemA", 10000);

        Assertions.assertThat(order.getDiscretePrice()).isEqualTo(10000);
    }

}