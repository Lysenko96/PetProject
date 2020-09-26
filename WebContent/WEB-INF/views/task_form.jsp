<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New/Edit Task</title>
</head>
<body>
	<div align="center">
		<h1>New/Edit Task</h1>
		<form:form action="save" method="post" modelAttribute="task">
			<table cellpadding="5">
			<!-- below you can check real task id in db where value=id -->
			<form:hidden path="id"/>
				<tr>
					<td>Title:</td>
					<td><form:input path="title" /></td>
				</tr>

				<tr>
					<td>Content:</td>
					<td><form:textarea rows="10" cols="45" path="content" /></td>
				</tr>

				<tr>
					<td>Date:</td>
					<td><form:input type="date" path="date" /></td>
				</tr>
				<tr>
					<td>Time:</td>
					<td><form:input type="time" step="2" path="time" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Save"></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>