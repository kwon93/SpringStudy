package hello.core;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HelloLomBok {

    private String name;
    private int age;


    public static void main(String[] args) {
        HelloLomBok helloLomBok = new HelloLomBok();
        helloLomBok.setAge(10);
        helloLomBok.setName("lombok");
        System.out.println(helloLomBok.toString());
    }
}
