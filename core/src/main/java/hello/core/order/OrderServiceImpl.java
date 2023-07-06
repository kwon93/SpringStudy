package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private MemberRepository memberRepository = new MemoryMemberRepository();
    private DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId); // 멤버저장소에서 멤버 아이디를 찾고
        int discountPrice = discountPolicy.discount(member, itemPrice);
        // 할인에 관한 책임은 discountPolicy에게 있다. OrderService에겐 영향이 없음. (단일 책임의 원칙)

        return new Order(memberId,itemName,itemPrice,discountPrice);
    }

}
