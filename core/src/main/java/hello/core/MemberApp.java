package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member memberA = new Member(1L, "memberA", Grade.VIP);
        memberService.join(memberA);
        Member fideMember = memberService.findMember(1L);

        System.out.println("findMember = " + memberA.getName()); // 우리가 개체로 만든 memberA 가
        System.out.println("findMember = " + fideMember.getName()); //  memoryMemberRepository에 들어가 memberService에서 찾을 수 있게 되었다.


    }

}
