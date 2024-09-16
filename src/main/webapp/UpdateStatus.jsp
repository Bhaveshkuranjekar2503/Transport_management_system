<%@page import="transportation.management.system.TruckBean"%>
<%@page import="transportaion.manager.ManagerDAO"%>
<%@page import ="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>View all truck status and update status page</title>
<style>
    body {
        font-family: 'Arial', sans-serif;
        background-image: url('https://images.pexels.com/photos/93398/pexels-photo-93398.jpeg?auto=compress&cs=tinysrgb&fit=crop&h=1080&w=1920');
        background-size: cover;
        background-attachment: fixed;
        color: #333;
        margin: 0;
        padding: 0;
    }
    .container {
        background: rgba(255, 255, 255, 0.9);
        padding: 30px;
        border-radius: 10px;
        margin: 50px auto;
        max-width: 800px;
        box-shadow: 0 0 20px rgba(0, 0, 0, 0.2);
    }
    h1, h3 {
        text-align: center;
        color: #007BFF;
    }
    .important {
        color: #ff4500;
        font-weight: bold;
        font-size: 20px;
        margin: 20px 0;
        text-align: center;
    }
    table {
        width: 100%;
        border-collapse: collapse;
        margin: 20px 0;
    }
    table, th, td {
        border: 1px solid #007BFF;
    }
    th, td {
        padding: 15px;
        text-align: center;
    }
    th {
        background-color: #007BFF;
        color: white;
    }
    tr:nth-child(even) {
        background-color: #f2f2f2;
    }
    a {
        display: inline-block;
        margin: 20px 0;
        padding: 15px 30px;
        text-align: center;
        background: #007BFF;
        color: white;
        text-decoration: none;
        border-radius: 5px;
        transition: background 0.3s;
    }
    a:hover {
        background: #0056b3;
    }
    .back-link {
        text-align: center;
        margin-top: 20px;
    }
</style>
</head>
<body>

<div class="container">
    <h1>Truck Status Overview</h1>
    <h3 class="important">View all truck status and update as needed</h3>
    <%
    ArrayList<TruckBean> al = ManagerDAO.updateStatus();
    %>
    <table>
        <tr>
            <th>Model</th>
            <th>Number</th>
            <th>From</th>
            <th>To</th>
            <th>Status</th>
        </tr>
        <%
        if (al != null) {
            for (TruckBean tb1 : al) {
        %>
        <tr>
            <td><%= tb1.getTruckModel() %></td>
            <td><%= tb1.getTruckNumber() %></td>
            <td><%= tb1.getStartingPoint() %></td>
            <td><%= tb1.getEndingPoint() %></td>
            <td><a href="UpdateStatus2.jsp?id=<%= tb1.getTruckNumber() %>"><%= tb1.getStatus() %></a></td>
        </tr>
        <%
            }
        } else {
        %>
        <tr>
            <td colspan="5">No trucks found.</td>
        </tr>
        <%
        }
        %>
    </table>
    <div class="back-link">
        <a href="Details.html">Go back</a>
    </div>
</div>

</body>
</html>
y