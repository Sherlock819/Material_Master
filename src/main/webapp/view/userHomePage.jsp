<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="../css/topnav.css">
  <link rel="stylesheet" href="../css/layout.css">
  <%-- <link rel="stylesheet" href="../css/inputWithIcon.css"> --%>
  <link rel="stylesheet" href="../css/table.css">
  <link rel="stylesheet" href="../css/select.css">
  <script type="text/javascript" src="../js/topnav.js"></script>
  <script type="text/javascript" src="../js/login.js"></script>
  <script type="text/javascript" src="/js/homePage.js"></script>

</head>
<body>

<div class="topnav" id="myTopnav">
  <a href="#"><img src="../css/images/coal-india-logo.png" alt="MyCred logo"  style="width:50px;height:35px;"></a>
  <a href="#"><i class="fa fa-fw fa-home"></i></a>
  <a href="#"><i class="fa fa-fw fa-user"></i></a>
  <a href="#"><i class="fa fa-sign-out" aria-hidden="true"></i></a>

  <a href="javascript:void(0);" class="icon" onclick="myFunction()">
    <i class="fa fa-bars"></i></a>
</div>

<div id="container">
  <h2 align="center"> SCREEN MATERIAL </h2>

		  <div align="center">
		      <select id="sel">
            	<option value="1">Material Master</option>
		        <option value="2">My Transactions</option>
			   </select>
          <button onclick="call()" >GOTO</button>
			</div>

</div>

</body>
</html>
