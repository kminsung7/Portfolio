<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header>
		<h1>할일 등록</h1>
	</header>
	
	<section>	
		<form action="http://localhost:8000/add" accept-charset="UTF-8" method="POST"> <%--accept-charset 속성은 인코딩에 꼭 필요--%>
			<article>
				<span>어떤 일인가요?</span>
				<input type="text" name="todo" placeholder="할 일을 입력하세요(24자 까지)" required="required"><%--submit시에 name의 값이 파라미터로 전달됨 --%>
			</article>
			<article>
				<span>누가 할 일인가요?</span>
				<input type="text" name="name" placeholder="이름을 적어주세요" required="required">
			</article>
			<article>
				<span>우선순위를 선택하세요</span>
				<input type="radio" name="sequence" value="1" id="first" required="required"> <label for="first">1순위</label><%--submit시에 value값이 값으로 전달됨 --%>
				<input type="radio" name="sequence" value="2" id="second" required="required"> <label for="second">2순위</label>
				<input type="radio" name="sequence" value="3" id="third" required="required"> <label for="third">3순위</label>
			</article>
			<article>
				<a href="http://localhost:8000/main">&lt;이전</a>
				<input type="submit" value="제출">
				<input type="reset" value="내용 지우기">
			</article>
		</form>
	</section>
</body>
</html>