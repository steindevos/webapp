$(document).ready(function () {
    

    // post new airplane
    $("#newAirplaneForm").on('submit', function (e) {

        // Post the data from the form
        postAirplane();

        // Reset form
        $("#airplaneName").val("");
        $("#airport").val("");
    });
});


// create a new airplane and post it to the database
function postAirplane() {
    
    // get data from html
    let name = $("#airplaneName").val(); 
    let airport = $("#airport").val();
    
    // create js object
    let newAirplane = {
        name: name,
        airport: {"id": airport}
    }

    // create valid JSON
    let validJsonAirplane = JSON.stringify(newAirplane); 

    console.log(validJsonAirplane); 

    // Post JSON to endpoint.
    $.ajax({
        url: "http://localhost:8080/api/airplane/",
        type: "post",
        data: validJsonAirplane,
        contentType: "application/json",
        success: function (result) {
           
        }
    });
    // close modal
    $('#newSupplierBtn').click();

}