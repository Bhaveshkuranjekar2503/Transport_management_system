<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="transportation.management.system.TruckBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Showing Truck Details</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f0f0;
        padding: 20px;
        background-image: url('https://images.pexels.com/photos/2199293/pexels-photo-2199293.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260');
        background-size: cover;
        background-position: center;
        background-repeat: no-repeat;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }
    .content {
        background-color: rgba(255, 255, 255, 0.8); /* Semi-transparent white background for better readability */
        padding: 20px;
        border-radius: 10px;
        max-width: 800px;
        text-align: center;
    }
    table {
        width: 100%;
        margin-top: 20px;
        border-collapse: collapse;
    }
    th, td {
        padding: 10px;
        text-align: left;
        border: 1px solid #ddd;
    }
    th {
        background-color: #f2f2f2;
    }
    .truck-image {
        max-width: 100%;
        display: block;
        margin: 20px auto;
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
    }
</style>
</head>
<body>
    <div class="content">
        <h1>Showing Truck Details</h1>
        <%
            // Retrieve the TruckBean from request attribute
            TruckBean tb = (TruckBean) request.getAttribute("tb");
            
            // Check if tb is not null
            if (tb != null) {
        %>
        <img src="https://images.pexels.com/photos/2199293/pexels-photo-2199293.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260" alt="Truck Image" class="truck-image">
        <table>
            <tr>
                <th>Model</th>
                <td><%= tb.getTruckModel() %></td>
            </tr>
            <tr>
                <th>Truck Number</th>
                <td><%= tb.getTruckNumber() %></td>
            </tr>
            <tr>
                <th>Insurance</th>
                <td><%= tb.getInsurance() %></td>
            </tr>
            <tr>
                <th>Owner Name</th>
                <td><%= tb.getOwnerName() %></td>
            </tr>
            <tr>
                <th>Mobile Number</th>
                <td><%= tb.getMobileNo() %></td>
            </tr>
            <tr>
                <th>Route</th>
                <td><%= tb.getStartingPoint() + " - " + tb.getEndingPoint() %></td>
            </tr>
        </table>
        <%
            } else {
        %>
        <p>No truck details found.</p>
        <%
            }
        %>
        <a href="FindTruck.jsp">Search new truck</a>
    </div>
    
</body>
</html>
