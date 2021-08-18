<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Junil blog</title>
    <script src="https://kit.fontawesome.com/c3df4d7d1c.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.css" />
    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css" />
    <link rel="stylesheet" href="/css/style.css" />
</head>
<body>
    <div id="container">
    	
    	<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
    	<%-- <c:choose>
    		<c:when test="${empty loginUserBean }">
    			<jsp:include page="/WEB-INF/views/include/header_login.jsp"></jsp:include>
    		</c:when>
    		<c:otherwise>
    			<jsp:include page="/WEB-INF/views/include/header_logout.jsp"></jsp:include>
    		</c:otherwise>
    	</c:choose> 
    	를 <jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>로 대체 
    	--%>
    	
        <main>
            <article id="mainimage">
                <div id="swiper-container__id" class="swiper-container">
			        <div class="swiper-wrapper">
			            <div class="swiper-slide"><img src="images/s1.png" width="100%"></div>
			            <div class="swiper-slide"><img src="images/s2.png" width="100%"></div>
			            <div class="swiper-slide"><img src="images/s3.png" width="100%"></div>
			        </div>
			
			        <div class="swiper-pagination"></div>
			        <div class="swiper-button-prev"></div>
			        <div class="swiper-button-next"></div>
			    </div>
            </article>
            <article id="mainboard">
                <!-- <section id="imgsection" class="mainsection">
                    이미지
                    <img src="images/section1.jpg" width="100%">
                </section>
                <section id="boardsection" class="mainsection">
                    최근 게시글 미리보기 리스트
                    <table>
                        <tr>
                            <th>최근 게시글</th>
                        </tr>
                        <tr>
                            <td><a href="#">css 기초 다지기1</a></td>
                        </tr>
                        <tr>
                            <td><a href="#">css 기초 다지기2</a></td>
                        </tr>
                        <tr>
                            <td><a href="#">css 기초 다지기3</a></td>
                        </tr>
                        <tr>
                            <td><a href="#">css 기초 다지기4</a></td>
                        </tr>
                        <tr>
                            <td><a href="#">css 기초 다지기5</a></td>
                        </tr>
                        <tr>
                            <td><a href="#">css 기초 다지기6</a></td>
                        </tr>
                        <tr>
                            <td><a href="#">css 기초 다지기7</a></td>
                        </tr>
                        <tr>
                            <td><a href="#">css 기초 다지기8</a></td>
                        </tr>
                    </table>
                </section> -->
            </article>
            
        </main>
        
        <jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
        
        </div>
    <script src="https://unpkg.com/swiper/swiper-bundle.js"></script>
    <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
    <script src="js/swiper.js"></script>
    <script src="js/borderInsert.js"></script>
</body>
</html>
        