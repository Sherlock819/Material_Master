<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="../css/topnav.css">
  <link rel="stylesheet" href="../css/layout.css">
  <!-- <link rel="stylesheet" href="../css/inputWithIcon.css"> -->
  <link rel="stylesheet" href="../css/table.css">
  <link rel="stylesheet" href="../css/select.css">
  <link rel="stylesheet" href="../css/checkbox.css">
  <link rel="stylesheet" href="../css/loader.css">
  <link rel="stylesheet" href="../css/pagination.css">

  <script type="text/javascript" src="../js/topnav.js"></script>
  <script type="text/javascript" src="../js/login.js"></script>
  <script type="text/javascript" src="../js/checkboxCumRadio.js"></script>
  <script type="text/javascript" src="../js/materialMasterUser.js"></script>


</head>
<body onload=fetchData()>

<div class="topnav" id="myTopnav">
  <a href="#"><img src="../css/images/coal-india-logo.png" alt="MyCred logo"  style="width:50px;height:35px;"></a>
  <a href="#"><i class="fa fa-fw fa-home"></i></a>
  <a href="#"><i class="fa fa-fw fa-user"></i></a>
  <a href="#"><i class="fa fa-sign-out" aria-hidden="true"></i></a>

  <a href="javascript:void(0);" class="icon" onclick="myFunction()">
    <i class="fa fa-bars"></i></a>
</div>

<div id="table-container">
  <h2 align="center"> MATERIAL MASTER </h2>
  	<form id="info-form" action="" method="POST">

		<div  id="table" align="center"  style="width:auto; height:auto; overflow-x:auto;">

		</div>
    <div class="" id="spinner">

    </div>

    <div class="wrapper">

		<button type="submit" name="submit" onclick="createTable()">GOTO</button>
		<button type="submit" name="submit" onclick="addRow()">GOTO</button>

    <div class="pagination">
      <a onclick="refreshData(this)" id="pageBack" style="pointer-events: none" >&laquo;</a>
      <a href="javascript:refreshData(this)" id="1" class="active">1</a>
      <a href="javascript:refreshData(this)" id="2">2</a>
      <a href="javascript:refreshData(this)" id="3">3</a>
      <label id="dots" hidden>..</label>
      <a href="javascript:refreshData(this)" id="extended" hidden>4</a>
      <a href="javascript:refreshData(this)" id="pageNext">&raquo;</a>
    </div>

  </div>


	</form>

</div>

</body>
</html>
