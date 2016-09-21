<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>mainOther/speedEmp</title>
<script type="text/javascript">
	$(document).ready(function(){
		$("#divSpeed .speedEmp div")
			.hover(function(){
				$(this).css("border-color","black")
				.css("border-width", "1px")
				.css("cursor","pointer");
			},function(){
				$(this).css("border","");
			});
	});
</script>
</head>
<body>

<div id="divSpeed">
	<br><br>
	<p id="divTitle">스피드 채용공고</p>
	
	<div class="speedEmp" summary="스페셜 공고 리스트">
		<c:if test="${empty alist}">
				<div class="align_center">
					공고가 없습니다</div>
		</c:if>
		<c:if test="${empty alist}">
		</c:if>
		<!-- 반복 시작 -->
		<c:forEach var="vo" items="${alist}">
			<div class="speedCon">
			   <span><a href="<c:url value='/rec/updateCount.ag?recCode=${vo.recCode}'/>">
                  ${vo.compName }</a></span>
               <br>
               <a href="<c:url value='/rec/updateCount.ag?recCode=${vo.recCode}'/>">
                  ${vo.title}</a>
               <br>
               <c:set var="addr" value="${fn:split(vo.address,' ')}"/>
               <c:forEach var="i" begin="0" end="1">
                  ${addr[i] }
               </c:forEach>
               <br>
               <c:if test="${vo.payType=='시급' }">
                <span style="color:white;background-color:gray;padding:1px;border-radius:3px;font-weight:normal">시</span></c:if>
               <c:if test="${vo.payType=='일급' }">
                <span style="color:white;background-color:gray;padding:1px;border-radius:3px;font-weight:normal">일</span></c:if>
               <c:if test="${vo.payType=='주급' }">
                 <span style="color:white;background-color:gray;padding:1px;border-radius:3px;font-weight:normal">주</span></c:if>
               <c:if test="${vo.payType=='월급' }">
                 <span style="color:white;background-color:gray;padding:1px;border-radius:3px;font-weight:normal">월</span></c:if>
               <c:if test="${vo.payType=='연봉' }">
                 <span style="color:white;background-color:gray;padding:1px;border-radius:3px;font-weight:normal">연</span></c:if>
               <fmt:formatNumber pattern="#,###"
               value="${vo.pay }"/>원
            </div>
		</c:forEach>
		<!-- 반복 끝 -->
	</div>
</div>

</body>
</html>