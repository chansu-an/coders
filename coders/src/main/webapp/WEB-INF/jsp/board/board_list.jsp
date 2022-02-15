<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/include/include-header.jspf" %>
</head>
<script>
	function test(f){
		f.action="/net/board/openBoardList.do"
		f.submit();
	}
</script>
<body>
<div class="d-flex" id="wrapper">
            <!-- Sidebar-->
            <c:choose>
				<c:when test="${sessionScope.session.ADMIN == 'Y'}">
	            	<div class="border-end bg-white" id="sidebar-wrapper">
		                <div class="sidebar-heading border-bottom bg-light">Coders</div>
		                <div class="list-group list-group-flush">
		                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">공지사항</a>
		                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">QnA 게시판</a>
		                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">자유게시판</a>
		                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">프로젝트</a>
		                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">건의사항</a>		                    
		                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">신고관리</a>
		                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">회원관리</a>
		                </div>
            		</div>
	            </c:when>
	            <c:otherwise>
	            	<div class="border-end bg-white" id="sidebar-wrapper">
		                <div class="sidebar-heading border-bottom bg-light">Coders</div>
		                <div class="list-group list-group-flush">
		                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">공지사항</a>
		                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">QnA 게시판</a>
		                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">자유게시판</a>
		                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">프로젝트</a>
		                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">건의사항</a>
		                </div>
            		</div>
	            </c:otherwise>
            </c:choose>
            <!-- Page content wrapper-->
            <div id="page-content-wrapper">
                <!-- Top navigation-->
                <nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
                    <div class="container-fluid">
                        <button class="btn btn-primary" id="sidebarToggle">Toggle Menu</button>
                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="navbar-nav ms-auto mt-2 mt-lg-0">
                                <li class="nav-item active"><a class="nav-link"><c:out value="${session.NICK_NAME}"/>님 환영합니다</a></li>
                                <li class="nav-item"><a class="nav-link" href="#!">Link</a></li>
                                <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Dropdown</a>
                                    <div class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                                        <a class="dropdown-item" href="#!">Action</a>
                                        <a class="dropdown-item" href="#!">Another action</a>
                                        <div class="dropdown-divider"></div>
                                        <a class="dropdown-item" href="#!">Something else here</a>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>
                <!-- Page content-->
<<<<<<< HEAD
	<h2>게시판 목록</h2>
	<form name="ORDER_TYPE" method="post">
	<p style="text-align:right;">
		<select onchange="test(this.form);" id="ORDER_TYPE" name="ORDER_TYPE">
			<option></option>
			<option value="DATE">최신순</option>
			<option value="REPLY">댓글순</option>
			<option value="READ">조회수</option>
			<option value="RECOMMEND">추천순</option>
		</select>
		<input type="hidden" name="ORDER_TYPE" value="${ORDER_TYPE }"/>
	</p>
	</form>
=======
	<c:choose>
    	<c:when test="${IDENTI_TYPE eq '1' }">
			<h2>공지사항</h2>   	
    	</c:when>
    	<c:when test="${IDENTI_TYPE eq '2' }">
			<h2>QnA</h2>   	
    	</c:when>
    	<c:when test="${IDENTI_TYPE eq '3' }">
			<h2>자유게시판</h2>   	
    	</c:when>
    </c:choose>  
>>>>>>> db488c60dac7d209eb40ad69e31df6fcda34a461
	<table class="board_list">
		<colgroup>
			<col width="10%" />
			<col width="*%" />
			<col width="10%" />
			<col width="10%" />
			<col width="20%" />
			<col width="20%" />
		</colgroup>
		<thead>
			<tr>
				<th scope="col">글번호</th>
				<th scope="col">제목</th>
				<th scope="col">조회수</th>
				<!-- <th scope="col">댓글수</th> -->
				<th scope="col">작성자</th>
				<th scope="col">작성일</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${fn:length(list) > 0}">
					<c:forEach items="${list }" var="row">
						<tr>
							<td>${row.ROWNUM }</td>
<<<<<<< HEAD
 							<td><a href="/net/board/detail.do?BOARD_NO=${row.BOARD_NO}">${row.TITLE }</a> [${row.REPLY_COUNT}]</td>
=======
 							<td><a href="/net/board/detail.do?BOARD_NO=${row.BOARD_NO}&IDENTI_TYPE=${row.IDENTI_TYPE}">${row.TITLE }</a></td>
>>>>>>> db488c60dac7d209eb40ad69e31df6fcda34a461
							<td>${row.READ_COUNT }</td>
							<%-- <td>${row.REPLY_COUNT }</td> --%>
							<td>${row.NICK_NAME }</td>
							<td>${row.BOARD_DATE }</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="4">조회된 결과가 없습니다.</td>
					</tr>
				</c:otherwise>
			</c:choose>

		</tbody>
	</table>
<<<<<<< HEAD
	<p style="text-align:right;"><a href="/net/board/write.do" class="btn" id="write">글쓰기</a>
=======
	<a href="/net/board/write.do?IDENTI_TYPE=${IDENTI_TYPE }" class="btn" id="write">글쓰기</a>
>>>>>>> db488c60dac7d209eb40ad69e31df6fcda34a461
	</div>
	</div>

	<br />
	
	<%@ include file="/WEB-INF/include/include-body.jspf" %>

</body>
</html>