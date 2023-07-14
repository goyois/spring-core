package spring.core.order;

import spring.core.discount.DiscountPolicy;
import spring.core.discount.FixDiscountPolicy;
import spring.core.member.Member;
import spring.core.member.MemberRepository;
import spring.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();



    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findMember(memberId);
        //단일 책임의 원칙으로 OrderSerivce 는 알 수 없는 discount 메서드를 discountPolicy에 일임시킬 수 있다.
        int discount = discountPolicy.discount(member,itemPrice);

        return new Order(memberId,itemName,itemPrice,discount);

    }
}
