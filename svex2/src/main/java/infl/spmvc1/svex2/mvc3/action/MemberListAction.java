package infl.spmvc1.svex2.mvc3.action;

import infl.spmvc1.svex2.mvc3.controller.MyView;
import infl.spmvc1.svex2.mvc3.dao.MemberRepository;
import infl.spmvc1.svex2.mvc3.vo.MemberVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MemberListAction implements ActionV2 {

    MemberRepository mr = MemberRepository.getInstance();

    @Override
    public MyView process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<MemberVO> list = mr.findAll();
        req.setAttribute("members", list);

        //version 1 코드
/*      String viewPath = "/WEB-INF/views/members.jsp";
        RequestDispatcher dispatcher = req.getRequestDispatcher(viewPath);
        dispatcher.forward(req, resp);*/

        //version 2에서 수정된 코드
        MyView myView = new MyView("/WEB-INF/views/members.jsp");
        return myView;
    }
}
