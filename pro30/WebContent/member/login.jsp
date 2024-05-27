<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>  
<%@ include file="../header.jsp" %>  

<%@ include file="sub_img.html"%> 
<%@ include file="sub_menu.html" %>  
  
  <article>
    <h1>Login</h1>
    <form name="loginForm" method="post" action="NonageShop?command=login">
        <fieldset>
        <legend></legend>
          <label>User ID</label>
          <input name="id" type="text" value="${id}" value="one"><br> 
          <label>Password</label> 
          <input name="pwd" type="password" value="1111"><br> 
        </fieldset>
        <div class="clear"></div>
        <div id="buttons">
            <input type="button" value="로그인" class="submit" onclick="isEmpty()"> 
            <input type="button" value="회원가입" class="cancel"
                 onclick="location='NonageShop?command=join_form'"> 
        </div>
    </form> 
    
  </article>
<%@ include file="../footer.jsp" %>      
