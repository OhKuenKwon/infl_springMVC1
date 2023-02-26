package infl.spmvc1.svex2.mvc2.action;

import infl.spmvc1.svex2.mvc2.dao.MemberRepository;
import infl.spmvc1.svex2.mvc2.vo.MemberVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MemberListAction implements ActionV1{

    MemberRepository mr = MemberRepository.getInstance();

    @Override
    public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<MemberVO> list = mr.findAll();
        req.setAttribute("members", list);

        String viewPath = "/WEB-INF/views/members.jsp";
        RequestDispatcher dispatcher = req.getRequestDispatcher(viewPath);
        dispatcher.forward(req, resp);
    }
}
