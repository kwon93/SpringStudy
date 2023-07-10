package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.stereotype.Component;

@Component
public class RateDiscountPolicy implements DiscountPolicy{


    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return (int) (price * 0.1);
        }else {
            return 0;
        }
    }
}
