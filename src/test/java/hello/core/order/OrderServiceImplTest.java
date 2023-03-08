package hello.core.order;

import org.junit.jupiter.api.Test;

class OrderServiceImplTest {

    @Test
    void createOrder() {
        OrderServiceImpl orderService = new OrderServiceImpl();
        orderService.createOrder(1L, "itemA", 10000);
        // -> NPE 발생 : 수정자 주입 시 단위 테스트의 문제점
    }
}