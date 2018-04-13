<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<shiro:hasRole name="admin">恭喜登录成功！</shiro:hasRole>
<shiro:hasRole name="test">${message}</shiro:hasRole>
</body>
</html>
