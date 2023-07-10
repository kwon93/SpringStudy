package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

    private  MemberRepository memberRepository;  //private final로 한 이유 : 무조건 있어야 하는값이기 때문에
//    private DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private  DiscountPolicy discountPolicy;
    // 인터페이스에만 의존하도록 설계를 변경할 경우 nullPointer예외가 발생한다. 다른 어떤가가 구현 객체를 OrderServiceImpl에 주입해줘야한다.

    //AppConfig 를 통하여 사용해야되는 구현 객체를 주입받는다.

    @Autowired
    public void setMemberRepository(MemberRepository memberRepository){
        System.out.println("2. memberRepository = " + memberRepository);
        this.memberRepository = memberRepository;
    }

    @Autowired
    public void setDiscountPolicy(DiscountPolicy discountPolicy){
        System.out.println("3. discountPolicy = " + discountPolicy);
        this.discountPolicy = discountPolicy;
    }


//    @Autowired
//    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//        System.out.println("1. memberRepository = " + memberRepository);
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }

    @Autowired
    public void init(MemberRepository memberRepository, DiscountPolicy discountPolicy){
        this.discountPolicy = discountPolicy;
        this.memberRepository = memberRepository;
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
