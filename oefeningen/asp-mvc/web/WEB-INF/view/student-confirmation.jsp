<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>Student Confirmatie</title>
</head>

<body>

De student is bevestigd: ${student.firstName} ${student.lastName}

<br><br>

Land: ${student.country}

<br><br>

Favoriete Taal: ${student.favoriteLanguage}

<br><br>

Operating Systems:

<ul>
	<c:forEach var="temp" items="${student.operatingSystems}">

		<li> ${temp} </li>

	</c:forEach>
</ul>

</body>

</html>







