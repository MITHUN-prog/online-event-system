<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP GET and POST Example</title>
</head>
<body>

<h2>JSP Form using GET Method</h2>

<form method="get" action="index.jsp">
    Name: <input type="text" name="gname" required><br><br>
    Age: <input type="number" name="gage" required><br><br>
    <input type="submit" value="Submit using GET">
</form>

<hr>

<h2>JSP Form using POST Method</h2>

<form method="post" action="index.jsp">
    Name: <input type="text" name="pname" required><br><br>
    Age: <input type="number" name="pageValue" required><br><br>
    <input type="submit" value="Submit using POST">
</form>

<hr>

<h2>Submitted Data</h2>

<%
    String gname = request.getParameter("gname");
    String gage = request.getParameter("gage");

    String pname = request.getParameter("pname");
    String pageValue = request.getParameter("pageValue");

    if (gname != null && gage != null) {
%>
    <p><b>GET Method Output:</b></p>
    Name: <%= gname %><br>
    Age: <%= gage %><br>
<%
    }

    if (pname != null && pageValue != null) {
%>
    <p><b>POST Method Output:</b></p>
    Name: <%= pname %><br>
    Age: <%= pageValue %><br>
<%
    }
%>

</body>
</html>
