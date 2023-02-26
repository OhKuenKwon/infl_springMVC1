package infl.spmvc1.svex2.mvc3.controller;

import infl.spmvc1.svex2.mvc3.action.ActionV2;
import infl.spmvc1.svex2.mvc3.action.MemberFormAction;
import infl.spmvc1.svex2.mvc3.action.MemberListAction;
import infl.spmvc1.svex2.mvc3.action.MemberSaveAction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV2", urlPatterns = "/front-controller/v2/*")
public class FrontControllerServletV2 extends HttpServlet {

    private Map<String, ActionV2> handlerMap = new HashMap<>();

    public FrontControllerServletV2() {
        //각 URI에 해당하는 Action클래스를 Mapping하여 Map 객체에 저장(key-URL,value-Action)
        handlerMap.put("/front-controller/v2/members/new-form", new MemberFormAction());
        handlerMap.put("/front-controller/v2/members/save", new MemberSaveAction());
        handlerMap.put("/front-controller/v2/members/list", new MemberListAction());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //URI를 가져와서 각 URI에 해당하는 Action을 Map객체에서 가져와 Mapping함
        //이때, 어떤 Action이 수행되어야 할지가 결정됨
        String reqURI = req.getRequestURI();
        ActionV2 av2 = handlerMap.get(reqURI);

        //만약 Mapping된 Action이 없으면,
        if(av2 == null){
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        //Mapping된 Action이 있으면 각 Action에 지정된 process()메소드를 실행
        //av2.process(req, resp);
        MyView view = av2.process(req, resp);
        view.render(req, resp);
    }
}
