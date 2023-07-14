package spring.core.config;

import spring.core.discount.FixDiscountPolicy;
import spring.core.member.Member;
import spring.core.member.MemberService;
import spring.core.member.MemberServiceImpl;
import spring.core.member.MemoryMemberRepository;
import spring.core.order.OrderService;
import spring.core.order.OrderServiceImpl;

//애플리케이션의 전체 동작 방식을 구성하기 위해 구현 객체 생성 및 연결 책임 클래스
public class AppConfig {

    //구현체에 의존하지않고 추상화에 의존시켜 결합력을 낮추는 생성자 주입 방법
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(),new FixDiscountPolicy());
    }
}
