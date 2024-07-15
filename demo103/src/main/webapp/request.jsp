<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>First JSP</title>
</head>
<%@ page import="java.util.Date" %>
<body>
<h2>Add Employee details</h2>
<form action="/addEmployee">
    Name:<input type="text" name="name"> <br>
    ID:<input type="text" name="empId"> <br>
    <input type="submit">
</form>
<h2>Delete Employee details</h2>
<form action="/deleteEmployee">
   ID:<input type="text" name="empId"> <br>
    <input type="submit">
</form>
<h2>Update Employee details</h2>
<form action="/updateEmployee">
    Name:<input type="text" name="name"> <br>
   ID:<input type="text" name="empId"> <br>
    <input type="submit">
</form>
</body>
</html>
