<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="../inc/simple_top.jsp" %>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/noticeStyle.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/simpleButton.css" />

<script type="text/javascript">
	function del(no){
		if(confirm("공지사항을 삭제하시겠습니까?")){
			location.href
		="<c:url value='/notice/delete.ag?no='/>"+${noticeVo.mainNo};
		}
	}
</script>

<section>
<div class="divForm">
	<legend>공지사항 상세보기</legend>
		<div class="firstDiv2">
			<span class="sp1">[${noticeVo.category }] ${noticeVo.title }</span>
			<span class="sp2">작성일 <fmt:formatDate value="${noticeVo.regdate }" pattern="yyyy-MM-dd"/></span>
		</div>
		<div class="secondDiv">
			<p class="content">${noticeVo.content }</p>
		</div>
		<div class="center">
			<br>
			<input type = "Button" class="button white medium" value="수정" 
	      		onclick="location.href
	      			='<c:url value="/notice/edit.ag?no=${noticeVo.mainNo}" />'"> 
	     	<input type = "Button" class="button white medium" value="삭제" 
	      		onclick="del(${noticeVo.mainNo})" />
	      	<input type = "Button" class="button white medium" value="목록" 
	      		 onclick="location.href
      			='<c:url value="/notice/list.ag" />'"/>
		</div>
		<div class="showContent">
			<table class="contentBox">
				<colgroup>
					<col style="width:15%;" />
					<col style="width:70%;" />
					<col style="width:15%" />
				</colgroup>
				<thead>
					<th class="arrow"></th>
					<th class="ctitle"></th>
					<th class="cdate"></th>
				</thead>
				<tbody>
					<tr style="border-bottom: 1px dashed lightgray;">
						<td style="padding-left: 5px;">
							<a href="<c:url value='/notice/detail.ag?no=${preNoticeVo.mainNo}' />">
								<img alt="이전글 이미지" src="<c:url value='/images/up.png'/>">&nbsp;이전글
							</a>
						</td>
						<td>
							<c:if test="${empty preNoticeVo.mainNo}">
								<span style="color: gray">이전 글이 없습니다</span>
							</c:if>
							<a href="<c:url value='/notice/detail.ag?no=${preNoticeVo.mainNo}' />">
								${preNoticeVo.title}
							</a>
						</td>
						<td class="align_center"><fmt:formatDate value="${preNoticeVo.regdate }" pattern="yyyy-MM-dd"/></td>
					</tr>
					<tr>
						<td style="padding-left: 5px;">
							<a href="<c:url value='/notice/detail.ag?no=${nextNoticeVo.mainNo}' />">
								<img alt="다음글 이미지" src="<c:url value='/images/down.png'/>">&nbsp;다음글
							</a>
						</td>
						<td>
							<c:if test="${empty nextNoticeVo.mainNo}">
								<span style="color: gray">다음 글이 없습니다</span>
							</c:if>
							<a href="<c:url value='/notice/detail.ag?no=${nextNoticeVo.mainNo}' />">
								${nextNoticeVo.title }
							</a>		
						</td>
						<td class="align_center"><fmt:formatDate value="${nextNoticeVo.regdate }" pattern="yyyy-MM-dd"/></td>
					</tr>
				</tbody>
			</table>
		</div>
</div>
</section>

<%@ include file="../inc/simple_bottom.jsp" %> 