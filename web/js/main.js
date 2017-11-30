/* 
 * main.js
 */
var tCinemaPourRecherche = new Array();

function init() {
    console.log("Bonjour les amis 'init'");
    autoCompleteBarreRecherche();
    $("#btSubmit").on("click", rechercheCinemaProche);
    // $('#cinemas').DataTable();
}

/**
 * 
 * @returns {undefined}
 */
function autoCompleteBarreRecherche() {

    //mes variables
    var tListeCinema;
    var objectCinema;
    var tNomCinemaAutoComplete = new Array();
    var jqXHR;

    //mon code ajax en$ get
    jqXHR = $.get(
            "/MongoDBWeb/CinemaNearInit", // l'url
            "json"//le type
            );
    jqXHR.done(function(data) {
        console.log("ajax done");
        tListeCinema = data;// data est une string d'un tableau d'objet json
//        console.log(tListeCinema.length);
        for (var i = 0; i < tListeCinema.length; i++) {// pour chaque objet du tableau de json
//            console.log(tListeCinema[i].nomCinema);
            objectCinema = tListeCinema[i];
            tNomCinemaAutoComplete.push(objectCinema.nomCinema);// on récupère le titre du film et on l'incorpore a un tableau
            tCinemaPourRecherche[objectCinema.nomCinema] = objectCinema.coords;
//            console.log(objectCinema.coords);
        }
        $("#recherche").autocomplete({// sur l'imput sugegestion de noms j'opère l'autocomplete
            source: tNomCinemaAutoComplete, //source : un tableau des noms de stations
            minLength: 3// on indique qu'il faut taper au moins 3 caractères pour afficher l'autocomplétion
        });//fin autocomplete
    });
}


/**
 * 
 * @returns {undefined}
 */
function rechercheCinemaProche() {

    console.log(tCinemaPourRecherche[$("#recherche").val()]);
    console.log($("#distance").val());



    var tListeCinema;
    var objectCinema;
    var tObjectCinema = new Array();
    var jqXHR;

    //mon code ajax en$ get
    jqXHR = $.get(
            "/MongoDBWeb/CinemaNearCTRL", // l'url
            {
                lat: tCinemaPourRecherche[$("#recherche").val()].lat,
                lng: tCinemaPourRecherche[$("#recherche").val()].lng,
                distance: $("#distance").val()
            },
    "json"//le type
            );
    jqXHR.done(function(data) {
        console.log("ajax done");
        tListeCinema = data;// data est une string d'un tableau d'objet json
        console.log(tListeCinema.length);
        for (var i = 0; i < tListeCinema.length; i++) {// pour chaque objet du tableau de json
//            console.log(tListeCinema[i].nomCinema);
            objectCinema = tListeCinema[i];
//            console.log(objectCinema.nomCinema);
            tObjectCinema.push(objectCinema);
        }
        afficherCarte(tObjectCinema);
    });

}


function afficherCarte(tableauObject) {//position geolocalisé au lancement de la page sans la recherche par nom ou adresse
    var latitude = tCinemaPourRecherche[$("#recherche").val()].lat;
    var longitude = tCinemaPourRecherche[$("#recherche").val()].lng;

    // --- Affiche une carte a latitude, longitude, zoom (De 1 a 20)
    var coordonnees = new google.maps.LatLng(latitude, longitude);

    // --- Les options
    var options = {
        zoom: 16,
        mapTypeId: google.maps.MapTypeId.ROADMAP,
        center: coordonnees
    };

    // --- La carte
    var carte = new google.maps.Map(document.getElementById("divMap"), options);

    var tObjectCinemasProches = [];
    tObjectCinemasProches = tableauObject;

    /* Déclaration de l'objet qui définira les limites de la map */
    var bounds = new google.maps.LatLngBounds();

    /* Déclaration et remplissage du tableau qui contiendra nos points, objets LatLng. */
    var myPoints = [];
    for (var j = 0; j < tObjectCinemasProches.length; j++) {
        console.log(tableauObject[j].coords.lat + " , " + tObjectCinemasProches[j].coords.lng);
        var latitudeCinemaProche = tObjectCinemasProches[j].coords.lat;
        var longitudeCinemaProche = tObjectCinemasProches[j].coords.lng;
        if (tObjectCinemasProches[j].nomCinema === $("#recherche").val()) {
            myPoints.unshift(new google.maps.LatLng(latitudeCinemaProche, longitudeCinemaProche));
        } else {
            myPoints.push(new google.maps.LatLng(latitudeCinemaProche, longitudeCinemaProche));
        }
    }

    bounds.extend(myPoints[0]);
    var thisMarker = addThisMarker(myPoints[0], 0);
    thisMarker.setMap(carte);

    /* Boucle sur les points afin d'ajouter les markers à la map
     et aussi d'étendre ses limites (bounds) grâce à la méthode extend */
    for (var i = 1; i < myPoints.length; i++) {
        bounds.extend(myPoints[i]);
        var thisMarker = addThisMarker(myPoints[i], i);
        thisMarker.setMap(carte);
    }

    /* Ici, on ajuste le zoom de la map en fonction des limites  */
    carte.fitBounds(bounds);



} /// afficherCarte

/* Fonction qui affiche un marker sur la carte */
function addThisMarker(point, m) {
    if (m === 0) {
        var marker = new google.maps.Marker({position: point, icon: "js/cinemaRecherchee.png"});
        return marker;

    } else {
        var marker = new google.maps.Marker({position: point, icon: "js/autresCinemas.png"});
        return marker;

    }
}

// -------------------------------------------------------------------------------------------------------------------------------------
$(document).ready(init);// au chargement de la page, on demarre la fonction init