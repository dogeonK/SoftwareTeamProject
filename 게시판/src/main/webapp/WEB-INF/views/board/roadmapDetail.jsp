<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="../layout/header.jsp" %>

<link rel="stylesheet" href="https://demo.sir.kr/gnuboard5/theme/basic/css/default.css?ver=220620">
<link rel="stylesheet" href="https://demo.sir.kr/gnuboard5/js/font-awesome/css/font-awesome.min.css?ver=220620">
<link rel="stylesheet" href="https://demo.sir.kr/gnuboard5/theme/basic/skin/connect/basic/style.css?ver=220620">
<link rel="stylesheet" href="https://demo.sir.kr/gnuboard5/theme/basic/skin/popular/basic/style.css?ver=220620">
<link rel="stylesheet" href="https://demo.sir.kr/gnuboard5/skin/member/basic/style.css?ver=220620">
<link rel="stylesheet" href="https://demo.sir.kr/gnuboard5/theme/basic/skin/outlogin/basic/style.css?ver=220620">
<link rel="stylesheet" href="https://demo.sir.kr/gnuboard5/theme/basic/skin/poll/basic/style.css?ver=220620">
<link rel="stylesheet" href="https://demo.sir.kr/gnuboard5/theme/basic/skin/latest/notice/style.css?ver=220620">
<link rel="stylesheet" href="https://demo.sir.kr/gnuboard5/theme/basic/skin/visit/basic/style.css?ver=220620">
<link rel="stylesheet" href="https://demo.sir.kr/gnuboard5/js/owlcarousel/owl.carousel.min.css?ver=220620">
<link rel="stylesheet" href="https://demo.sir.kr/gnuboard5/skin/social/style.css?ver=220620">
<!--[if lte IE 8]>
<script src="https://demo.sir.kr/gnuboard5/js/html5.js"></script>
<![endif]-->
<script>
    // 자바스크립트에서 사용하는 전역변수 선언
    var g5_url = "https://demo.sir.kr/gnuboard5";
    var g5_bbs_url = "https://demo.sir.kr/gnuboard5/bbs";
    var g5_is_member = "";
    var g5_is_admin = "";
    var g5_is_mobile = "";
    var g5_bo_table = "";
    var g5_sca = "";
    var g5_editor = "";
    var g5_cookie_domain = "";
    var g5_theme_shop_url = "https://demo.sir.kr/gnuboard5/theme/basic/shop";
    var g5_shop_url = "https://demo.sir.kr/gnuboard5/shop";
</script>
<script src="https://demo.sir.kr/gnuboard5/js/jquery-1.12.4.min.js?ver=221017"></script>
<script src="https://demo.sir.kr/gnuboard5/js/jquery-migrate-1.4.1.min.js?ver=221017"></script>
<script src="https://demo.sir.kr/gnuboard5/js/jquery.menu.js?ver=221017"></script>
<script src="https://demo.sir.kr/gnuboard5/js/common.js?ver=221017"></script>
<script src="https://demo.sir.kr/gnuboard5/js/wrest.js?ver=221017"></script>
<script src="https://demo.sir.kr/gnuboard5/js/placeholders.min.js?ver=221017"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js" async></script>
<script src="https://demo.sir.kr/gnuboard5/js/jquery.register_form.js?ver=221017"></script>
<script src="https://demo.sir.kr/gnuboard5/js/certify.js?v=221017"></script>
<script src="https://demo.sir.kr/gnuboard5/js/owlcarousel/owl.carousel.min.js?ver=221017"></script>
<script src="https://demo.sir.kr/gnuboard5/js/jquery.bxslider.js?ver=221017"></script>

<!-- 콘텐츠 시작 { -->
<div id="wrapper">
    <div id="container_wr">

        <div id="container">
            <h2 id="container_title"><span title="회원 가입">로드맵 확인하기</span></h2>
            <!-- 회원정보 입력/수정 시작 { -->

            <div class="register">
                <div class="tbl_frm01 tbl_wrap register_form_inner" align="center">
                    <h2>개인정보 입력</h2>
                    <iframe height="500" height="200" src="https://github-readme-stats.vercel.app/api?username=${gitName}&show_icons=true"></iframe>
                    <iframe height="500" height="200" src="https://github-readme-stats.vercel.app/api/top-langs/?username=${gitName}&langs_count=8"></iframe>
                </div>
            </div>
            <div class="btn_confirm">
                <a href="http://localhost:8080/" class="btn_close">취소</a>
                <button type="submit" id="btn_submit" class="btn_submit">로드맵 확인하기</button>
            </div>

        </div>

    </div>
    <!-- } 콘텐츠 끝 -->

    <hr>

    <%@ include file="../layout/footer.jsp" %>
