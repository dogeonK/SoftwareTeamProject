<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="layout/header.jsp" %>
<link rel="stylesheet" href="https://demo.sir.kr/gnuboard5/theme/basic/css/default.css?ver=220620">
<link rel="stylesheet" href="https://demo.sir.kr/gnuboard5/js/font-awesome/css/font-awesome.min.css?ver=220620">
<link rel="stylesheet" href="https://demo.sir.kr/gnuboard5/theme/basic/skin/connect/basic/style.css?ver=220620">
<link rel="stylesheet" href="https://demo.sir.kr/gnuboard5/theme/basic/skin/popular/basic/style.css?ver=220620">
<link rel="stylesheet" href="https://demo.sir.kr/gnuboard5/theme/basic/skin/latest/pic_list/style.css?ver=220620">
<link rel="stylesheet" href="https://demo.sir.kr/gnuboard5/theme/basic/skin/latest/pic_block/style.css?ver=220620">
<link rel="stylesheet" href="https://demo.sir.kr/gnuboard5/theme/basic/skin/latest/basic/style.css?ver=220620">
<link rel="stylesheet" href="https://demo.sir.kr/gnuboard5/theme/basic/skin/outlogin/basic/style.css?ver=220620">
<link rel="stylesheet" href="https://demo.sir.kr/gnuboard5/theme/basic/skin/poll/basic/style.css?ver=220620">
<link rel="stylesheet" href="https://demo.sir.kr/gnuboard5/theme/basic/skin/latest/notice/style.css?ver=220620">
<link rel="stylesheet" href="https://demo.sir.kr/gnuboard5/theme/basic/skin/visit/basic/style.css?ver=220620">
<link rel="stylesheet" href="https://demo.sir.kr/gnuboard5/js/owlcarousel/owl.carousel.min.css?ver=220620">

<div class="container">
    <div class="lat">
        <c:forEach var="board" items="${boards.content}">
            <div class="card m-2">
                <div class="card-body">
                    <h4 style="font-size: 20px" class="card-title">${board.title}</h4>
                    <p>${board.content}</p>
                    <a href="/board/${board.id}" class="lt_more"><span class="sound_only">질문답변</span>더보기</a>
                </div>
            </div>
        </c:forEach>
    </div>

    <ul class="pagination justify-content-center">
        <c:choose>
            <c:when test="${boards.first}">
                <li class="page-item disabled"><a class="page-link" href="?page=${boards.number-1}">Previous</a></li>
            </c:when>
            <c:otherwise>
                <li class="page-item"><a class="page-link" href="?page=${boards.number-1}">Previous</a></li>
            </c:otherwise>
        </c:choose>

        <c:choose>
            <c:when test="${boards.last}">
                <li class="page-item disabled"><a class="page-link" href="?page=${boards.number+1}">Next</a></li>
            </c:when>
            <c:otherwise>
                <li class="page-item"><a class="page-link" href="?page=${boards.number+1}">Next</a></li>
            </c:otherwise>
        </c:choose>

    </ul>


</div>

<%@ include file="layout/footer.jsp" %>


