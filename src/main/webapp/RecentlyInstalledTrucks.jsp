<%@page import="transportation.management.system.TruckBean"%>
<%@page import ="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Recently Installed Trucks</title>
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
        max-width: 900px;
        box-shadow: 0 0 20px rgba(0, 0, 0, 0.2);
    }
    h1 {
        text-align: center;
        color: #007BFF;
        margin-bottom: 20px;
    }
    table {
        width: 100%;
        border-collapse: collapse;
        margin-bottom: 20px;
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
    .back-link {
        text-align: center;
        margin-top: 20px;
    }
    .back-link a {
        display: inline-block;
        padding: 10px 20px;
        background: #007BFF;
        color: white;
        text-decoration: none;
        border-radius: 5px;
        transition: background 0.3s;
    }
    .back-link a:hover {
        background: #0056b3;
    }
</style>
</head>
<body>
<div class="container">
    <h1>Recently Installed Trucks</h1>
    <p>Here we are showing newly added trucks from the past month to today's date.</p>
    <%
    ServletContext sc = this.getServletContext();
    ArrayList<TruckBean> tb = (ArrayList<TruckBean>) sc.getAttribute("al");
    %>
    <table>
        <tr>
            <th>Model</th>
            <th>Number</th>
            <th>Owner</th>
            <th>Route</th>
            <th>Joining Date</th>
        </tr>
        <%
        if (tb != null) {
            for (TruckBean tb1 : tb) {
        %>
        <tr>
            <td><%= tb1.getTruckModel() %></td>
            <td><%= tb1.getTruckNumber() %></td>
            <td><%= tb1.getOwnerName() %></td>
            <td><%= tb1.getStartingPoint() %> - <%= tb1.getEndingPoint() %></td>
            <td><%= tb1.getJoiningdate() %></td>
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
        <a href="Index.html">Go back</a>
    </div>
</div>
</body>
</html>
