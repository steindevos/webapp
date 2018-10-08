

// CRUD functions for the airplane class 
$(document).ready(function () {
    //start website with airports
    createAirports(); 
});




// creates airport objects
function createAirports() {
    let airports = ["Amsterdam", "Berlin", "London", "Paris", "Stockholm"]; 

    for (i = 0; i < airports.length; i++) {

        let newAirport = {
            "name": airports[i]
        }

        let validJsonAirport = JSON.stringify(newAirport); 

        // POST JSON to endpoint
        $.ajax({
            url: "http://localhost:8080/api/airport/",
            type: "post",
            data: validJsonAirport,
            contentType: "application/json",
            success: function (result) {
                 
            }
        });
    }
}