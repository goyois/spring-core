package spring.core.beanfind;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.core.config.AppConfig;
import spring.core.member.MemberService;
import spring.core.member.MemberServiceImpl;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);


    @Test
    @DisplayName("빈 이름으로만 조회")
    void findBeanByName() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("타입으로만 조회")
    void findBeanByType() {
        MemberService memberService = ac.getBean(MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }


    //반환타입이 선언위치의 클래스나 인터페이스가 아니더라도 구현체여도 가능하지만 좋은 방법은 아님 (구현체가 아닌 역할에 의존하는 것이 바람직함)
    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByType2() {
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 으름으로 조회 x")
    void findBeanMyNameX() {
        //ac.getBean("XXXXX", MemberService.class);
        //해당 에러가 발생해야 성공

        assertThrows(NoSuchBeanDefinitionException.class,
        () -> ac.getBean("XXXXX", MemberService.class));
    }
}
