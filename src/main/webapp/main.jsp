<%@page import="java.awt.List"%>
<%@page import="kr.or.connect.todo.dto.TodoDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/style.css">
<title>Insert title here</title>
</head>
<body>
	<header>
		<span>나의 해야 할 일들</span>
		<a class="register" href="http://localhost:8000/form">새로운 TODO 등록</a> <%-- 서블릿 요청 --%>
	</header>
	<section>
		<article class="float">
			<p class="type">TODO</p>
			<ol id="todo">
				<c:forEach items="${requestScope.list }" var="item" begin="0"> <%--EL표기법으로 request의 속성 값을 얻어냈음 /각 type에 따라 요소를 생성할 수 있게 하는 코드 --%>
					<c:if test="${item.type == 'TODO' }"> <%-- EL코드의 문자열 표현은 ' '로 나타냄 --%>
						<li class="list">
							<p>${item.title }</p>
							<span>등록날짜:${item.regDate }, ${item.name }, 우선순위${item.sequence }</span>
							<button class="next_btn">→</button>
							<span class="display_non">${item.id }</span>								
						</li>
					</c:if>
				</c:forEach>
			</ol>
		</article>			
		<article class="float">
			<p class="type">DOING</p>
			<ol id="doing">
				<c:forEach items="${requestScope.list }" var="item" begin="0">
					<c:if test="${item.type == 'DOING' }">
						<li class="list">
							<p>${item.title }</p>
							<span>등록날짜:${item.regDate }, ${item.name }, 우선순위${item.sequence }</span>
							<button class="next_btn">→</button>
							<span class="display_non">${item.id }</span>						
						</li>
					</c:if>
				</c:forEach>
			</ol>
		</article>		
		<article class="float">
			<p class="type">DONE</p>
			<ol id="done">
				<c:forEach items="${requestScope.list }" var="item" begin="0">
					<c:if test="${item.type == 'DONE' }">
						<li class="list">
							<p>${item.title }</p>
							<span>등록날짜:${item.regDate }, ${item.name }, 우선순위${item.sequence }</span>
						</li>
					</c:if>
				</c:forEach>
			</ol>
		</article>
	</section> 
	<script src="js/script.js"></script>
</body>
</html>