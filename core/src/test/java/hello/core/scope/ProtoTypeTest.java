package hello.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.assertThat;

public class ProtoTypeTest {



    @Test
    void prototypeBeanTest(){

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        System.out.println("findProtorypeBean1");
        PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
        //다른 객체를 반환함 prototypeBean1 = hello.core.scope.ProtoTypeTest$PrototypeBean@78641d23
        System.out.println("findProtorypeBean2");
        PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);
        //prototypeBean2 = hello.core.scope.ProtoTypeTest$PrototypeBean@74589991
        System.out.println("prototypeBean1 = " + prototypeBean1);
        System.out.println("prototypeBean2 = " + prototypeBean2);

        assertThat(prototypeBean1).isNotSameAs(prototypeBean2);

        ac.close();

        prototypeBean1.destroy(); // 직접 호출해서 소멸시켜야함.
        prototypeBean2.destroy();

    }

    @Scope("prototype")
    static class PrototypeBean{
        @PostConstruct
        public void init(){
            System.out.println("PrototypeBean.init");
        }

        @PreDestroy
        public void destroy(){
            System.out.println("PrototypeBean.destroy");
            //프로토타입은 소멸이 호출되지 않음. 생성 후 반환한뒤 컨테이너에 없기 때문에.
        }
    }
}
