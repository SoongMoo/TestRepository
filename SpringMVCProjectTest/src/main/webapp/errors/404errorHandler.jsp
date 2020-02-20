<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>일시적인 장애 : 네이트</title>
<style type="text/css">
/* Common */
html, body, div, span,
h1, h2, h3, h4, h5, h6, p, blockquote,
a,  img,  strong, ol, ul, li,
fieldset, form, label, legend {
    margin:0; padding:0; border:0; font-size:100%; vertical-align:baseline; }
html { overflow:auto; }
body { background:#fff; line-height:1; }
img { border:0; }
li { list-style:none; }

.error_wrap { position:relative; margin:75px auto 0 auto; width:400px; height:390px; background:url('//main2.nateimg.co.kr/img/v6/error_nate.png') no-repeat left top; }
.error_wrap h1, .error_wrap h2 { text-indent:-9999px; }
.error_wrap a { display:block; position:absolute; text-indent:-9999px; overflow:hidden; }
.error_wrap a.cs_center { top:233px; left:84px; width:126px; height:16px; }
.error_wrap p { text-indent:-9999px; }
.error_wrap .btn_prev_page { width:108px; height:27px; left:88px; top:273px; }
.error_wrap .btn_go_home { width:117px; height:27px; left:205px; top:273px; }
.error_wrap .footer { position:absolute; bottom:0; padding:10px 0 0 0; width:400px; height:40px; border-top:1px solid #f4f8fb; text-align:center; font-family:Verdana; font-size:9px; color:#666; }
.error_wrap .footer a { position:relative; text-indent:0; display:inline; color:#F60; text-decoration:none; }
.error_wrap .footer a strong { color:#F60; font-family:Verdana; font-size:10px; font-weight:bold; }
.error_wrap .footer a strong span { color:#FF2400; font-family:Verdana; font-size:10px; }
</style>
</head>

<body>

<div class="error_wrap">
	<h1>NATE</h1>
	<h2>이용에 불편을 드려 죄송합니다.</h2>
	<p>
		잠시 후에 다시 한번 시도해 주시길 부탁 드립니다.
		동일한 문제가 지속적으로 발생할 경우 네이트/싸이월드 고객센터로 문의하여 주십시오.
		<a class="cs_center" href="http://helpdesk.nate.com">네이트 고객센터</a>
	</p>
	<a class="btn_prev_page" href="javascript:history.back();">이전 페이지로 가기</a>
	<a class="btn_go_home" href="//www.nate.com">네이트 홈으로 가기</a>
	<div class="footer">
		Copyright © <a href="http://www.skcomms.co.kr" target="_blank"><strong><span class="sk">SK</span> Communications.</strong></a> All rights reserved.
	</div>
</div>
</body>
</html>
