<!DOCTYPE HTML>
<html xmlns:th="https://www.thymeleaf.org">
<head>
    <title>Check Emails</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<h1>Form</h1>
<form action="#" th:action="@{/checkemail}" th:object="${objEmail}" method="post">
    <p>Insert Email List : <input type="text" th:field="*{emails}" /></p>
    <p><input type="submit" value="Submit" /> <input type="reset" value="Reset" /></p>
</form>
</body>
</html>