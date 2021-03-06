<%--
  Created by IntelliJ IDEA.
  User: CHILI_USER
  Date: 2017/11/27
  Time: 22:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.misky.maven.account.service.*,
    org.springframework.context.ApplicationContext,
    org.springframework.web.context.support.WebApplicationContextUtils" %>
<%
    String contextPath = request.getContextPath();

    ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext( getServletContext() );
    AccountService accountervice = (AccountService) context.getBean( "accountService" );
    String captchaKey = accountervice.generateCaptchaKey();
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="<%=contextPath %>/css/main-layout.css">
    <title>Account Service - Sign Up</title>
</head>
<body>
<div id="container">
    <h2>注册</h2>
    <form name="signup" action="signup" method="post" id="registerForm">
        <input type="hidden" name="key" value="<%= captchaKey%>">
        <table>
            <tr>
                <td>用户ID：</td><td><input type="text" name="uid"></td>
            </tr>
            <tr>
                <td>昵称：</td><td><input type="text" name="uname"></td>
            </tr>
            <tr>
                <td>关联邮箱:</td><td><input type="text" name="email"></td>
            </tr>
            <tr>
                <td>密码：</td><td><input type="password" name="pwd"></td>
            </tr>
            <tr>
                <td>确认密码：</td><td><input type="password" name="pwdConfirm"></td>
            </tr>
            <tr>
                <td>请输入验证码：</td><td><input type="text" name=captcha></td>
            </tr>
            <tr>
                <td colspan="2"><img src="<%= contextPath%>/captcha_image?key=<%= captchaKey %>"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="注册" onclick="checkForSubmit();">&nbsp;&nbsp;&nbsp;<input type="reset" value="取消"></td>
            </tr>
        </table>
    </form>
</div>
<script type="text/javascript" src="<%=contextPath %>/js/main.js"></script>
</body>
</html>
