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
  <link rel="stylesheet" href="/css/table.css">
  <script type="text/javascript" src="/js/topnav.js"></script>
  <script type="text/javascript" src="/js/login.js"></script>
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
  <h3 align=center>Sign in With Your Registered-ID</h3>

  <div id = "innerContainer">

      <div id = "innerContainer">
        <div class="fontuser">
            <label ><b>Email address</b></label>
            <input type="text"
                    placeholder="Enter Email"
                    name="email" required>
            <i class="fa fa-user fa-lg fa-fw" aria-hidden="true"></i>
            <span class="error" style="position: relative;" id="email"></span>
        </div>
      </div>

      <div id = "innerContainer">
        <div class="fontpassword">
            <label ><b>Password</b></label>
            <input type="password"
                    placeholder="Enter Password"
                    name="psw" required>
            <i class="fa fa-key icon" aria-hidden="true"></i>
            <span class="error" style="position: relative;" id="password"></span>
        </div>
      </div>

        <button type="submit" onclick="validate()">Login</button>
        <input type="checkbox" checked="checked">
                Remember me
        </input>
        <br/><br/><br/>
        <a href=registration><i class="fa fa-fw fa-user"></i> Register Here</a>
        &nbsp
        <a href="#"><i class="fa fa-key icon"></i> Forgot Password?</a>

    </div>


</div>

</body>
</html>
