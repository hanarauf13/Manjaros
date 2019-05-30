function validateForm() {
    var x = document.forms["myForm"]["fname"].value;
    if (x == "") {
        alert("Name must be filled out");
        return false;
    }
}

function DisplayReview(){
    var feedback = document.getElementById("feedback").value;
    DisplayReview.innerHTML= feedback;
}