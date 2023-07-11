package hello.core;


import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
//        basePackages = "hello.core.member", // member package만 컴포넌트 스캔 조회 대상이 된다.
        basePackageClasses = AutoConfig.class, //클래스로 지정할 수 있다. defualt는 이 클래스의 패키지로부터 시작해 하위 패키지들 전부를 스캔.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        //AppConfig의 @Configuration(이것도 안에 @Compoenent가 들어가있기떄문에)도 찾으므로 필터를 건다.
)
public class AutoConfig {

//    @Bean(name = "memoryMemberRepository")
//    MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//    }

}
