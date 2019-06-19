<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
}
</style>
</head>
<body>
<%@ include file="header.html" %>
<br><br>

<div class="row"><br><br>
<div class="col-sm-3">
<div class="rectangle" style="padding-top:10px;">
<div class="navbar" style="background-color:#B8B8B8;height:65px;"><p style="color:white;">PROFILE</p></div><br><br>
<center><div class="picture"></div><h3 style="font:bold;"><%=session.getAttribute("username") %></h3><br>
<h4>ID</h4><%=session.getAttribute("userid") %><br><br>
<h4>Designation</h4><%=session.getAttribute("designation") %><br><br>
<h4>Office</h4><%=session.getAttribute("office") %></center>
</div><br>
</div>
<div class="col-sm-3">
<div class="tab">
 <form action="/grizzly-store-admin-web/ProductController"> <button class="tablinks" >PRODUCT</button></form>
  <button class="tablinks" >VENDOR</button>
  
</div><br><br>
<div><img src="images/product-add1.jpg"/></div><br><br>
</div>
<div class="col-sm-3"><br><br><br>
<form action="/grizzly-store-admin-web/ProductController" method="post" >
<input type="text" name="id" class="form-rounded" placeholder="Enter Product Id"><br><br>
<select name="category" class="form-rounded" placehoder="Category" style="width:180px;">
    <option value="Personal Care">Personal Care</option>
    <option value="Laptops">Laptops</option>
    <option value="Art Supplies">Art Supplies</option>
   
</select><br><br>
<input type="text" name="name" class="form-rounded" placeholder="Name"><br><br>
<input type="text" name="description" class="form-rounded" placeholder="Description"><br><br>
<input type="text" name="price" class="form-rounded" placeholder="Price"><br><br>
<div style="float:right;">
<input type="submit" class="form-rounded"  style="background-color:#000000bf;color:white;" value="add"></form><br><br>
<form action="/grizzly-store-admin-web/list.jsp">
<input type="submit" class="form-rounded" value="cancel">
</form>
</div>
<br>
</div>
</div>


</body>
</html>