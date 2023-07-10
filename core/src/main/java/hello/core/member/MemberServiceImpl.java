package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    @Autowired private  MemberRepository memberRepository; // 필드 주입 방법.

//    @Autowired //의존관계 주입을 자동으로 연결해준다.
//    public MemberServiceImpl(MemberRepository memberRepository){
//        this.memberRepository = memberRepository; //생성자를 통해 어떤 저장소를 사용할지 정한다.
//    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //test용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
