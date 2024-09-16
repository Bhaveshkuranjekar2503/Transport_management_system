<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
     <%@ page errorPage="errorPage.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error page of syntax error, logical error, or other error</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f8f8f8;
        color: #333;
        text-align: center;
        padding: 50px;
    }
    .container {
        max-width: 600px;
        margin: auto;
        background: #fff;
        padding: 30px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        border-radius: 8px;
    }
    h1 {
        font-size: 48px;
        margin-bottom: 10px;
        color: #e74c3c;
    }
    h3 {
        font-size: 24px;
        margin-bottom: 30px;
    }
    p {
        font-size: 18px;
        color: #777;
    }
    .back-btn {
        display: inline-block;
        padding: 10px 20px;
        font-size: 18px;
        color: #fff;
        background-color: #3498db;
        text-decoration: none;
        border-radius: 5px;
        transition: background-color 0.3s;
    }
    .back-btn:hover {
        background-color: #2980b9;
    }
    .background-image {
        position: absolute;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        object-fit: cover;
        z-index: 1;
    }
</style>
</head>
<body>
    <div class="container">
        <h1>Something went wrong</h1>
        <h3>Error Details:</h3>
        <p><%= exception %></p>
        <a href="Index.html" class="back-btn">Back to Home</a>
    </div>
</body>
</html>
