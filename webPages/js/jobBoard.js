$('#show').click(function () {
    $('#hidden').slideToggle('slow');
});

$('#show2').click(function () {
    $('#hidden2').slideToggle('slow');
});

$('#show3').click(function () {
    $('#hidden3').slideToggle('slow');
});


$(document).ready(function(){
    $.getJSON('/advertisements', function(data) {
        var JobNumber = data.length;
        console.log(JobNumber);
        
        for (var i = 0 ; i <= JobNumber ; i++){
            $("#jobs").append(" <div class = 'row section'><div class='col s12 orange lighten-5'><div class='card'><div class='card-content'><h4>" + data[i].Title + "</h4><p>" + data[i].advertisementText + "</p><p class = 'bold'> Entreprise : " + data[i].companyName + "</p><div class = 'hidden'><p><br>" + data[i].advertisementText + "</p><p><br>Lieu : " + data[i].Location + "</p><p><br>Date de parution : " + data[i].parutionDate + "</p><p><br>Type de contrat : " + data[i].contractType + "</p><p><br>Type de poste : " + data[i].post + "</p><p><br>Expérience demandée : " + data[i].experienceAsked + "</p><p><br>Salaire : " + data[i].salary + "</p><p><br> Contacter : " + data[i].contactName + "<br>Email : " + data[i].contactEmail + "</p></div></div><div class='card-action'><a class = 'hidden' class='orange lighten-1 waves-effect waves-light btn'>Learn more</a> <a class='orange lighten-1 waves-effect waves-light btn'>Apply</a></div></div></div></div>")
        }
    });
});

var idCount = 1;
$('div').each(function() {
   $(this).attr('id', 'q' + idCount);
   idCount++;
});