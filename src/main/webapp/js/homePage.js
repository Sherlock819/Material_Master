function call()
{
	console.log("Clicked");
	var val = document.getElementById("sel").value; 
	console.log("Value = "+val);
	if(val === 1)
	{
		console.log("To material Master");
		window.location.assign("/materialMasterUser");
	}
}