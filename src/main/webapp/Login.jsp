<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="errorPage.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Login Page</title>
<style>
    body {
        background: url('https://images.pexels.com/photos/2199293/pexels-photo-2199293.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260') no-repeat center center fixed;
        background-size: cover;
        color: #f5deb3;
        font-family: Arial, sans-serif;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }
    .login-container {
        background-color: rgba(51, 51, 51, 0.8); /* Adding transparency to the container background */
        padding: 30px;
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
        width: 300px;
    }
    h1 {
        margin-bottom: 20px;
        color: #ffa500;
    }
    input[type="text"], input[type="password"] {
        width: 100%;
        padding: 10px;
        margin: 10px 0;
        border: none;
        border-radius: 5px;
    }
    input[type="submit"] {
        width: 100%;
        padding: 10px;
        background-color: #ffa500;
        border: none;
        border-radius: 5px;
        color: #1a1a1a;
        font-weight: bold;
        cursor: pointer;
    }
    input[type="submit"]:hover {
        background-color: #ff8c00;
    }
</style>
</head>
<body>
<div class="login-container">
    <form action="loginServlet" method="get"> 
        <h1>Login Form</h1>
        <label for="username">Username</label>
        <input type="text" id="username" name="username" required>
        <br>
        <label for="password">Password</label>
        <input type="password" id="password" name="password" required>
        <br>
        <input type="submit" value="Login">
    </form>
</div>
</body>
</html>
