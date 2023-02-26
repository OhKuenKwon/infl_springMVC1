package infl.spmvc1.svex2.mvc2.controller;

import infl.spmvc1.svex2.mvc2.action.ActionV1;
import infl.spmvc1.svex2.mvc2.action.MemberFormAction;
import infl.spmvc1.svex2.mvc2.action.MemberListAction;
import infl.spmvc1.svex2.mvc2.action.MemberSaveAction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV1", urlPatterns = "/front-controller/v1/*")
public class FrontControllerServletV1 extends HttpServlet {

    private Map<String, ActionV1> handlerMap = new HashMap<>();

    public FrontControllerServletV1() {
        //각 URI에 해당하는 Action클래스를 Mapping하여 Map 객체에 저장(key-URL,value-Action)
        handlerMap.put("/front-controller/v1/members/new-form", new MemberFormAction());
        handlerMap.put("/front-controller/v1/members/save", new MemberSaveAction());
        handlerMap.put("/front-controller/v1/members/list", new MemberListAction());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //URI를 가져와서 각 URI에 해당하는 Action을 Map객체에서 가져와 Mapping함
        //이때, 어떤 Action이 수행되어야 할지가 결정됨
        String reqURI = req.getRequestURI();
        ActionV1 av1 = handlerMap.get(reqURI);

        //만약 Mapping된 Action이 없으면,
        if(av1 == null){
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        //Mapping된 Action이 있으면 각 Action에 지정된 process()메소드를 실행
        av1.process(req, resp);
    }
}
