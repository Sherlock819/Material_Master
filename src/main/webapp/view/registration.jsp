<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="/css/topnav.css">
  <link rel="stylesheet" href="/css/registration.css">
  <script type="text/javascript" src="/js/topnav.js"></script>
  <script type="text/javascript" src="/js/registration.js"></script>



</head>

<body>


<div class="topnav" id="myTopnav">
<a href="#"><img src="../css/images/coal-india-logo.png" alt="MyCred logo"  style="width:50px;height:35px;"></a>
  <a href="#"><i class="fa fa-fw fa-home"></i></a>

  <a href="javascript:void(0);" class="icon" onclick="myFunction()">
    <i class="fa fa-bars"></i></a>
</div>

<div id="container">
  <h3 align=center>Create BCCL Employee Account</h3>

  <div id = "innerContainer">

        <div id="innerContainer">
            <label ><b>First Name</b><span class="error" >*</span></label>
            <input type="text"
                    placeholder="Enter FirstName"
                    name="fname"  required>
            <span class="error" style="position: relative;" id="fname"></span>
        </div>

        <div id="innerContainer">
            <label ><b>Last Name</b><span class="error" >*</span></label>
            <input type="text"
                    placeholder="Enter LastName"
                    name="lname"  required>
            <span class="error" style="position: relative;" id="lname"></span>
        </div>

        <div id="innerContainer">
            <label ><b>Email address</b><span class="error" >*</span></label>
            <input type="text"
                    placeholder="Enter Email"
                    name="email"  required>
            <span class="error" style="position: relative;" id="email"></span>
        </div>

        <div id="innerContainer">
            <label ><b>Date Of Birth</b><span class="error" >*</span></label>
            <input type="date"
                    name="dob"  required>
            <span class="error" style="position: relative;" id="dob"></span>
        </div>

        <div class="fontpassword" id="innerContainer">
            <label ><b>Password</b><span class="error" >*</span></label>
            <input type="password"
                    placeholder="Enter Password"
                    name="psw"  required>
            <i class="fa fa-eye" aria-hidden="true" id="eye" onclick="toggle(this)"></i>
            <span class="error" style="position: relative;" id="password"></span>
        </div>

        <div class="fontpassword" id="innerContainer">
            <label ><b>Confirm Password</b><span class="error" >*</span></label>
            <input type="password"
                    placeholder="Re-enter Password"
                    name="cpsw"   required>
            <i class="fa fa-eye" aria-hidden="true" id="ceye" onclick="toggle(this)"></i>
            <span class="error" style="position: relative;" id="cpassword"></span>
        </div>

        <button type="submit" onclick="validate()">Register</button>
    </div>


</div>

</body>
</html>
