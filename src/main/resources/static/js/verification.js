function verify()
{
  var email = document.getElementById("email");
  var psw = document.getElementsByName("psw")[0];
  // Creating a XHR object
  let xhr = new XMLHttpRequest();
  let xhr2 = new XMLHttpRequest();
  let url = "/verifyUser";

  // open a connection
  xhr.open("POST", url, true);

  // Set the request header i.e. which type of content you are sending
  xhr.setRequestHeader("Content-Type", "application/json");


  // Create a state change callback
  xhr.onreadystatechange = function () {
      if (xhr.readyState === 4 && xhr.status === 200) {

          console.log(xhr.response);
          console.log(xhr.responseType);
          if(this.responseText === "1")
          {
            alert("Email is verified!");
            window.location.assign("/userHomePage");//to homepage
          }
          else
          if(this.responseText === "2") {
            alert("Wrong access code!");
          }
          else {
                  // console.log("verification/"+email.value);
                  xhr2.open("GET", "/login", true);
                  xhr2.setRequestHeader("Content-Type", "application/json");
                  xhr2.send();
                  window.location.assign(xhr2.responseURL);
          }
      }
  };

  // Converting JSON data to string
  console.log(email.value+" "+psw.value+" "+typeof(parseInt(psw.value)));
  var data = JSON.stringify({ "email": email.value ,"verificationCode": parseInt(psw.value)  });

  // Sending data with the request
  xhr.send(data);
}
