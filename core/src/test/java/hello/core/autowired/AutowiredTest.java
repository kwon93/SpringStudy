package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void autowiredOption(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);


    }

    static class TestBean{

        @Autowired(required = false) //자동 주입할 대상이 없으면 수정자 메서드 자체가 호출이 안됨.
        public void setNoBean(Member noBean1){ //주입할 대상이 없음
            System.out.println("noBean = " + noBean1);
        }
        @Autowired
        public void setNoBean2(@Nullable Member nobean2){
            System.out.println("nobean2 = " + nobean2);
        }

        @Autowired
        public void setNoBean3(Optional<Member> noBean3){
            System.out.println("noBean3 = " + noBean3);
        }
    }



}
