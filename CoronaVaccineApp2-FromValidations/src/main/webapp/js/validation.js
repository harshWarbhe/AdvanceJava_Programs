function validate(frm) {

	//empty the from validaton error msg
	document.getElementById("pNameId").innerHTML = "";
	document.getElementById("pCityId").innerHTML = "";
	document.getElementById("pAgeId").innerHTML = "";

	//read from data
	let name = frm.pname.value;
	let city = frm.pcity.value;
	let age = frm.page.value;

	//client side from validation
	let flag = true;

	if (name == "") {
		document.getElementById("pNameId").innerHTML = "person name is required";
		frm.pname.focus();
		flag = false;
	}

	if (city == "") {
		document.getElementById("pCityId").innerHTML = "person city is required";
		frm.pcity.focus();
		flag = false;
	}

	if (age === "") {
	    document.getElementById("pAgeId").innerHTML = "Person age is required";
	    frm.page.focus();
	    flag = false;
	  } else if (isNaN(age)) {
	    document.getElementById("pAgeId").innerHTML = "Age must be numeric";
	    frm.page.focus();
	    flag = false;
	  } else if (age <= 0 || age > 125) {
	    document.getElementById("pAgeId").innerHTML = "Age must be between 1 to 125";
	    frm.page.focus();
	    flag = false;
	  }

	return flag;
}