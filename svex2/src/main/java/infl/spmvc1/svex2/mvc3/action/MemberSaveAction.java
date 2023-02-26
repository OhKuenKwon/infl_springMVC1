package infl.spmvc1.svex2.mvc3.action;

import infl.spmvc1.svex2.mvc3.controller.MyView;
import infl.spmvc1.svex2.mvc3.dao.MemberRepository;
import infl.spmvc1.svex2.mvc3.vo.MemberVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberSaveAction implements ActionV2 {

    MemberRepository mr = MemberRepository.getInstance();

    @Override
    public MyView process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        int age = Integer.parseInt(req.getParameter("age"));

        MemberVO mb = new MemberVO(username, age);
        mr.save(mb);

        //모델에 데이터 보관 및 전달
        req.setAttribute("member", mb);

        //version 1 코드
/*      String url = "/WEB-INF/views/save-result.jsp";
        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);*/

        //version 2에서 수정된 코드
        MyView myView = new MyView("/WEB-INF/views/save-result.jsp");
        return myView;
    }
}
