<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="inc/top.jsp" %>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/mainPage.css'/>" />

<script type="text/javascript">

</script>

	<%-- <!-- 메인 컨테이너 페이지 -->
	<br>
	<img src="<c:url value='${pageContext.request.contextPath}/images/console.png'/>" 
		alt="메인테스트">
	<br><br> --%>
	
	<section>
		<div class="divMain">
			<div class="divCategory">
				<!-- 광고 및 기본 기능 -->
				<div class="divCAD">
				<div class="divCmHeader">
					<!-- 광고배너(2개) -->
					<table>
					<td><img src="<c:url value='/images/banner1.jpg'/>"></td>
					<td><img src="<c:url value='/images/banner2.jpg'/>"></td>
					</table>
				</div>
				<div class="divDivision">
					<!-- 알바 분류 -->
					<div class="divJob">
						<!-- 지역별 알바 -->
						지역별 알바
						<hr width="90px">
						<img src="<c:url value='/images/map.png'/>"
						 width="240px" height="200">
					</div>
					<div class="divJob">
						<!-- 업종별 알바 -->
						업종별 알바
						<hr width="90px">
						<table>
							<tr>
								<td><img src="<c:url value='/images/JobIcon/food.png'/>">
									<br>식당</td>
								<td><img src="<c:url value='/images/JobIcon/shop.png'/>">
									<br>상점</td>
								<td><img src="<c:url value='/images/JobIcon/dress.png'/>">
									<br>의류</td>
							</tr>
							<tr>
								<td><img src="<c:url value='/images/JobIcon/company.png'/>">
									<br>사무보조</td>
								<td><img src="<c:url value='/images/JobIcon/study.png'/>">
									<br>학원</td>
								<td><img src="<c:url value='/images/JobIcon/build.png'/>">
									<br>건축</td>
							</tr>
						</table>
					</div>
					<div class="divJob">
						<!-- 테마별 알바 -->
						테마별 알바
						<hr width="90px">
						<table>
							<tr>
								<td><img src="<c:url value='/images/JobIcon/part.png'/>">
									<br>단기알바</td>
								<td><img src="<c:url value='/images/JobIcon/today.png'/>">
									<br>당일지급</td>
							</tr>
							<tr>
								<td><img src="<c:url value='/images/JobIcon/quick.png'/>">
									<br>급구알바</td>
								<td><img src="<c:url value='/images/JobIcon/good.png'/>">
									<br>안심계약</td>
							</tr>
						</table>
					</div>
				</div>
				</div>
				<div class="divFunction">
					<!-- 로그인상자 및 광고 -->
					<div class="loginBox">
						<!-- 로그인상자 -->
					</div>
					<div class="divCommercial2">
						<!-- 다른 사이즈의 광고 -->
					</div>
				</div>
				<div class="divBrand">
					<!-- 브랜드 알바(페이지 슬라이드) -->
					<div id="divRoll">
						<ul class="divImgset">
							<li><a href="#" target="_self"><img src="<c:url value='/images/CircleBanner/BurgerKing_c.png'/>" alt=""/></a></li>
							<li><a href="#" target="_self"><img src="<c:url value='/images/CircleBanner/BR_c.png'/>" alt=""/></a></li>
							<li><a href="#" target="_self"><img src="<c:url value='/images/CircleBanner/Dunkin_c.png'/>" alt=""/></a></li>
							<li><a href="#" target="_self"><img src="<c:url value='/images/CircleBanner/GS25_c.png'/>" alt=""/></a></li>
							<li><a href="#" target="_self"><img src="<c:url value='/images/CircleBanner/Gyejul_c.png'/>" alt=""/></a></li>
							<li><a href="#" target="_self"><img src="<c:url value='/images/CircleBanner/Otoko_c.png'/>" alt=""/></a></li>
							<li><a href="#" target="_self"><img src="<c:url value='/images/CircleBanner/Joes_c.png'/>" alt=""/></a></li>
							<li><a href="#" target="_self"><img src="<c:url value='/images/CircleBanner/KFC_c.png'/>" alt=""/></a></li>
							<li><a href="#" target="_self"><img src="<c:url value='/images/CircleBanner/Outback_c.png'/>" alt=""/></a></li>
							<li><a href="#" target="_self"><img src="<c:url value='/images/CircleBanner/Vips_c.png'/>" alt=""/></a></li>
							<li><a href="#" target="_self"><img src="<c:url value='/images/CircleBanner/CJFood_c.png'/>" alt=""/></a></li>
							<li><a href="#" target="_self"><img src="<c:url value='/images/CircleBanner/LotteMart_c.png'/>" alt=""/></a></li>
							<li><a href="#" target="_self"><img src="<c:url value='/images/CircleBanner/Nike_c.png'/>" alt=""/></a></li>
							<li><a href="#" target="_self"><img src="<c:url value='/images/CircleBanner/PizzaHut_c.png'/>" alt=""/></a></li>
							<li><a href="#" target="_self"><img src="<c:url value='/images/CircleBanner/ParisBagguet_c.png'/>" alt=""/></a></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="divSpecial">
				<span id="divTitle">슈퍼 채용공고</span>
				<!-- 슈퍼 채용공고 리스트 -->
				<table class="tableSpecial">
					<tr>
						<td><img src="<c:url value='/images/company/001.jpg'/>">
						<br><span id="title">롯데아이몰</span>
						<br><span id="content">[재택근무] 2016년 상반기 알바</span></td>
						<td><img src="<c:url value='/images/company/002.jpg'/>">
						<br><span id="title">쿠팡</span>
						<br><span id="content">[재택근무] 2016년 상반기 알바</span></td>
						<td><img src="<c:url value='/images/company/003.jpg'/>">
						<br><span id="title">나이키</span>
						<br><span id="content">[재택근무] 2016년 상반기 알바</span></td>
						<td><img src="<c:url value='/images/company/004.jpg'/>">
						<br><span id="title">삼성전자판매</span>
						<br><span id="content">[재택근무] 2016년 상반기 알바</span></td>
						<td><img src="<c:url value='/images/company/005.jpg'/>">
						<br><span id="title">유엔난민기구</span>
						<br><span id="content">[재택근무] 2016년 상반기 알바</span></td>
					</tr>
					<tr>
						<td><img src="<c:url value='/images/company/006.jpg'/>">
						<br><span id="title">이베이</span>
						<br><span id="content">[재택근무] 2016년 상반기 알바</span></td>
						<td><img src="<c:url value='/images/company/007.jpg'/>">
						<br><span id="title">롯데백화점</span>
						<br><span id="content">[재택근무] 2016년 상반기 알바</span></td>
						<td><img src="<c:url value='/images/company/008.jpg'/>">
						<br><span id="title">우리카드</span>
						<br><span id="content">[재택근무] 2016년 상반기 알바</span></td>
						<td><img src="<c:url value='/images/company/009.jpg'/>">
						<br><span id="title">라이나생명</span>
						<br><span id="content">[재택근무] 2016년 상반기 알바</span></td>
						<td><img src="<c:url value='/images/company/010.jpg'/>">
						<br><span id="title">씨티뱅크</span>
						<br><span id="content">[재택근무] 2016년 상반기 알바</span></td>
					</tr>
					<tr>
						<td><img src="<c:url value='/images/company/011.jpg'/>">
						<br><span id="title">하나카드</span>
						<br><span id="content">[재택근무] 2016년 상반기 알바</span></td>
						<td><img src="<c:url value='/images/company/012.jpg'/>">
						<br><span id="title">롯데홈쇼핑</span>
						<br><span id="content">[재택근무] 2016년 상반기 알바</span></td>
						<td><img src="<c:url value='/images/company/013.jpg'/>">
						<br><span id="title">피자헛</span>
						<br><span id="content">[재택근무] 2016년 상반기 알바</span></td>
						<td><img src="<c:url value='/images/company/014.jpg'/>">
						<br><span id="title">서브웨이</span>
						<br><span id="content">[재택근무] 2016년 상반기 알바</span></td>
						<td><img src="<c:url value='/images/company/015.jpg'/>">
						<br><span id="title">빕스</span>
						<br><span id="content">[재택근무] 2016년 상반기 알바</span></td>
					</tr>
					<tr>
						<td><img src="<c:url value='/images/company/016.jpg'/>">
						<br><span id="title">스시로</span>
						<br><span id="content">[재택근무] 2016년 상반기 알바</span></td>
						<td><img src="<c:url value='/images/company/017.jpg'/>">
						<br><span id="title">죠스떡볶이</span>
						<br><span id="content">[재택근무] 2016년 상반기 알바</span></td>
						<td><img src="<c:url value='/images/company/018.jpg'/>">
						<br><span id="title">올리브영</span>
						<br><span id="content">[재택근무] 2016년 상반기 알바</span></td>
						<td><img src="<c:url value='/images/company/019.jpg'/>">
						<br><span id="title">산들해</span>
						<br><span id="content">[재택근무] 2016년 상반기 알바</span></td>
						<td><img src="<c:url value='/images/company/020.jpg'/>">
						<br><span id="title">아워홈</span>
						<br><span id="content">[재택근무] 2016년 상반기 알바</span></td>
					</tr>
					<tr>
						<td><img src="<c:url value='/images/company/021.jpg'/>">
						<br><span id="title">배스킨라빈스</span>
						<br><span id="content">[재택근무] 2016년 상반기 알바</span></td>
						<td><img src="<c:url value='/images/company/022.jpg'/>">
						<br><span id="title">롯데리아</span>
						<br><span id="content">[재택근무] 2016년 상반기 알바</span></td>
						<td><img src="<c:url value='/images/company/023.jpg'/>">
						<br><span id="title">던킨도넛</span>
						<br><span id="content">[재택근무] 2016년 상반기 알바</span></td>
						<td><img src="<c:url value='/images/company/024.jpg'/>">
						<br><span id="title">믹소</span>
						<br><span id="content">[재택근무] 2016년 상반기 알바</span></td>
						<td><img src="<c:url value='/images/company/025.jpg'/>">
						<br><span id="title">앤젤리너스</span>
						<br><span id="content">[재택근무] 2016년 상반기 알바</span></td>
					</tr>
				</table>
			</div>
			<div class="divGrand">
				<span id="divTitle">그랜드 채용공고</span>
				<table class="tableGrand">
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
				</table>
			</div>
			<div class="divOther">
				<!-- 일반 공고 리스트(게시판형) -->
			</div>
			<div class="divCmFooter">
				<!-- 광고배너(2개) -->
			</div>
		</div>
	</section>
	
<%@ include file="inc/bottom.jsp" %> 