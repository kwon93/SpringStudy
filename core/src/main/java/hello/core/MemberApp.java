package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //Annotation을 기반으로 Spring Bean을 Control하는 컨테이너 객체 생성.
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member memberA = new Member(1L, "memberA", Grade.VIP);
        memberService.join(memberA);
        Member fideMember = memberService.findMember(1L);

        System.out.println("findMember = " + memberA.getName()); // 우리가 개체로 만든 memberA 가
        System.out.println("findMember = " + fideMember.getName()); //  memoryMemberRepository에 들어가 memberService에서 찾을 수 있게 되었다.


    }

}
