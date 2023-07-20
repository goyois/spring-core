package spring.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.core.discount.DiscountPolicy;
import spring.core.discount.RateDiscountPolicy;
import spring.core.member.MemberService;
import spring.core.member.MemberServiceImpl;
import spring.core.member.MemoryMemberRepository;
import spring.core.order.OrderService;
import spring.core.order.OrderServiceImpl;

//애플리케이션의 전체 동작 방식을 구성하기 위해 구현 객체 생성 및 연결 책임 클래스
@Configuration  //스프링 컨테이너가 해당 클래스를 스캔대상으로 인식하여 빈을 조회할 수 있음
public class AppConfig {

    //구현체에 의존하지않고 추상화에 의존시켜 결합력을 낮추는 생성자 주입 방법
    //현재 상태에서는 memberService 에서는 MemberSerivceImpl 를 사용할 것이다.

    @Bean  //스프링 컨테이너가 관리할 수 있는 객체로 등록되며 메서드명으로 등록됨
    public MemberService memberService() {
        return new MemberServiceImpl(getMemberRepository());  //Extract Method refactor
    }

    //현재 상태에서는 getMemberRepository 에서는 MemoryMemberRepository 를 사용할 것이다
    @Bean
    public  MemoryMemberRepository getMemberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(getMemberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
