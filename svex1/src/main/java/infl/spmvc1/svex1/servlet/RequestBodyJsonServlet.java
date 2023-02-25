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
    
    private ObjectMapper om = new ObjectMapper();
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletInputStream is = req.getInputStream();
        String mbody = StreamUtils.copyToString(is, StandardCharsets.UTF_8);
        System.out.println("mbody = " + mbody);
        
        HelloData hd = om.readValue(mbody, HelloData.class);
        System.out.println("hd.getUsername() = " + hd.getUsername());
        System.out.println("hd.getAge() = " + hd.getAge());
    }
}
