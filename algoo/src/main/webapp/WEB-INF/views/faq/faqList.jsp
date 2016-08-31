<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE HTML>
<html lang="ko">
<head>
<title>FAQ 목록</title>
<meta charset="utf-8">
<script type="text/javascript" src="<c:url value='/jquery/jquery-3.1.0.min.js'/>"></script>
<script type="text/javascript">	
	$(document).ready(function(){
		$(".divList .box2 tbody tr")
		.hover(function(){
			$(this).css("background","eee").css("cursor","pointer");
		}, function(){
			$(this).css("background","");
		});
	});
	
	function pageProc(curPage){
		document.frmPage.currentPage.value=curPage;
		document.frmPage.submit();
	}
</script>	
</head>	
<body>
<form name="frmPage" method="post" 
	action="<c:url value='/faq/faqList.ag'/>">
<input type="hidden" name="currentPage">
<input type="hidden" name="searchConditionz" value="${param.searchCondition }">
<input type="hidden" name="searchKeyword" value="${searchVO.searchKeyword }">	
</form>

<h2>FAQ</h2>
<div class="divList">
<c:if test="${!empty param.searchKeyword }">
	<p>검색어 : ${param.searchKeyword }, ${pagingInfo.totalRecord }건 검색되었습니다.</p>
</c:if>
<c:if test="${empty searchVO.searchKeyword }">
	<p>전체 조회 결과 - ${pagingInfo.totalRecord }건 조회되었습니다</p>
</c:if>

<table class="box2">
	<caption>FAQ</caption>
	<colgroup>
		<col style="width:15%;" />
		<col style="width:55%;" />
		<col style="width:15%;" />
		<col style="width:15%;" />		
	</colgroup>
	<thead>
	  <tr>
	    <th scope="col">번호</th>
	    <th scope="col">제목</th>
	    <th scope="col">작성일</th>
	    <th scope="col">조회수</th>
	  </tr>
	</thead> 
	<tbody>  
	<c:if test="${empty alist}">
		<tr>
			<td colspan="5" class="align_center">
			검색된 질문이 없습니다
			</td>
		</tr>
	</c:if>
	<c:if test="${!empty alist}">
		<c:forEach var="vo" items="${alist }">
			<tr style="text-align: center">
				<td>${vo.faqNo}</td>
				<td style="text-align: left;">
					<a href="<c:url value='/faq/updateCount.ag?faqNo=${vo.faqNo}'/>">
						${vo.title}</a>
				</td>
				<td><fmt:formatDate value="${vo.regdate}" pattern="yyyy-MM-dd"/>
				</td>
				<td>${vo.readCount}</td>
			</tr>				
		</c:forEach>
	</c:if>
	</tbody>
</table>	   
</div>
<div class="divPage">
	<c:if test="${pagingInfo.firstPage>1 }">	
		<a href="#" onclick="pageProc(${pagingInfo.firstPage-1})">
			<img src="<c:url value='/images/first.JPG'/>" alt="이전블럭으로">
		</a>	
	</c:if>
	<c:forEach var="i" begin="${pagingInfo.firstPage }" 
		end="${pagingInfo.lastPage }">	 
		<c:if test="${i==pagingInfo.currentPage }">
			<span style="color:blue;font-weight: bold">
				${i }</span>
		</c:if>		
		<c:if test="${i!=pagingInfo.currentPage }">
				<a href="#" onclick="pageProc(${i})">
				[${i}]</a>
		</c:if>
	</c:forEach>	
	
	<!-- 다음 블럭으로 이동 -->
	<c:if test="${pagingInfo.lastPage<pagingInfo.totalPage }">	
		<a href="#" 
		onclick="pageProc(${pagingInfo.lastPage+1})">
			<img src="<c:url value='/images/last.JPG'/>" alt="다음블럭으로">
		</a>
	</c:if>
</div>
<div class="divSearch">
   	<form name="frmSearch" method="post" 
   	action="<c:url value='/faq/faqList.ag' />" >
        <select name="searchCondition">
            <option value="title"
           	   <c:if test="${param.searchCondition=='title'}">
            		selected
               </c:if>
            >질문</option>
            <option value="content" 
            	<c:if test="${param.searchCondition=='content'}">
            		selected
               </c:if>
            >답변</option>
        </select>   
        <input type="text" name="searchKeyword" 
        	title="검색어 입력" value="${param.searchKeyword}" >   
		<input type="submit" value="검색">
    </form>
</div>

<div class="divBtn">
    <a href="<c:url value='/faq/faqWrite.ag'/>" > FAQ 쓰기</a>
</div>
</body>
</html>