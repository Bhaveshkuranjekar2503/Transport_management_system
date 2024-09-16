<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="errorPage.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Installing New Truck Details Form</title>
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
    h1, h2 {
        margin-bottom: 20px;
        color: #ffa500;
    }
    label, select, input[type="text"], input[type="number"], input[type="date"], input[type="submit"], .radio-container {
        display: block;
        width: 100%;
        padding: 10px;
        margin: 10px 0;
        border-radius: 5px;
    }
    .radio-container {
        display: flex;
        justify-content: space-around;
        align-items: center;
        padding: 0;
        margin: 0;
    }
    .radio-container label {
        margin: 0 10px;
        padding: 10px 0;
        flex: 1;
        display: flex;
        align-items: center;
    }
    .radio-container input[type="radio"] {
        margin: 0 5px 0 0;
    }
    select, input[type="text"], input[type="number"], input[type="date"] {
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
        margin-bottom: 20px;
    }
    a:hover {
        color: #ff8c00;
    }
</style>
</head>
<body>
<h1>MOST CONVENIENT & RELIABLE TRANSPORT SERVICES</h1>
<a href="#">Click here for details</a>
<div class="form-container">
    <form action="truckDetailsServlet" method="post">
        <h2>WELCOME TO OUR TRUCK TRACKING COMPANY</h2>
        <label for="truckmodel">Truck Model:</label>
        <input type="text" id="truckmodel" name="truckmodel">
        
        <label for="truckNumber">Truck No.:</label>
        <input type="text" id="truckNumber" name="truckNumber">
        
        <label>Insurance:</label>
        <div class="radio-container">
            <label for="yes"><input type="radio" id="yes" name="choice" value="yes"> Yes</label>
            <label for="no"><input type="radio" id="no" name="choice" value="no"> No</label>
        </div>
        
        <label for="insuranceCompany">If yes, then insurance company name:</label>
        <input type="text" id="insuranceCompany" name="insuranceCompany">
        
        <label for="ownerName">Owner Name:</label>
        <input type="text" id="ownerName" name="ownerName">
        
        <label for="mno">Mobile No.:</label>
        <input type="number" id="mno" name="mno">
        
        <label for="branch1">Route-from:</label>
        <select id="branch1" name="branch1">
            <option value="Hyderabad">Hyderabad</option>
            <option value="Nagpur">Nagpur</option>
            <option value="Mumbai">Mumbai</option>
            <option value="Pune">Pune</option>
        </select>
        
        <label for="branch2">To:</label>
        <select id="branch2" name="branch2">
            <option value="Hyderabad">Hyderabad</option>
            <option value="Nagpur">Nagpur</option>
            <option value="Mumbai">Mumbai</option>
            <option value="Pune">Pune</option>
        </select>
        
        <label for="joiningDate">Joining Date:</label>
        <input type="date" id="joiningDate" name="joiningDate">
        
        <input type="submit" value="Create">
    </form>
</div>
</body>
</html>
