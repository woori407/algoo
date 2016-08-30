<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>FAQ 쓰기</title>
<script type="text/javascript" 
src="<c:url value='/jquery/jquery-3.1.0.min.js' />"></script>
<script src="<c:url value='/ckeditor/ckeditor.js'/>" type="text/javascript"></script>

<script type="text/javascript">
	$(document).ready(function(){
		CKEDITOR.replace('content');	
		
		$("#frmWrite").submit(function(event){
			if($("#title").val().length<1){
				alert("질문을 입력하세요");
				$("#title").focus();
				event.preventDefault();
			}else if($("#content").val().length<1){
				alert("답변을 입력하세요");
				$("#content").focus();
				event.preventDefault();
			}
		});
	});
	
</script>
</head>
<body>
<div class="divForm">
<form name="frmWrite" id="frmWrite" method="post" 
  action="<c:url value='/faq/faqWrite.ag'/>" >
 <fieldset>
	<legend>FAQ 쓰기</legend>
        <div class="firstDiv">
            <label for="title">질문</label>
            <input type="text" id="title" name="title"  />
        </div>
        <div>  
        	<label for="content">답변</label>
        </div>
        <div>	        
 			<textarea id="content" name="content" 
 			rows="12" cols="40"></textarea>
        </div>
        <div class="center">
            <input type = "submit" value="FAQ 등록"/>
            <input type = "Button" value="FAQ 목록" 
      			onclick
="location.href='<c:url value="/faq/faqList.ag"/>';" />         
        </div>
    </fieldset>
</form>
</div>   
</body>
</html>