package hello.core.beanFind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBasicFindTest {


    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName(){
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        System.out.println("MemberService = " + memberService);
        System.out.println("memberService = " + memberService.getClass());

        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("이름없이 타입으로 조회")
    void findBeanByType(){
        MemberService memberService = ac.getBean(MemberService.class);
        System.out.println("MemberService = " + memberService);
        System.out.println("memberService = " + memberService.getClass());

        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("구현체 타입으로 조회") // 추상화에 의존하는게 좋으므로 구현 객체로 조회하기는 권장되는 않다.
    void findBeanByName2(){
        MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);
        System.out.println("MemberService = " + memberService);
        System.out.println("memberService = " + memberService.getClass());

        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회X")
    void findBeanByName_x(){ //항상 실패했을때의 테스트 코드도 작성해야한다!
//        MemberService memberService = ac.getBean("xxxx", MemberService.class);
        assertThrows(NoSuchBeanDefinitionException.class, // 이 예외가 발생해야지 테스트는 성공
                () -> ac.getBean("xxxx", MemberService.class)); // 이 로직을 수행했을때
    }
}
