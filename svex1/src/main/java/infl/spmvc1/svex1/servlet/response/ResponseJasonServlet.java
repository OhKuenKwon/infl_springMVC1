package infl.spmvc1.svex1.servlet.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import infl.spmvc1.svex1.servlet.HelloData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "responseJasonServlet", urlPatterns = "/response-jason")
public class ResponseJasonServlet extends HttpServlet {

    //Jason 라이브러리 객체 추가
    private ObjectMapper om = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Content-Type - Jason type의 ContentType 설정
        resp.setContentType("application/json");
        resp.setCharacterEncoding("utf-8");

        //HelloData 객체 생성 후 값 지정
        HelloData hd = new HelloData();
        hd.setUsername("Kwon");
        hd.setAge(38);

        //Jason 타입의 Data로 반환 -- {"username":"kim", "age":20}
        String result = om.writeValueAsString(hd);
        resp.getWriter().write(result);
        System.out.println("result = " + result);
    }
}
