package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용 되어야 한다.")
    void vip_o(){ // 성공할 경우의 테스트
        //given
        Member memberA = new Member(1L, "memberA", Grade.VIP);
        //when
        int discount = rateDiscountPolicy.discount(memberA, 10000);
        //then
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다.")
    void vip_x(){ // 테스트 성공시도 작성해야하지만 실패시의 경우도 테스트를 해야한다.
        //given
        Member memberB = new Member(2L,"mamberB",Grade.BASIC);
        //when
        int discountB = rateDiscountPolicy.discount(memberB, 10000);
        //then
        assertThat(discountB).isNotEqualTo(1000);
        
    }

}