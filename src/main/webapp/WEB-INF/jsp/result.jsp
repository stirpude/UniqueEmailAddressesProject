<!DOCTYPE HTML>
<html xmlns:th="https://www.thymeleaf.org">
<head>
	<title>Getting Started: Handling Form Submission</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<h1>Result</h1>
<p th:text="'Number of Unique Emails : ' + ${}" />
<p th:text="'content: ' + ${NumOfUniqueEmail.num}" />
<a href="/greeting">Submit another message</a>
</body>
</html>