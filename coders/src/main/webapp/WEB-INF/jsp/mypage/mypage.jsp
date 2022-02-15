<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내활동</title>
<%@ include file="/WEB-INF/include/include-header2.jspf"%>
<%@ include file="/WEB-INF/include/incude-mypageheader.jspf"%>
</head>
<body>
<div align="center">
<h2>스크랩 리스트</h2>
	<table class="board_list">
		<colgroup>
			<col width="10%" />
			<col width="*%" />
			<col width="15%" />
			<col width="20%" />
			<col width="20%" />
		</colgroup>	
		<tbody>
			<c:choose>
				<c:when test="${slist != null}">
					<c:forEach items="${slist }" var="row">
						<tr>
							<td><a href="#">${row.TITLE }</a></td>
							<td>새로운 댓글이 달렸습니다</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="4">스크랩한 게시글이 없습니다${CHECK }</td>
					</tr>
				</c:otherwise>
			</c:choose>

		</tbody>
	</table>
	<h2>팔로우 리스트</h2>
	<table class="board_list">
		<colgroup>
			<col width="10%" />
			<col width="*%" />
			<col width="15%" />
			<col width="20%" />
			<col width="20%" />
		</colgroup>
		<tbody>
			<c:choose>
				<c:when test="${length(flist) != null}">
					<c:forEach items="${flist }" var="row">
						<tr>
							<td><a href="../main/Mypage.do?USER_NO=${row.FOLLOWER}">${row.NICK_NAME}</a></td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="4">팔로우한 유저가 없습니다</td>
					</tr>
				</c:otherwise>
			</c:choose>
			</tbody>
		</table>
	</div>
<%@ include file="/WEB-INF/include/incude-menufooter.jspf"%>
</body>
</html>