package infl.spmvc1.svex2.mvc2.action;

import infl.spmvc1.svex2.mvc2.dao.MemberRepository;
import infl.spmvc1.svex2.mvc2.vo.MemberVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberSaveAction implements ActionV1{

    MemberRepository mr = MemberRepository.getInstance();

    @Override
    public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        int age = Integer.parseInt(req.getParameter("age"));

        MemberVO mb = new MemberVO(username, age);
        mr.save(mb);

        //모델에 데이터 보관 및 전달
        req.setAttribute("member", mb);

        String url = "/WEB-INF/views/save-result.jsp";
        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }
}
