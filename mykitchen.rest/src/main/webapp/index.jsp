<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    	               "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Form to create a new resource</title>
</head>
<body>
	<form action="../mykitchen.rest/rest/recipes" method="POST">
		<label for="id">ID</label> <input name="id" /> <br /> <label
			for="summary">Summary</label> <input name="summary" /> <br />
		Description:
		<TEXTAREA NAME="description" COLS=40 ROWS=6></TEXTAREA>
		<br /> <input type="submit" value="Submit" />
	</form>
</body>
</html>
