<%@page import="transportation.management.system.AdminDAO"%>
<%@page import="transportation.management.system.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="AdminLogin.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Showing Manager Details</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f0f0;
        padding: 20px;
        display: flex;
        justify-content: center;
        align-items: center;
        min-height: 100vh;
    }
    .container {
        background-color: #fff;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
        width: 80%;
        max-width: 800px;
    }
    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
    }
    th, td {
        padding: 12px;
        text-align: left;
        border: 1px solid #ddd;
        color: #333;
    }
    th {
        background-color: #4CAF50;
        color: white;
    }
    a {
        color: #007bff;
        text-decoration: none;
    }
    a:hover {
        text-decoration: underline;
    }
</style>
</head>
<body>
<div class="container">
    <h1>Manager Details</h1>
    <%
        String id = request.getParameter("id");
        int id1 = Integer.parseInt(id);

        UserBean ub = AdminDAO.viewManagerAlldetail(id1);
        
        if (ub != null) {
    %>
    <table>
        <tr>
            <th>ID</th>
            <th>Username</th>
            <th>Password</th>
            <th>Date of Joining</th>
            <th>Date of Birth</th>
            <th>Salary</th>
            <th>Remove</th>
        </tr>
        <tr>
            <td><%= ub.getManagerId() %></td>
            <td><%= ub.getManagerName() %></td>
            <td><%= ub.getPassword() %></td>
            <td><%= ub.getDateOfJoining() %></td>
            <td><%= ub.getDateOfBirth() %></td>
            <td><%= ub.getSalary() %></td>
            <td><a href="MDS?id=<%= ub.getManagerId()%>">Delete</a></td>
        </tr>
    </table>
    <%
        } else {
    %>
    <p>No manager details found.</p>
    <%
        }
    %>
</div>
</body>
</html>
_