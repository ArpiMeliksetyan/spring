<%@ page import="am.basic.springTest.model.Comment" %>
<%@ page import="am.basic.springTest.model.User" %>
<%@ page import="static am.basic.springTest.util.constants.ParameterKeys.USER_ATTRIBUTE_KEY" %>
<%@ page import="am.basic.springTest.service.CommentService" %>
<%@ page import="java.util.List" %>
<%@ page import="am.basic.springTest.service.impl.CommentServiceImpl" %>
<%@ page import="static am.basic.springTest.util.constants.ParameterKeys.MESSAGE_ATTRIBUTE_KEY" %>
<%--
  Created by IntelliJ IDEA.
  User: ruben.manukyan
  Date: 6/11/2020
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<a href="/logout" style="float: right">Logout</a>
<a href="/secure/home">Home</a>

<br><br>
<% if (request.getAttribute(MESSAGE_ATTRIBUTE_KEY) != null) { %>
<%=request.getAttribute(MESSAGE_ATTRIBUTE_KEY)%>
<% } %>
<br><br>


<br>

<form method="post" action="/secure/comments/add">
    Comment : <input type="text" name="name">
    Description : <input type="text" name="description">
    <input type="submit" value="add">
</form>
<br>
<br>



<%

    List<Comment> comments = (List<Comment>) request.getAttribute("comments");
%>

<table border="solid 1px">


    <%
        for (Comment comment : comments) {
    %>
    <tr>

        <td>
            <form method="post" action="/secure/comments/edit">
                <input type="hidden" name="id" value="<%=comment.getId()%>">
                <input type="text" name="name" value="<%=comment.getName()%>">
                <input type="text" name="description" value="<%=comment.getDescription()%>">
                <input type="submit" name="submit" value="DELETE">
                <input type="submit" name="submit" value="UPDATE">
            </form>
        </td>
            <%
        }
    %>

</table>



</body>
</html>
