function validate()
{
  var fname = document.getElementsByName("fname")[0];
  var lname = document.getElementsByName("lname")[0];
  var dob = document.getElementsByName("dob")[0];
  var email = document.getElementsByName("email")[0];
  var psw = document.getElementsByName("psw")[0];
  var cpsw = document.getElementsByName("cpsw")[0];
  if(validateForm(fname) && validateForm(lname) && validateForm(dob)
  &&  validateEmail(email) && validateForm(psw) && validateForm(cpsw) )
  {
    addUser();
  }
}

function addUser(){

        var fname = document.getElementsByName("fname")[0];
        var lname = document.getElementsByName("lname")[0];
        var dob = document.getElementsByName("dob")[0];
        var email = document.getElementsByName("email")[0];
        var psw = document.getElementsByName("psw")[0];
        var cpsw = document.getElementsByName("cpsw")[0];

            // Creating a XHR object
            let xhr = new XMLHttpRequest();
			      let xhr2 = new XMLHttpRequest();
            let url = "/addUser";

            // open a connection
            xhr.open("POST", url, true);

            // Set the request header i.e. which type of content you are sending
            xhr.setRequestHeader("Content-Type", "application/json");


            // Create a state change callback
            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4 && xhr.status === 200) {

                    console.log(xhr.response);
                    console.log(xhr.responseType);
                    if(this.responseText === "false")
                      alert("Email already registered!");
                    else {
                            // console.log("verification/"+email.value);
						                // xhr2.open("GET", "/verification/"+email.value, true);
                            // xhr2.setRequestHeader("Content-Type", "application/json");
                            // xhr2.send();
                      	    window.location.assign("/verification/"+email.value);
                    }
                }
            };

            // Converting JSON data to string
            var data = JSON.stringify({ "fname": fname.value,"lname": lname.value, "email": email.value ,"dob": dob.value, "password": psw.value  });

            // Sending data with the request
            xhr.send(data);
        }


function validateForm(field) {

  if (field.name === "fname" )
  {
    if(isEmpty(field))
    {
      document.getElementById("fname").innerHTML = "Firt Name cannot be empty";
      return false;
    }
    else
    {
      document.getElementById("fname").innerHTML = "";
      return true;
    }
    return;
  }

  if (field.name === "lname")
  {
    if(isEmpty(field))
    {
      document.getElementById("lname").innerHTML = "Last Name cannot be empty";
      return false;
    }
    else
    {
      document.getElementById("lname").innerHTML = "";
      return true;
    }
    return;
  }

  if (field.name === "dob")
  {
    if(isEmpty(field))
    {
      document.getElementById("dob").innerHTML = "Date of Birth cannot be empty";
      return false;
    }
    else
    {
      document.getElementById("dob").innerHTML = "";
      return true;
    }

    return;
  }


  if (field.name === "psw" )
  {
    if(isEmpty(field))
    {
      document.getElementById("password").innerHTML = "Password cannot be empty";
      return false;
    }
    else
    {
      document.getElementById("password").innerHTML = "";
      return true;
    }

    return;
  }


  if (field.name === "cpsw" )
  {
    if(isEmpty(field))
    {
      document.getElementById("cpassword").innerHTML = "Confirm Password cannot be empty";
      return false;
    }
    else
    {
      document.getElementById("cpassword").innerHTML = "";
      return true;
    }
    return;
  }

}

function isEmpty(field)
{
  console.log(field.name+" = "+field.value);
  if (field.value == "")
  {
      return true;
  }
  return false;
}

function validateEmail(emailField){
        var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;

        if (emailField.value == "")
        {
            document.getElementById("email").innerHTML = "Email cannot be empty";
            return false;
        }
        else
        if (reg.test(emailField.value) == false)
        {
            document.getElementById("email").innerHTML = "Invalid email!";
            return false;
        }
        else
        {
          document.getElementById("email").innerHTML = "";
          return true;
        }
        return true;
}



function toggle(field)
{
  var eye;
  var pass;
  if(field.id === "eye")
  {
    eye = document.getElementById("eye");
    pass = document.getElementsByName("psw")[0];
  }
  else {
    eye = document.getElementById("ceye");
    pass = document.getElementsByName("cpsw")[0];
  }
  if(eye.className == "fa fa-eye")
  {
    eye.className = "fa fa-eye-slash";
    pass.type = "text";
  }
  else
  {
    eye.className = "fa fa-eye";
    pass.type = "password";
  }
}
