<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<c:set  var="articlesList"  value="${articlesMap.articlesList}" />
<c:set  var="totArticles"  value="${articlesMap.totArticles}" />
<c:set  var="section"  value="${articlesMap.section}" />
<c:set  var="pageNum"  value="${articlesMap.pageNum}" />

<c:set var="totalPage" value="${Math.ceil((totArticles*1.0)/10)}"/> 
<c:set var="endPage" value="${Math.ceil(pageNum/10.0)*10}"/>
<c:set var="startPage" value="${endPage-(10-1)}"/>
<c:set var="hasNext" value="${totalPage > endPage}"/>

<%
  request.setCharacterEncoding("UTF-8");
%>  
<!DOCTYPE html>
<html>
<head>
<style>
.no-uline {text-decoration:none;}
.sel-page{text-decoration:none;color:red;}
.cls1 {text-decoration:none;}
.cls2{text-align:center; font-size:30px;}
</style>
<meta charset="UTF-8">
<title>글목록창</title>
</head>
<body>
<table align="center" border="1"  width="80%"  >
  <tr height="10" align="center"  bgcolor="lightgreen">
     <td >글번호</td>
     <td >작성자</td>              
     <td >제목</td>
     <td >작성일</td>
  </tr>
<c:choose>
  <c:when test="${empty articlesList}" >
    <tr  height="10">
      <td colspan="4">
         <p align="center">
            <b><span style="font-size:9pt;">등록된 글이 없습니다.</span></b>
        </p>
      </td>  
    </tr>
  </c:when>
  <c:when test="${!empty articlesList}" >
    <c:forEach  var="article" items="${articlesList }" varStatus="articleNum" >
     <tr align="center">
	<td width="5%">${articleNum.count}</td>
	<td width="10%">${article.id }</td>
	<td align='left'  width="35%">
	    <span style="padding-right:30px"></span>    
	   <c:choose>
	      <c:when test='${article.level > 1 }'>  
	         <c:forEach begin="1" end="${article.level }" step="1">
	             <span style="padding-left:10px"></span> 
	         </c:forEach>
	         <span style="font-size:12px;">[답변]</span>
                   <a class='cls1' href="${contextPath}/board/viewArticle.do?articleNO=${article.articleNO}">${article.title}</a>
	          </c:when>
	          <c:otherwise>
	            <a class='cls1' href="${contextPath}/board/viewArticle.do?articleNO=${article.articleNO}">${article.title }</a>
	          </c:otherwise>
	        </c:choose>
	  </td>
	  <td  width="10%"><fmt:formatDate value="${article.writeDate}" /></td> 
	</tr>
    </c:forEach>
     </c:when>
    </c:choose>
</table>

 <div class="cls2">
	<c:if test="${endPage > totalPage }"> 
		<c:set var="endPage" value="${totalPage }"/> 
	</c:if>
	
	<c:if test="${totArticles != null }">
		<c:forEach var="page" begin="${ startPage }" end="${ endPage > totalPage ? totalPage : endPage }" step="1">
			<c:if test="${section > 1 && page == startPage}">
				<a class="no-uline" href="${contextPath }/board/listArticles.do?section=${section-1}&pageNum=${Math.round(startPage) - 1}">&nbsp; pre </a> 
			</c:if>
			<a class="no-uline" href="${contextPath }/board/listArticles.do?section=${section}&pageNum=${page}">${page} </a>
			<c:if test="${endPage == page && hasNext}"> 
				<a class="no-uline" href="${contextPath }/board/listArticles.do?section=${section+1}&pageNum=${Math.round(endPage + 1)}">&nbsp; next</a>
			</c:if>
		</c:forEach>
	</c:if>
</div>
 
<br><br>
<a  class="cls1"  href="${contextPath}/board/articleForm.do"><p class="cls2">글쓰기</p></a>
</body>
</html>