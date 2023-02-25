package infl.spmvc1.svex1.servlet;

import lombok.Getter;
import lombok.Setter;

//lombok이 Getter Setter를 자동으로 만드는 tag
//--> Lombok에 의해 setter와 getter를 간략히 만들 수 있다.
@Getter
@Setter
public class HelloData {
    private String username;
    private int age;
}
