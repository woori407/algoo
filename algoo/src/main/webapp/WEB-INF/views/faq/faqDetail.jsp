<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html lang="ko">
<head>
<meta charset="utf-8">
</head>
<body>
	<h2>FAQ 상세보기</h2>
	<div class="divForm">
		<div class="firstDiv">
			<span class="sp1">질문</span> 
			<span>${faqVo.title }</span>
		</div>
		<div>
			<span class="sp1">등록일</span> 
			<span>${faqVo.regdate }</span>
		</div>
		<div>
			<span class="sp1">조회수</span> 
			<span>${faqVo.readCount }</span>
		</div>
		<div class="lastDiv">			
			<p class="content">${faqVo.content }</p>
		</div>
		<div class="center">
			<a href
="<c:url value='/faq/faqEdit.ag?faqNo=${faqVo.faqNo}'/>">
수정</a> |
        	<a href
="<c:url value='/faq/faqDelete.ag?faqNo=${faqVo.faqNo}'/>">
삭제</a> |
        	<a href
="<c:url value='/faq/faqList.ag'/>">목록</a>			
		</div>
	</div>
</body>
</html>