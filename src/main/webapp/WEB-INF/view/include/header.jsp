<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>

	<head>
		<!-- META DATA -->
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">

		<!--font-family-->
		<link href="https://fonts.googleapis.com/css?family=Rufina:400,700" rel="stylesheet" />
		<link href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900" rel="stylesheet" />
		<script
		  src="https://code.jquery.com/jquery-3.5.1.min.js"
		  integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
		  crossorigin="anonymous"></script>
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.0/css/all.css">
		<link rel="stylesheet" href="assets/css/style.css" />
		<link rel="stylesheet" href="assets/css/common-style.css" />
		<link rel="stylesheet" href="assets/css/bootstrap.min.css" />
		
		<!-- TITLE OF SITE -->
		<title>ExpenseTracker</title>

	</head>
	<body>
<%
	application.setAttribute("root", request.getContextPath());
%>
	<header class="mb30">
		<nav class="cf">
			<ul class="fl">
				<li class="inblock mr10">
					<a href="${root}/admin">카테고리 관리</a>
				</li>
				<li class="inblock mr10">
					<a href="${root}/insert">비용 입력</a>
				</li>
				<li class="inblock">
					<a href="${root}/totalChart">통계 확인</a>
				</li>
			</ul>
			<ul class="fr tar">
				<li class="inblock">
					<a href="${root}/admin">관리자</a>
				</li>
				<li class="inblock ml10">
					<a href="${root}/insert">사용자</a>
				</li>
			</ul>
		</nav>
	</header>