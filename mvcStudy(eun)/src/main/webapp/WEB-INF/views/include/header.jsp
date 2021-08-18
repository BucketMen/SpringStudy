<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body>
	<div id="container">
		<header id="mainheader">
			<nav id="navbar">
				<!-- 로고(로고이미지, 홈페이지 이름) -->
				<!-- 메뉴(자기소개, 게시글) -->
				<!-- 링크(로그인, 회원가입) -->
				<a href="/index" id="mainlogo"><i id="logo" class="fab fa-adn"></i>
					Junil blog</a>
				<ul>
					<a href="#"><li>블로그소개</li></a>
					<a href="/border"><li>게시글</li></a>
				</ul>
				<c:choose>
					<c:when test="${empty loginUserBean } }">
					<!--test="(empty는)유저빈이 비어있을때 "test는 조건을 작성, else-if를 사용하고자 할때 when-otherwise를 사용한다.  -->
						<div>
							<a href="/login" class="__links">로그인</a> 
							<a href="/join"class="__links">회원가입</a>
						</div>
					</c:when>
					<c:otherwise>
					<!-- 비어있지 않으면 로그인 되었다는 의미 -->
						<div>
							<span>${loginUserBean.user_name }</span> 
							<a href="/logout"class="__links">로그아웃</a>
						</div>
					</c:otherwise>
				</c:choose>
			</nav>
		</header>
<!-- 헤더 로그아웃과 로그인을 합친다. -->