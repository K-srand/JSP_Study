<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   request.setCharacterEncoding("utf-8");
   String name = request.getParameter("name" ) ;
   String imgName = request.getParameter("imgName" ) ;
%> 

<br><br>
  <h1>이름은 <%= name%>입니다. </h1><br><br>
  <img src="./image/<%=imgName %>"  />
  