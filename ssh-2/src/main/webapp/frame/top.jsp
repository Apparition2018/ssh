<%--
  Created by IntelliJ IDEA.
  User: Arsenal
  Date: 2019/2/24
  Time: 23:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <style type="text/css">
        .div1 {
            margin-top: 50px;
            margin-left: 600px;
            font-size: 14px;
            color: white
        }
    </style>
</head>

<body bgcolor="#0099FF">
<div class="div1">
    欢迎您：<s:property value="#session.existEmployee.ename" />
</div>
</body>
</html>
