package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
//    private DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private final DiscountPolicy discountPolicy;
    // 인터페이스에만 의존하도록 설계를 변경할 경우 nullPointer예외가 발생한다. 다른 어떤가가 구현 객체를 OrderServiceImpl에 주입해줘야한다.

    //AppConfig 를 통하여 사용해야되는 구현 객체를 주입받는다.
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId); // 멤버저장소에서 멤버 아이디를 찾고
        int discountPrice = discountPolicy.discount(member, itemPrice);
        // 할인에 관한 책임은 discountPolicy에게 있다. OrderService에겐 영향이 없음. (단일 책임의 원칙)

        return new Order(memberId,itemName,itemPrice,discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }

}
