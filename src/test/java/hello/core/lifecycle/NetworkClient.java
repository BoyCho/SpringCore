package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient implements InitializingBean, DisposableBean {

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
    }

    public void setUrl(String url) {
        System.out.println("필수 정보 삽입");
        this.url = url;
    }

    // 서비스 시작 시 호출
    public void connect() {
        System.out.println("connect: " + url);
    }

    public void call(String message) {
        System.out.println("call: " + url + " message = " + message);
    }

    // 서비스 종료 시 호출
    public void disconnect() {
        System.out.println("close" + url);
    }

    @Override
    public void destroy() throws Exception {
        disconnect();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("의존 관계 주입 완료");
        connect();
        call("초기화 연결 메시지");
    }
}
