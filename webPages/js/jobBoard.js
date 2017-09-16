$('#show').click(function () {
    $('#hidden').slideToggle('slow');
});

$('#show1').click(function () {
    $('#hidden1').slideToggle('slow');
});


$(document).ready(function(){
    //on récupère le JSON qui se trouve dans la route /advertisements
    $.getJSON('/advertisements', function(data) {
        //on calcule la taille de ce JSON pour savoir combien d'advertisements il y a dans la database
        var JobNumber = data.length;
        //on l'affiche
        console.log(JobNumber);
        
        //boucle sur i pour i < au nombre d'advertisements
        for (var i = 0 ; i <= JobNumber ; i++){
            
            //Ce code va être directement ajouté dans le html à la balise qui a pour id jobs (à modifier dans le htlm). La partie entre guillemets est propre à ma mise en page. Copier colle le morceau de code html que tu veux ajouter et remplace les données par data[i]."nom de l'attribut"
            $("#jobs").append(" <div class = 'row section'><div class='col s12 orange lighten-5'><div class='card'><div class='card-content'><h4>" + data[i].Title + "</h4><p>" + data[i].advertisementText + "</p><p class = 'bold'> Entreprise : " + data[i].companyName + "</p><div id = 'hidden" + data[i].id + "' class = 'hid'><p><br>" + data[i].advertisementText + "</p><p><br>Lieu : " + data[i].Location + "</p><p><br>Date de parution : " + data[i].parutionDate + "</p><p><br>Type de contrat : " + data[i].contractType + "</p><p><br>Type de poste : " + data[i].post + "</p><p><br>Expérience demandée : " + data[i].experienceAsked + "</p><p><br>Salaire : " + data[i].salary + "</p><p><br> Contacter : " + data[i].contactName + "<br>Email : " + data[i].contactEmail + "</p></div></div><div class='card-action'><a id='show" + data[i].id + "' class='orange lighten-1 waves-effect waves-light btn'>Learn more</a> <a class='orange lighten-1 waves-effect waves-light btn'>Apply</a></div></div></div></div>");
        }
    });
});