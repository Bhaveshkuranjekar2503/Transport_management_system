<%@ page import="java.util.List" %>
<%@ page errorPage="errorPage.jsp" %>
<%@ page import="transportation.management.system.UserBean" %>
<%@ include file="AdminLogin.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Manager Details Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            padding: 20px;
            margin: 0;
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
            max-width: 50%;
            overflow: hidden;
            margin-left: 50px;
        }
        .header {
            text-align: center;
            margin-bottom: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 10px;
        }
        th, td {
            padding: 12px;
            text-align: center;
            border: 1px solid #ddd;
            white-space: nowrap; /* Prevents text wrapping */
            overflow: hidden;
            text-overflow: ellipsis; /* Truncates text with ellipsis if overflow */
            color: #333; /* Dark color for text */
        }
        th.highlight {
            background-color: #4CAF50;
            color: white;
            text-align: center;
        }
        .no-managers {
            text-align: center;
            margin-top: 20px;
        }
        td a {
            color: #007bff; /* Blue color for hyperlink */
            text-decoration: none; /* Remove underline */
            text-align:center
        }
        td a:hover {
            text-decoration: underline; /* Underline on hover */
        }
    </style>
</head>
<body>

<div class="container">
    <div class="header">
        <h1>Manager Details</h1>
    </div>

    <table>
        <tr>
            <th class="highlight">ID</th>
            <th class="highlight">Name</th>
            <th class="highlight">Salary</th>
        </tr>
        <%
        // Retrieve the list of UserBeans from the request attribute
        List<UserBean> userList = (List<UserBean>) request.getAttribute("ub");
        
        if (userList != null && !userList.isEmpty()) {
            for (UserBean ub1 : userList) {
        %>
        <tr>
            <td><a href="ManagerDetails1.jsp?id=<%= ub1.getManagerId() %>"><%= ub1.getManagerId() %></a></td>
            <td><%= ub1.getManagerName() %></td>
            <td><%= ub1.getSalary() %></td>
        </tr>
        <%
            }
        } else {
        %>
        <tr>
            <td colspan="3" class="no-managers">No managers found.</td>
        </tr>
        <%
        }
        %>
    </table>
</div>

</body>
</html>
