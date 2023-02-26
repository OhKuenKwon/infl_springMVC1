<%@ page import="infl.spmvc1.svex2.domain.member.Member" %>
<%@ page import="infl.spmvc1.svex2.domain.repository.MemberRepository" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //request, response는 JSP에서 기본적으로 사용가능
    MemberRepository mr = MemberRepository.getInstance();
    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age"));

    Member mb = new Member(username, age);
    mr.save(mb);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
    <li>id=<%=mb.getId()%>
    </li>
    <li>username=<%=mb.getUsername()%>
    </li>
    <li>age=<%=mb.getAge()%>
    </li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>
