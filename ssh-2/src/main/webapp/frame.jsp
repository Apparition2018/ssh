<%--
  Created by IntelliJ IDEA.
  User: Arsenal
  Date: 2019/2/24
  Time: 23:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <title>员工管理系统</title>
</head>
<frameset rows="80,*">
    <frame name="top" src="${pageContext.request.contextPath}/frame/top.jsp">
    <frameset cols="150,*" id="main">
        <frame src="${pageContext.request.contextPath}/frame/left.jsp">
        <frame name="right" src="${pageContext.request.contextPath}/frame/right.jsp">
    </frameset>
</frameset>
</html>
