<%@ page session="false"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<c:forEach items="${tweets }" var="tweet">
			<c:url value="/viewtweet.htm" var="viewTweetUrl">
				<c:param name="id" value="${tweet.id}" />
			</c:url>
			<c:url value="/viewuser.htm" var="viewUserUrl">
				<c:param name="userid" value="${tweet.fromUser}" />
			</c:url>
			
			<li><b><a href="${viewUserUrl}"><c:out value="${tweet.fromUser}" /></a></b> 
			<a href="${viewTweetUrl}"><c:out value="${tweet.text}" /></a></li>

		</c:forEach>
	</ul>
</body>
</html>