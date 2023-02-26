package infl.spmvc1.svex2.mvc2.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ActionV1 {
    void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
