function sendRequest(httpMethod, uri) {
    $.ajax({
        type: httpMethod,
        url: uri,
        // data: "jobID="+ job +"& description="+ description +"& startDate="+ startDate +"& releaseDate="+ releaseDate +"& status="+ status,
        success: function(){
            alert("Udało się usunąć ogłoszenie")
        },
        error: function(XMLHttpRequest, textStatus, errorThrown) {
            alert("Nie udało się usunąć ogłoszenie")
        }
    });
}