<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="errorPage.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Truck Finding</title>
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
        flex-direction: column;
    }
    .form-container {
        background-color: rgba(51, 51, 51, 0.8);
        padding: 30px;
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
        width: 400px;
        text-align: center;
        margin-top: 20px;
    }
    h1 {
        margin-bottom: 20px;
        color: #ffa500;
    }
    label, input[type="text"], input[type="submit"] {
        display: block;
        width: 100%;
        padding: 10px;
        margin: 10px 0;
        border-radius: 5px;
    }
    input[type="text"] {
        border: none;
    }
    input[type="submit"] {
        background-color: #ffa500;
        border: none;
        color: #1a1a1a;
        font-weight: bold;
        cursor: pointer;
    }
    input[type="submit"]:hover {
        background-color: #ff8c00;
    }
    a {
        color: #ffa500;
        text-decoration: none;
        font-weight: bold;
        margin: 20px 0;
        display: block;
    }
    a:hover {
        color: #ff8c00;
    }
</style>
</head>
<body>
<div class="form-container">
    <h1>Find Truck</h1>
    <form action="SearchTruck" method="get">
        <label for="truckDetails">Enter Truck Details:</label>
        <input type="text" id="truckDetails" name="truckDetails">
        <input type="submit" value="Submit">
    </form>
    <a href="CreateNewManager.jsp">Create New Manager</a>
    <a href="TruckDetails.jsp">Install New Truck</a>
</div>
</body>
</html>
