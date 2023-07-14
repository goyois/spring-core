package spring.core.discount;

import spring.core.member.Member;

public interface DiscountPolicy {


    /**
     *
     * @return  핧인 대상 금액
     */
    int discount(Member member, int price);
}
