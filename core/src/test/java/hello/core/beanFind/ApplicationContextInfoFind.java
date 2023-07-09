package hello.core.beanFind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class ApplicationContextInfoFind {

    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    GenericApplicationContext ac2 = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 스프링빈 출력하기")
    void findAllBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name : "+beanDefinitionName+" / object : "+bean);
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean(){
        String[] beanDefinitionNames = ac2.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac2.getBeanDefinition(beanDefinitionName);

            //ROLE_APPLICATION : 내가 직접 등록한 애플리케이션 빈
            //ROLE_INFRASTRUCTURE : 스프링이 내부에서 사용하는 빈
            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name : "+beanDefinitionName+" / object : "+bean);
            }
        }
    }
}
