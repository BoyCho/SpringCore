package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    /**
     * private final DiscountPolicy rateDiscountPolicy;
     *
     * DIP 위반 아님 : 여전히 RateDiscountPolicy 가 아닌 DiscountPolicy 사용중
     * OCP 위반 아님 : rateDiscountPolicy 이 어색하긴 하지만, 이 파라미터에 Fix 를 넘기든 Rate 를 둘 다 정상 작동함 (물론 이 경우는 스프링을 이용하지 않는 경우임 (단위 테스트에선 활용 될 수 있을 듯))
     */

    /*
    // 수정자 주입
    @Autowired
    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

    @Autowired
    public void setMemberRepository(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }*/

    // 생성자 주입
    /*public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }*/

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
