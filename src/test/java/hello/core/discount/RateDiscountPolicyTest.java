package hello.core.discount;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RateDiscountPolicyTest {

    DiscountPolicy discountPolicy;

    @BeforeEach
    public void beforeEach() {
        discountPolicy = new AppConfig().discountPolicy();
    }

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다")
    public void vip_o() throws Exception {
        //given
        Member memberVIP = new Member(1L, "memberVIP", Grade.VIP);

        //when
        int discount = discountPolicy.discount(memberVIP, 10000);

        //then
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 10% 할인이 적용되지 않아아 한다")
    public void vip_x() throws Exception {
        //given
        Member memberNoVIP = new Member(1L, "memberNoVIP", Grade.BASIC);

        //when
        int discount = discountPolicy.discount(memberNoVIP, 10000);

        //then
        assertThat(discount).isEqualTo(0);
    }
}