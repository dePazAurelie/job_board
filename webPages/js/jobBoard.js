$(document).ready(function(){
    //on récupère le JSON qui se trouve dans la route /advertisements
    $.getJSON('/advertisements', function(data) {
        //on calcule la taille de ce JSON pour savoir combien d'advertisements il y a dans la database
        var JobNumber = data.length;
        //on l'affiche
        console.log(JobNumber);
        
        //boucle sur i pour i < au nombre d'advertisements
        for (var i = 0 ; i <= JobNumber ; i++){
            $("#jobs").append("<div class='card'><div class='card-content' ng-repeat = 'single in packageNames'><h4>" + data[i].Title + "</h4><p>" + data[i].advertisementText + "</p><p><br><span class = 'bold'>Entreprise : </span>" + data[i].companyName + "</p><ul class='collapsible' data-collapsible='accordion'><li><div class='collapsible-header'><i class='material-icons'>fingerprint</i>Learn more !</div><div class='collapsible-body'><div><p><br><span class = 'bold'>Description :</span><br>" + data[i].advertisementText + "</p><p><br><span class = 'bold'>Date de parution : </span>" + data[i].parutionDate + "</p><p><br><span class = 'bold'>Lieu : </span>" + data[i].Location + "</p><p><br><span class = 'bold'>Type de contrat :</span>" + data[i].contractType + "</p><p><br><span class = 'bold'>Expérience demandée : </span>" + data[i].experienceAsked + "</p><p><br><span class = 'bold'>Salaire : </span>" + data[i].salary + "</p><p><br><span class = 'bold'>Contacter : </span>" + data[i].contactName + "<br><span class = 'bold'>Email : </span>" + data[i].contactEmail + "</p></div></div></li></ul></div><div class='card-action'><a class='orange lighten-1 waves-effect waves-light btn'>Apply</a></div></div>");
        }
        $('.collapsible').collapsible();
    });
});