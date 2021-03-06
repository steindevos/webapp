$(document).ready(function () {

    $("#airplaneTable").DataTable({
        columns: [
            { "data": "id" },
            { "data": "name" },
            { "data": "airport"},
            { "data": "fuelLoad" },
            {
                data: function (data, type, row) {
                    return '<button id="flight" class="btn btn-primary" type="button" data-toggle="modal" data-target="#flightModal" onclick="setIdForDelete(' + data.id + ')"><i class="fas fa-edit"></i></button><button id="refuel" class="btn btn-primary edit-btn" onclick="" type="button"><i class="fas fa-plus-square"></i></button>';
                }
            }
        ]
    });

    // post new airplane
    $("#newAirplaneForm").on('submit', function (e) {

        // Post the data from the form
        postAirplane();

        // Reset form
        $("#airplaneName").val("");
        $("#airport").val("");
    });

     // edit airplane (make flight)
     $("#newFlightForm").on('submit', function (e) {

        // edit single supplier
        editAirplane();
    })

    // get data to start
    getData();
});

// get data 
function getData() {
    // Get the data from endpoint.
    $.ajax({
        url: "http://localhost:8080/api/airplane/",
        type: "get",
        success: function (airplane) {
            // On successful get, reload the datatable with new data.
            $('#airplaneTable').DataTable().clear();
            $('#airplaneTable').DataTable().rows.add(airplane);
            $('#airplaneTable').DataTable().columns.adjust().draw();
        }
    });
}

function getAirport(id) {
    // GET data from backend
    $.ajax({
        url: "http://localhost:8080/api/airport/" + id,
        type: "get",
        data: id,
        contentType: "application/json",
        success: function (airport) {
            console.log(airport.name); 
            return airport.name; 
        }
    });
}


// create a new airplane and post it to the database
function postAirplane() {

    // get data from html
    let name = $("#airplaneName").val();
    let airport = $("#airport").val();

    // create js object
    let newAirplane = {
        name: name,
        airport: { "id": airport }
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
            // get new data
            getData();
        }
    });

    // close modal
    $('#newAirplaneBtn').click();
}

// EDIT data
function editAirplane() {
    // Get values from Html
    let id = $("#id").val();

    // create JS object
    let flight = {
        airport: $("#editAirport").val(),
        id: id
    }

    // create JSON object
    let validJsonflight = JSON.stringify(flight);

    // PUT request to endpoint
    $.ajax({
        url: "http://localhost:8080/api/airplane/" + id,
        type: "put",
        data: validJsonflight,
        contentType: "application/json",
        success: function () {
            // update table with new data
            getData();
        }
    })
    // close modal
    $("#flight").click();
}

// Set id for deletion in the modal
function setIdForDelete(id) {
    $("#id").val(id);
}



