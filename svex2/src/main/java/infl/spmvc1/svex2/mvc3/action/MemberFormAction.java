package infl.spmvc1.svex2.mvc3.action;

import infl.spmvc1.svex2.mvc3.controller.MyView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberFormAction implements ActionV2 {
    @Override
    public MyView process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //version 1 코드
        /*      String url = "/WEB-INF/views/new-form.jsp";
        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);*/

        //version 2에서 수정된 코드
        MyView myView = new MyView("/WEB-INF/views/new-form.jsp");
        return myView;
    }
}
