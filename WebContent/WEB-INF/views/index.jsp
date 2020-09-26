<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Task Manager</title>
</head>
<body>
	<div align="center">
		<h1>Task List</h1>
		<h3>
			<a href="new">New Task</a>
		</h3>
		<table border="1" cellpadding="5">

			<tr>
				<th>id</th>
				<th>Title</th>
				<th>Content</th>
				<th>Date</th>
				<th>Time</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${listTask}" var="task" varStatus="status">
				<tr>
					<td>${status.index + 1}</td>
					<td>${task.title}</td>
					<td>${task.content}</td>
					<td>${task.date}</td>
					<td>${task.time}</td>
					<td>
						<a href="edit?id=${task.id}">Edit</a>
						&nbsp;&nbsp;
						<a href="delete?id=${task.id}">Delete</a>
					</td>
				</tr>
			</c:forEach>

		</table>
	</div>
</body>
</html>