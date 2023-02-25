package infl.spmvc1.svex1.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name="requestBodyJosonServlet", urlPatterns = "/request-body-json")
public class RequestBodyJsonServlet extends HttpServlet {

    //Jason 라이브러리 객체 추가
    private ObjectMapper om = new ObjectMapper();
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //데이터 읽어오기 위한 stream 객체 생성 --> postmas 이용하여 Jason 타입의 데이터
        ServletInputStream is = req.getInputStream();
        String mbody = StreamUtils.copyToString(is, StandardCharsets.UTF_8);
        System.out.println("mbody = " + mbody);

        //Joson 타입의 데이터를 객체형으로 변환(Joson 라이브러리 이용)
        HelloData hd = om.readValue(mbody, HelloData.class);
        System.out.println("hd.getUsername() = " + hd.getUsername());
        System.out.println("hd.getAge() = " + hd.getAge());

        resp.getWriter().write("ok");
    }
}
