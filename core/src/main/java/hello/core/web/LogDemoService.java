package hello.core.web;

import hello.core.common.MyLoger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {
    private final MyLoger myLoger;
    public void logic(String id) {
        myLoger.log("service ID : "+id);
    }
}
