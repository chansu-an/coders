<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<script type="text/javascript">
var test = true
function testttt() {
	
	alert(test);
	if(test){
		document.getElementById('test1').className = 'navbar-collapse collapse show';
		 test = false;
	}else{
		document.getElementById('test1').className = 'navbar-collapse collapse';
		 test = true;
		
	}
	
};
</script>
<head>
<%@ include file="/WEB-INF/include/include-header.jspf" %>
</head>
<body>
<div class="d-flex" id="wrapper">
            <!-- Sidebar-->
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
    <c:choose>
    	<c:when test="${map.IDENTI_TYPE == '1' }">
			<h2>공지사항</h2>   	
    	</c:when>
    	<c:when test="${map.IDENTI_TYPE == '2' }">
			<h2>QnA</h2>   	
    	</c:when>
    	<c:when test="${map.IDENTI_TYPE == '3' }">
			<h2>자유게시판</h2>   	
    	</c:when>
    </c:choose>
	<table class="board_list">
		<colgroup>
			<col width="100px" />
			<col width="100px" />
			<col width="100px" />
			<col width="100px" />
			<col width="100px" />
			<col width="100px" />
			<col width="100px" />
			<col width="100px" />
		</colgroup>
		<thead>
			<tr>
				<th scope="col">글번호</th>
				<th scope="col">제목</th>
				<th scope="col">작성자</th>
				<th scope="col">내용</th>
				<th scope="col">작성일</th>
				<th scope="col">조회수</th>
				<th scope="col">추천수</th>
				<th scope="col">신고수</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${!empty map}">
					<tr>
						<td>${map.BOARD_NO }</td>
 						<td>${map.TITLE }</td>
						<td>${map.NICK_NAME }</td>
						<td>${map.CONTEXT }</td>
						<td>${map.BOARD_DATE }</td>
						<td>${map.READ_COUNT }</td>
						<td>${map.RECOMMEND_COUNT }</td>
						<td>${map.REPORT_COUNT }</td>
					</tr>
				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="4">조회된 결과가 없습니다.</td>
					</tr>
				</c:otherwise>
			</c:choose>
			

		</tbody>
	</table>
	<!-- 작성자만 가능 -->
	<a href="/net/board/modify.do?BOARD_NO=${map.BOARD_NO }" class="btn" id="write">수정하기</a>
	<a href="/net/board/delete.do?BOARD_NO=${map.BOARD_NO }" class="btn" id="delete">삭제하기</a>
	<a href="/net/board/openBoardList.do" class="btn" id="boardList">목록보기</a>
	
	<!-- 스크랩하기 -->
	
	
	<!-- 신고, 추천 -->
	<!-- 신고하기 누르면 REPORT_COUNT + 1, 추천하기 누르면 RECOMMEND_COUNT + 1 -->
	<div>
	<a href="/net/board/recommend.do?BOARD_NO=${map.BOARD_NO }" class="btn" id="recommend">추천하기</a>
	<a href="/net/board/report.do?BOARD_NO=${map.BOARD_NO }" class="btn" id="report">신고하기</a>	
	</div>
	
	<!-- 댓글 리스트 -->
	<div id="reply">
	  <div>댓글 <c:out value="${count.COUNT }"></c:out></div>
	  <c:if test="${bestcomment.RECOMMAND_COUNT != '0' }">
	  <div>
	  	<p>
			작성자 : ${bestcomment.NICK_NAME}<br />
			작성 날짜 : ${bestcomment.REPLY_DATE } 
		</p>			
		<p>${bestcomment.CONTEXT}               		
			<a href="/net/board/commentDelete.do?RE_NO=${bestcomment.RE_NO }&BOARD_NO=${map.BOARD_NO}" class="btn">삭제</a>	
		</p>
	  </div>
	  </c:if>
	  <ol class="replyList">
	    <c:forEach items="${list}" var="row">
	    	<c:choose>
	    	
	    		<c:when test="${row.REF_STEP == '0' }">
	    		<div onclick="testttt()">
			        <p>
			        작성자 : ${row.NICK_NAME} / ${row.REF_STEP }<br />
			        작성 날짜 : ${row.REPLY_DATE } 
			        </p>			
			        <p>${row.CONTEXT}               		
			        	<a href="/net/board/commentDelete.do?RE_NO=${row.RE_NO }&BOARD_NO=${map.BOARD_NO}" class="btn">삭제</a>	
			        </p>
			    </div>
			    <div id="test1" class="navbar-collapse collapse " >
			    테스트
			    </div>		        
		        </c:when>
	    		<c:when test="${row.REF_STEP == '1' }">
	    		<div>
			        <p>
			        작성자 : ${row.NICK_NAME} / ${row.REF_STEP }<br />
			        작성 날짜 : ${row.REPLY_DATE } 
			        </p>			
			        <img src="../img/arrow.png" width="30" height="30"/>${row.CONTEXT}
			    </div>			        
		        </c:when>
	    		<c:when test="${row.REF_STEP == '2' }">
	    		<div >
			        <p>
			        작성자 : ${row.NICK_NAME} / ${row.REF_STEP }<br />
			        작성 날짜 : ${row.REPLY_DATE } 
			        </p>			
			        <img src="../img/arrow.png" width="30" height="30"/>${row.CONTEXT}	
			    </div>	        
		        </c:when>
	    		<c:when test="${row.REF_STEP == '3' }">
	    		<div>
			        <p>
			        작성자 : ${row.NICK_NAME} / ${row.REF_STEP }<br />
			        작성 날짜 : ${row.REPLY_DATE } 
			        </p>			
			        <img src="../img/arrow.png" width="30" height="30"/>${row.CONTEXT}
			    </div>		        
		        </c:when>
	        </c:choose>
	    </c:forEach>   
	  </ol>
	</div>
	<div class="container">
        <label for="content">댓글 작성</label>
        <form action="/net/board/commentInsert.do" method="post">
            <div class="input-group">
               <input type="hidden" name="BOARD_NO" value="${map.BOARD_NO}"/>
               <input type="hidden" name="USER_NO" value="${session.USER_NO}"/>
               <input type="text" id="CONTEXT" name="CONTEXT" placeholder="내용을 입력하세요." style="width:60%;;font-size:15px;"/>
               <span class="input-group-btn">
                    <button class="btn btn-default" name="commentInsertBtn">등록</button>
               </span>
            </div>
        </form>
    </div>
	</div>
</div>

	<br />
	
	<%@ include file="/WEB-INF/include/include-body.jspf" %>
<script>
	
</script>

</body>
</html>