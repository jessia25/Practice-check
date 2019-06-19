<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="cssFiles/form.css">
<title>Insert title here</title>
<style>
  .rectangle{
      width: 325px;
      height: 550px;
      background-color: #D3D3D3;
  
}
.picture{
      width: 100px;
      height: 100px;
      background-color: #B8B8B8;
  
}
.tab {
  overflow: hidden;
  border: 1px solid #ccc;
  background-color: #D3D3D3;
}

/* Style the buttons inside the tab */
.tab button {
  background-color: #D3D3D3;
  float: left;
  border: none;
  outline: none;
  cursor: pointer;
  padding: 14px 16px;
  transition: 0.3s;
  font-size: 17px;
}

/* Change background color of buttons on hover */
.tab button:hover {
  background-color:  #B8B8B8;
}

/* Create an active/current tablink class */
.tab button.active {
  background-color:#D3D3D3;
}</style>
</head>
<body>
<%@ include file="header.html" %>
<div class="row"><br><br>
<div class="col-sm-3">
<div class="rectangle" style="padding-top:10px;">
<div class="navbar" style="background-color:#B8B8B8;height:65px;"><b>PROFILE</b></div><br>
<center><div class="picture"></div><h3 style="font:bold;"><%=session.getAttribute("username") %></h3><br>
<h4>ID</h4><%=session.getAttribute("userid") %><br><br>
<h4>Designation</h4><%=session.getAttribute("designation") %><br><br>
<h4>Office</h4><%=session.getAttribute("office") %></center>
</div>
</div><br>
<div class="col-sm-3">
<div class="tab">
 <form action="/grizzly-store-admin-web/ProductController"> <button class="tablinks" >PRODUCT</button></form>
  <button class="tablinks" >VENDOR</button>
  </div><br>
<p><b>${product.pname}</b> by ${product.brand}&nbsp;&nbsp;&nbsp;<img src="images/icon.jpg" width="25px;">
<br>
<img src="images/star.jpg" width="20px;">&nbsp;&nbsp;&nbsp;${product.rating}
<img src="images/product-view1.jpg"/>
</div>
<div class="col-sm-2" style="padding-bottom:10px;">
<br><br><br><br><br><br><br>
<div><h3>Product Description</h3><br>
<p>${product.description}</p></div><br><br><br><br><br><br><br><br>
<div ><h4>Rs.${product.price}- ${product.discount}off</h4></div><br>
</div>

<div class="col-sm-2"><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<form action="/grizzly-store-admin-web/ProductController">
<input type="submit" class="form-rounded" value="finish" style="background-color:#000000bf;color:white;";></form><br>
<form  action="/grizzly-store-admin-web/ProductController">
<input type="submit" class="form-rounded" value="cancel"></form><br>
</div>
</div>
</body>
</html>