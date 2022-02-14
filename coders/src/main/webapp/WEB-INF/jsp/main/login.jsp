<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/include/include-header.jspf"%>
<%@ include file="/WEB-INF/include/incude-menuheader.jspf"%>

<!-- Page content-->
<div class="container-fluid">
	<form method="post">
		<div align="center">
			<a>아이디 : </a> <input type="text" name="EMAIL" id="EMAIL" size="30"
				placeholder="아이디" required autofocus><br />
			<a>비밀번호 : </a> <input type="password" name="PASSWORD" id="PASSWORD"
				size="30" placeholder="암호" required autofocus>
			<br /> <input type="submit" value="로그인" />
		</div>
	</form>
	<a href="/net/main/RegisterForm.do">회원가입</a> <br /> <a
		href="/net/main/FindId.do">아이디 찾기</a> <br /> <a
		href="/net/main/FindPw.do">비밀번호 찾기</a> <br /> <a
		href="/net/main/UserList.do">회원 리스트</a> <br /> <a
		href="/net/main/StopUserList.do">신고회원 리스트</a> <br /> <a
		href="/net/main/DeleteUserList.do">탈퇴회원 리스트</a> <br />
</div>
<%@ include file="/WEB-INF/include/incude-menufooter.jspf"%>
</body>
</html>