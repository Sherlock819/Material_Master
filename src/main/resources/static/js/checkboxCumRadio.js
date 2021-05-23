function clearRadio(element)
{
  // console.log("HEE");
  var e = element.getAttribute("id");
  var table = document.getElementById("material");
  var totalRowCount = table.rows.length; // 5
  var tbodyRowCount = table.tBodies[0].rows.length; // 3
  console.log(totalRowCount);
  console.log(tbodyRowCount);
  // console.log(e);
  var i=1;
  for(i=1;i<totalRowCount;i++)
  {
    var s = "test"+i;
    // Uncheck
    if(e!=s)
      document.getElementById(s).checked = false;
  }
}
