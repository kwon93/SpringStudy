package hello.core.scan;

import hello.core.AppConfig;
import hello.core.AutoConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {

    @Test
    void basicScan(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoConfig.class);
        MemberService memberService = ac.getBean("memberServiceImpl",MemberService.class);
                                                //컴포넌트 스캔시 빈의 기본이름은 클래스명의 앞글자만 소문자로 변경해 사용한다.
                                                //@Component("memberServiceImpl2") 이렇게 직접 지정도 가능.

        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
    }

    @Test
    void setterDiTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoConfig.class);
        OrderServiceImpl orderService = ac.getBean(OrderServiceImpl.class);
    }

    @Test
    void fieldDiTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoConfig.class);
        MemberService memberService = ac.getBean(MemberService.class);
        System.out.println("~~~ memberService = " + memberService);

        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
        
        

    }

}
