package infl.spmvc1.svex1.servlet;

import lombok.Getter;
import lombok.Setter;

//lombok이 Getter Setter를 자동으로 만드는 tag
@Getter
@Setter
public class HelloData {
    private String username;
    private int age;
}
