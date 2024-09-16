<%@page import="java.util.ArrayList"%>
<%@ page errorPage="errorPage.jsp" %>
<%@page import="transportaion.manager.ManagerBean"%>
<%@page import="transportation.management.system.TruckBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Showing details of coming trucks</title>
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
</style>
</head>
<body>

<%
    ArrayList<TruckBean> tb = (ArrayList<TruckBean>) request.getAttribute("tableBean");
    ServletContext sc = this.getServletContext();
    ManagerBean mb = (ManagerBean) sc.getAttribute("mb");
%>

<div class="container">
    <h1>MOST CONVENIENT AND RELIABLE TRANSPORT SERVICES</h1>
    <h1>WELCOME TO OUR TRUCK TRACKING COMPANY</h1>
    <h3 class="important">Showing trucks details coming towards your branch <%= mb.getManagerBranch() %></h3>
    <table>
        <tr>
            <th>MODEL</th>
            <th>NUMBER</th>
            <th>OWNER</th>
            <th>FROM</th>
        </tr>
        <%
        if (tb != null) {
            for (TruckBean tb1 : tb) {
        %>
        <tr>
            <td><%= tb1.getTruckModel() %></td>
            <td><%= tb1.getTruckNumber() %></td>
            <td><%= tb1.getOwnerName() %></td>
            <td><%= tb1.getStartingPoint() %></td>
        </tr>
        <%
            }
        } else {
        %>
        <tr>
            <td colspan="4">No trucks found.</td>
        </tr>
        <%
        }
        %>
    </table>
    <a href="UpdateStatus.jsp">View all truck status and update its status</a>
</div>

</body>
</html>
