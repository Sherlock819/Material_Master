function fetchData()
{
  createTable();
  //alert("loading");
  var empTab = document.getElementById('spinner');
 // empTab.setAttribute("className","spinner");
	empTab.className = "spinner";
  //alert("loading");
  getData();
  //empTab.setAttribute("class","");
	empTab.className = "";
  //alert("unloaded");

}

function getData()
{
	let url = "/getMaterial";

  	fetch(url,
	{
		method: "POST",
		// Adding body or contents to send
    body : JSON.stringify({
        page: 1,
        dataPerPage: 5
    }),
	headers: {
        "Content-type": "application/json; charset=UTF-8"
    }

	}).then(response => response.json())
    	.then(json => {
        	// code to handle the response
			console.log(json);
			let size = Object.keys(json).length;

			for(let i=0;i<size;i++)
			{
				addRow(json[i]);
			}

    	}).catch(err => {
        	console.error('Error: ', err);
    	});
}


// ARRAY FOR HEADER.
    var arrHead = new Array();
    arrHead = ['', 'Material-ID', 'Material Name', 'Available Units'];      // SIMPLY ADD OR REMOVE VALUES IN THE ARRAY FOR TABLE HEADERS.

    // FIRST CREATE A TABLE STRUCTURE BY ADDING A FEW HEADERS AND
    // ADD THE TABLE TO YOUR WEB PAGE.
    function createTable() {
        var material = document.createElement('table');
        material.setAttribute('id', 'material');            // SET THE TABLE ID.
	      var tr = material.createTHead().insertRow(-1);

        for (var h = 0; h < arrHead.length; h++) {

            var th = document.createElement('th');          // TABLE HEADER.
            th.innerHTML = arrHead[h];
			      tr.appendChild(th);
        }
		    material.createTBody();
        var div = document.getElementById('table');
        div.appendChild(material);    // ADD THE TABLE TO YOUR WEB PAGE.
    }

    // ADD A NEW ROW TO THE TABLE.s
    function addRow(rowData) {


        var empTab = document.getElementById('material').getElementsByTagName('tbody')[0];
        var rowCnt = empTab.rows.length;        // GET TABLE ROW COUNT.


	    var tr = empTab.insertRow(-1);

        var td = document.createElement('td');
		td = tr.insertCell(0);

        //ADD Para
        var para = document.createElement('p');

        var inp = document.createElement('input');
        inp.setAttribute("type","checkbox");
        inp.setAttribute("id","test"+(rowCnt+1));
        inp.setAttribute("onchange","clearRadio(this)");

       	var lbl = document.createElement('label');
        lbl.setAttribute("for","test"+(rowCnt+1));

        para.appendChild(inp);
        para.appendChild(lbl);

        td.appendChild(para);

  		for(var key in rowData)
		{
			var td = document.createElement('td');
			td = tr.insertCell(-1);
			if(rowData.hasOwnProperty(key))
				td.appendChild(document.createTextNode(rowData[key]));
		}
	}



    // DELETE TABLE ROW.
    function removeRow(oButton) {
        var empTab = document.getElementById('material');
        empTab.deleteRow(oButton.parentNode.parentNode.rowIndex);       // BUTTON -> TD -> TR.
    }

    // EXTRACT AND SUBMIT TABLE DATA.
    function sumbit() {
        var myTab = document.getElementById('material');
        var values = new Array();

        // LOOP THROUGH EACH ROW OF THE TABLE.
        for (row = 1; row < myTab.rows.length - 1; row++) {
            for (c = 0; c < myTab.rows[row].cells.length; c++) {   // EACH CELL IN A ROW.

                var element = myTab.rows.item(row).cells[c];
                if (element.childNodes[0].getAttribute('type') == 'text') {
                    values.push("'" + element.childNodes[0].value + "'");
                }
            }
        }
        console.log(values);
    }
