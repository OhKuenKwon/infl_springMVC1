package infl.spmvc1.svex2.mvc2.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberVO {
    private Long id;
    private String username;
    private int age;

    public MemberVO() {
    }

    public MemberVO(String username, int age) {
        this.username = username;
        this.age = age;
    }
}
