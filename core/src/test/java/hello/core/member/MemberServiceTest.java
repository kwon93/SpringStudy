package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService ;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService  = appConfig.memberService();

    }

    @Test
    void join(){
        //given : member라는 객체가 주어지고
        Member member = new Member(1L,"memberA",Grade.VIP);
        //when : memberservice를 통해 join 한뒤 findMember 기능들을 실행할 때.
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        //then
        Assertions.assertThat(member).isEqualTo(findMember);
    }


}
