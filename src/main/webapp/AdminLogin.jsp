<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="errorPage.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Logged In Successfully</title>
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
    .form-container {
        background-color: rgba(51, 51, 51, 0.8);
        padding: 30px;
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
        width: 350px;
        text-align: center;
    }
    h1 {
        margin-bottom: 20px;
        color: #ffa500;
    }
    label, select, input[type="text"], input[type="submit"], a {
        display: block;
        width: 100%;
        padding: 10px;
        margin: 10px 0;
        border-radius: 5px;
    }
    select, input[type="text"] {
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
    .a {
        background-color: #ffa500;
        color: #1a1a1a;
        text-align: center;
        text-decoration: none;
    }
    a:hover {
        background-color: #ff8c00;
    }
</style>
</head>
<body>
<div class="form-container">
    <form action="findingManager" method="get">
        <h1>Admin Logged In Successfully</h1>
        <label for="branch">Branch:</label>
        <select id="branch" name="branch">
            <option value="Hyderabad">Hyderabad</option>
            <option value="Nagpur">Nagpur</option>
            <option value="Mumbai">Mumbai</option>
			<option value="Pune">Pune</option>
        </select>
        <label for="managerName">Find Manager</label>
        <input type="text" id="managerName" name="managerName">
        <input type="submit" value="Submit">
        <a href="CreateNewManager.jsp" class="a">Create New Manager</a>
        <a href="TruckDetails.jsp" class="a">Install New Truck</a>
        <a href="FindTruck.jsp" class="a">Search Truck</a>
    </form>
</div>
</body>
</html>
