<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="/css/topnav.css">
  <link rel="stylesheet" href="/css/layout.css">
  <link rel="stylesheet" href="/css/inputWithIcon.css">
  <script type="text/javascript" src="/js/topnav.js"></script>
  <script type="text/javascript" src="/js/verification.js"></script>

</head>

<body>


<div class="topnav" id="myTopnav">
  <a href="#"><img src="../css/images/coal-india-logo.png" alt="MyCred logo"  style="width:50px;height:35px;"></a>
  <a href="#"><i class="fa fa-fw fa-home"></i></a>
  <a href="#"><i class="fa fa-fw fa-user"></i></a>
  <a href="javascript:void(0);" class="icon" onclick="myFunction()">
    <i class="fa fa-bars"></i></a>
</div>


<div id="container">
  <h3 align=center>Verify your email id - <b>${email}</b></h3>
  <input type="hidden" id="email" value=${email}>

  <div id = "innerContainer">

      <div id = "innerContainer">
        <div class="fontpassword">
            <label ><b>Enter Access Code</b></label>
            <input type="password"
                    placeholder="Enter Access Code Here"
                    name="psw" required>
            <span class="error" style="position: relative;" id="password"></span>
        </div>
      </div>

        <button type="submit" onclick="verify()">Verify</button>
        <input type="checkbox" checked="checked">
                Remember me on this PC
        </input>

    </div>


</div>

</body>
</html>
