<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:url value="/searchuser.htm" var="userTweetsUrl">
	<c:param name="user" value="${user.screenName}" />
</c:url>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>
		View user
		<c:out value="${user.screenName}" />
	</h1>
	<img src="${user.profileImageUrl}" />
	<p>
		Name:
		<c:out value="${user.name}" />
	</p>
	<p>
		Description:
		<c:out value="${user.description}" />
	</p>

	<p>
		Followers:
		<c:out value="${user.followersCount}" />
	</p>
	<p>
		Following:
		<c:out value="${user.friendsCount }" />
	</p>
	<p>
		Tweets:
		<a href="${userTweetsUrl}"><c:out value="${user.statusesCount}" /></a>
	</p>

</body>
</html>