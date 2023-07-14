package spring.core.order;

import spring.core.config.AppConfig;
import spring.core.member.Grade;
import spring.core.member.Member;
import spring.core.member.MemberService;
import spring.core.member.MemberServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        
        //생성자 주입을 설정한 클래스를 가져와 각 객체에 주입시켜 사용함
        //결론: 도도ㅇㅁㅁㄴㅇ
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId,"itemA", 10000);

        System.out.println("order = " + order);
    }
}
