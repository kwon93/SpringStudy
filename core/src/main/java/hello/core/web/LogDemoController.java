package hello.core.web;

import hello.core.common.MyLoger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
    private final MyLoger myLoger; //고객 요청이 들어와야 생성되는데 최초 스프링 실행시에는 고객 요청이 없다. -> proxymode로 해결~

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request){

        String requestURL = request.getRequestURL().toString(); // 고객이 어떤 URL로 요청했는지 알 수 있다.
        myLoger.setRequestURL(requestURL);

        myLoger.log("controller test");
        logDemoService.logic("testID");
        return "OK";
    }
}
