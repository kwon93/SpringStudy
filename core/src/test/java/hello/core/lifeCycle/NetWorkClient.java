package hello.core.lifeCycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetWorkClient {

    private String url;

    public NetWorkClient() {
        System.out.println("생성자를 호출합니다. url = "+url);


    }

    public void setUrl(String url) {
        this.url = url;
    }

    //서비스 시작시 호출
    public void connect(){
        System.out.println("connet: "+ url);
    }

    public void call(String message){
        System.out.println("call : "+ url+" message : "+message);
    }

    //서비스 종료시
    public void disconnect(){
        System.out.println("close :"+url);
    }

    //인터페이스로 빈 등록 초기화
    @PostConstruct
    public void init(){
        System.out.println("NetWorkClient.init");
        connect();
        call("초기화 연결 메시지");
    }

     // 소멸 방법.
    @PreDestroy
    public void close(){
        System.out.println("NetWorkClient.close");
        disconnect();
    }
}
