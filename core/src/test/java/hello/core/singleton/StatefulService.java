package hello.core.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StatefulService {

//    private int price; //상태를 유지하는 필드

    public int order(String name, int price){
        System.out.println("name = "+name+"price = "+price);
//        this.price = price;  <- 문제가 되는 구간.
        return price; // <- 해결방법. 지역변수를 리턴하자.
    }



//    public int getPrice(){
//        return price;
//    }

}
