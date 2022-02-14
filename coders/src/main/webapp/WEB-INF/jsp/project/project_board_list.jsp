<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>first</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
</head>
<body>
<h2>게시판 목록</h2>
<table style="border:1px solid #ccc">
	<colgroup>
		<col width="10%"/>
		<col width="*"/>
		<col width="15%"/>
		<col width="20%"/>
		<col width="20%"/>
		<col width="20%"/>
	</colgroup>
	<thead>
		<tr>
			<th scope="col">글번호</th>
			<th scope="col">제목</th>
			<th scope="col">조회수</th>
			<th scope="col">작성일</th>
			<th scope="col">글번호</th>
			<th scope="col">글번호</th>
		</tr>
	</thead>
	<tbody>
		<c:choose>
			<c:when test="${fn:length(list) > 0}">
				<c:forEach items="${list }" var="row">
					<tr>
						<td>${row.ROWNUM }</td>
						<td>${row.PROJECT_NAME }</td>
						<td>${row.PROJECT_START }</td>
						<td>${row.PROJECT_END }</td>
						<td>${row.PROJECT_MEMBER }</td>
						<td>${row.PROJECT_ADMIN }</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="4">조회된 결과가 없습니다.</td>
				</tr>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${fn:length(list1) > 0}">
				<c:forEach items="${list1 }" var="row">
					<tr>
						<td>${row.ROWNUM }</td>
						<td>${row.PROJECT_NAME }</td>
						<td>${row.PROJECT_START }</td>
						<td>${row.PROJECT_END }</td>
						<td>${row.PROJECT_MEMBER }</td>
						<td>${row.PROJECT_ADMIN }</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="4">조회된 결과가 없습니다.</td>
				</tr>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${fn:length(list2) > 0}">
				<c:forEach items="${list2 }" var="row">
					<tr>
						<td>${row.ROWNUM }</td>
						<td>${row.PROJECT_NAME }</td>
						<td>${row.PROJECT_START }</td>
						<td>${row.PROJECT_END }</td>
						<td>${row.PROJECT_MEMBER }</td>
						<td>${row.PROJECT_ADMIN }</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="4">조회된 결과가 없습니다.</td>
				</tr>
			</c:otherwise>
		</c:choose>
		<tr>
		<a href="/net/Project/Write.do">글작성</a>
		</tr>
	</tbody>
</table>
</body>
</html>