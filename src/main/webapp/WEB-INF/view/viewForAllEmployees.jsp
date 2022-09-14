<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: stepanvasilyeu
  Date: 13/09/2022
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employees</title>
</head>
<body>

<h3>Information for all employees</h3>
<br><br>

<security:authorize access="hasRole('HR')">
    Only for hr staff <input type="button" value="Salary" onclick="window.location.href = 'hrInfo'">
</security:authorize>
<br><br>

<security:authorize access="hasRole('MANAGER')">
    Only for Managers <input type="button" value="Performance" onclick="window.location.href = 'managerInfo'">
</security:authorize>

</body>
</html>
