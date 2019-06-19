<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="cssFiles/form.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  <style>
  .square{
      width: 325px;
      height: 650px;
      background-color:#adb5bd;
  
}
.rectangle{
     width: 325px;
      height: 650px;
      background-color:#D3D3D3;
}
.picture{
      width: 100px;
      height: 100px;
      background-color:#B8B8B8;
  
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
}
table
{
border-collapse:collapse;
}
table th
{
border-right:2.5px solid #D1D5D5;
}
table th:last-child
{
border-right:0;
}
table th:nth-child(6)
{
border-right:0;
}
table th:nth-child(7)
{
border-right:0;
}
table td
{
border:2.5px solid #D1D5D5;
border-left:0;
}
table tr:first-child td
{
border-top:0;
}
table tr:last-child td
{
border-bottom: 0;
}
table tr td:last-child
{
border-right:0;
}
table tr td:nth-child(6)
{
border-right:0;
}
table tr td:nth-child(7)
{
border-right:0;
}
table td:first-child
{
border-right:0;
border-bottom:0;
}
table th:first-child
{
border-right:0;
}
</style>
</head>
<body>
<%@ include file="header.html" %>
<div class="row"><br><br>
<div class="col-sm-2">
<div class="rectangle" style="padding-top:10px;">
<div class="navbar" style="background-color:#B8B8B8;height:65px;"><p style="color:white;">PROFILE</p></div><br><br>
<center><div class="picture"></div><h3 style="font:bold;"><%=session.getAttribute("username") %></h3><img src="images/star.jpg"/><%=session.getAttribute("rating")%><br><br>
<h5>Contact</h4><%=session.getAttribute("contact") %><br><br>
<h5>Designation</h4><%=session.getAttribute("address") %><br><br><br>
<input type="submit" class="form-rounded" value="contactGrizzly" style="background-color:#B8B8B8;"></center><br><br>
</div><br>
</div>
<div class="col-sm-6">
<div class="container">
<div class="tab">
 <form action="/grizzly-store-vendor-web/ProductController"> <button class="tablinks" >PRODUCT</button></form>
  <form action="/grizzly-store-vendor-web/VendorController"><button class="tablinks" >VENDOR</button></form>
  
</div><br><br>
<form action="/grizzly-store-vendor-web/product.jsp">
  <select name="category" class="form-rounded" placehoder="Choose Action" style="padding-left:40px;">
    <option value="c">Choose Action</option>
<input type="text" name="n2" placeholder="Category name" class="form-rounded">

<select name="category" class="form-rounded" placehoder="sort by">
    <option value="s">sort by</option>
  
<input type="submit" value="AddProduct" class="form-rounded" style="float: right;background-color:#000000bf;color:white;">
</form>
<br><br>
<c:if test="${!empty prodList }">
<table>
<tr>
       <th width="20"></th> 
<th width="160">ProductList</th>
<th width="150">Brand</th>
<th width="150">Category</th>
<th width="80">rating</th>
</tr>
<c:forEach items="${prodList}" var="product">
<tr>
<td><input type="radio" name="product"></td>
<td>${product.pname}</td>
<td>${product.brand}</td>
<td>${product.category}</td>
<td>${product.rating}</td>
<td><form action="/grizzly-store-vendor-web/ViewController?pname=${product.pname}" method="post" style="padding-left:20px;">
<input type="submit" class="form-rounded" value="view" style="border-radius:20px;">
</form>
</td>
<td><form action=""><input type="submit"  class=" form-rounded" value="block" style="padding-left:20px;"></form>
</td>
</td>
<td><form action="/grizzly-store-vendor-web/DeleteController?pname=${product.pname}" method="post" style="padding-left:20px;"><input type="submit" class=" form-rounded" value="remove"></form>
</td>

</c:forEach>
</table>
</c:if>
</div>
</div>
</body>
</html>