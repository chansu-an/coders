<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/include/include-header.jspf"%>
</head>
<body>
	<form id="frm">
		<table class="board_view">
			<colgroup>
				<col width="15%">
				<col width="*" />
			</colgroup>
			<caption>게시글 작성</caption>
			<tbody>
				<tr>
					<th scope="row">제목</th>
					<td>${map.PROJECT_NAME }</td>
				</tr>
				<tr>
					<td colspan="2" class="view_text">${map.PROJECT_CONTEXT }</td>
							
				</tr>
			</tbody>
		</table>
		<a href="#this" class="btn" id="write">작성하기</a> <a href="/net/Project.do"
			class="btn" id="list">목록으로</a>
	</form>
	<%@ include file="/WEB-INF/include/include-body.jspf"%>
	<script type="text/javascript">
		$(document).ready(function() {
		});
	</script>
</body>
</html>

