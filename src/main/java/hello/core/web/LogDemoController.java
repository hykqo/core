package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
    private final MyLogger myLogger;
//Scope 'request' is not active for the current thread;가 발생한다
//의존관계 주입이 일어나면 myLogger빈이 없기때문에 에러가 발생한다.
//myLogger빈의 생존범위는 고객에게 요청이 들어올떄 생성이 되지만, 고객에게 요청이 없기때문에  myLogger는 현재 활성화가 되어있지 않은 상태다,.
//활성화 되지 않은 상태에서 myLogger를 요청했기때문에 에러가 발생했다.

    @RequestMapping("log-demo")
    @ResponseBody //뷰 화면이 없이 문자를 반환하기 위해 해당 어노테이션 사용
    public String logDemo(HttpServletRequest request){
        String requestURL = request.getRequestURL().toString();
        myLogger.setRequestURL(requestURL);
        myLogger.log("controller test");
        logDemoService.logic("testID");
        return "OK";
    }
}
