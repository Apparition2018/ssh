<%--
  Created by IntelliJ IDEA.
  User: Arsenal
  Date: 2019/2/25
  Time: 23:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML>
<html>
<head></head>
<body bgColor=#DDF0FB>
<table border="0" width="600px">
    <tr>
        <td align="center" style="font-size:24px; color:#666">编辑部门</td>
    </tr>
    <tr>
        <td align="right">
            <a href="javascript:document.getElementById('saveForm').submit()">保存</a> &nbsp;&nbsp;
            <a href="javascript:history.back()">退回 </a>
        </td>
    </tr>
</table>
<br/>
<s:form id="saveForm" action="department_update" method="POST" namespace="/" theme="simple">
    <s:hidden name="did" value="%{model.did}"/>
    <table style="font-size:16px">
        <tr>
            <td>部门名称：</td>
            <td><s:textfield name="dname" value="%{model.dname}"/></td>
        </tr>
        <tr>
            <td>部门介绍：</td>
            <td></td>
        </tr>
        <tr>
            <td width="10%"></td>
            <td>
                <s:textarea rows="5" cols="50" name="ddesc" value="%{model.ddesc}"/>
            </td>
        </tr>
    </table>
</s:form>
</body>
</html>
