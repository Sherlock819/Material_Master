function login(){

        var email = document.getElementsByName("email")[0];
        var psw = document.getElementsByName("psw")[0];

            // Creating a XHR object
            let xhr = new XMLHttpRequest();
			      let xhr2 = new XMLHttpRequest();
            let url = "/userLogin";

            // open a connection
            xhr.open("POST", url, true);

            // Set the request header i.e. which type of content you are sending
            xhr.setRequestHeader("Content-Type", "application/json");

            // Create a state change callback
            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4 && xhr.status === 200) {

                    console.log("Response Code : "+this.responseText);
                    if(this.responseText === "2")
                      alert("Wrong Password!");
                    else
                    if(this.responseText === "3")
                    {
                      alert("Email not registered!");
                    }
                    else
                    if(this.responseText === "4")
                    {
                        var url2 = "verification/"+email.value;
                        console.log(url2);
                        // xhr2.open("GET", url2, true);
                        // xhr2.setRequestHeader("Content-Type", "application/json");
                        // xhr2.send();
                        // console.log(xhr2.response);
                        // console.log(xhr2.responseURL);
                        // console.log(xhr2.responseText);
                        window.location.assign(url2);
                    }
                    else {
                              alert("Welcome User!");
						                  // xhr2.open("GET", "registration", false);
						                  // xhr2.send();
                      	      // window.location.assign(xhr2.responseURL);
                    }
                }
            };

            // Converting JSON data to string
            var data = JSON.stringify({ "email": email.value ,"password": psw.value  });

            // Sending data with the request
            xhr.send(data);
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


        function validate()
        {
          var email = document.getElementsByName("email")[0];
          var psw = document.getElementsByName("psw")[0];
          if(validateEmail(email) && validateForm(psw))
          {
            login();
          }
        }
        function validateForm(field) {

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
