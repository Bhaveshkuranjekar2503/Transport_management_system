<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="transportation.management.system.TruckBean"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="jakarta.servlet.http.HttpSession"%>
<%@ include file="TruckRoot.html"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Showing Truck Route Tables</title>
<style>
body {
	font-family: 'Arial', sans-serif;
	background-image:
		url('https://images.pexels.com/photos/93398/pexels-photo-93398.jpeg?auto=compress&cs=tinysrgb&fit=crop&h=1080&w=1920');
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
	color: #333;
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
	color: #007BFF;
	text-decoration: none;
	font-weight: bold;
}

.back-link a:hover {
	text-decoration: underline;
}
</style>
</head>
<body>
	<%
	ArrayList<TruckBean> al = (ArrayList<TruckBean>)session.getAttribute("al");
	%>
	<div class="container">
		<h1>Showing Truck Route Tables</h1>
		<table>
			<tr>
				<th>MODEL</th>
				<th>TRUCK NO.</th>
				<th>OWNER</th>
				<th>MOBILE</th>
				<th>INSURANCE</th>
			</tr>
			<%
			if (al != null && !al.isEmpty()) {
				for (TruckBean tb : al) {
			%>
			<tr>
				<td><%=tb.getTruckModel()%></td>
				<td><%=tb.getTruckNumber()%></td>
				<td><%=tb.getOwnerName()%></td>
				<td><%=tb.getMobileNo()%></td>
				<td><%=tb.getInsurance()%></td>
			</tr>
			<%
			}
			} else {
			%>
			<tr>
				<td colspan="5">No trucks found for the selected route.</td>
			</tr>
			<%
			}
			%>
		</table>
		<div class="back-link">
			<%
			if (al != null) {
			%>
			<a href="Details.html">Go to Manager Functionalities</a>
			<%
			} else {
			%>
			<a href="Index.html">Go to Home Page</a>
			<%
			}
			%>
		</div>
	</div>
</body>
</html>
