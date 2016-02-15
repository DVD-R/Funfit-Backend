// *
// * Add multiple markers
// * 2013 - en.marnoto.com
// *

// necessary variables
var map;
var infoWindow;
var currentLat;
var currentLong;
// markersData variable stores the information necessary to each marker
var markersData = [
{
	"id": 3,
	"lat": 10.299608,
	"lng": 123.869377,
	"name": "Gaisano Capital Tisa, Cebu City, Central Visayas, Philippines",
	"lvl": 1,
	"cluster_name": "impulse",
	"faction": 0
	},
	{
	"id": 4,
	"lat": 10.289796,
	"lng": 123.861659,
	"name": "University of San Jose Recoletos - Basak, Cebu City, Central Visayas, Philippines",
	"lvl": 0,
	"cluster_name": null,
	"faction": 0
	},
	{
	"id": 5,
	"lat": 10.294097,
	"lng": 123.897456,
	"name": "University of San Jose-Recoletos, Magallanes Street, Cebu City, Central Visayas, Philippines",
	"lvl": 3,
	"cluster_name": "velocity",
	"faction": 0
	},
	{
	"id": 6,
	"lat": 10.312727,
	"lng": 123.892729,
	"name": "Fuente Oro, Gov. M. Roa Street, Cebu City, Philippines",
	"lvl": 1,
	"cluster_name": "velocity",
	"faction": 0
	},
	{
	"id": 7,
	"lat": 10.290056,
	"lng": 123.870978,
	"name": "McDonald's, Basak San Nicolas, Cebu City, Central Visayas, Philippines",
	"lvl": 1,
	"cluster_name": "impulse",
	"faction": 1
	},
	{
	"id": 8,
	"lat": 10.289016,
	"lng": 123.867826,
	"name": "Julies Bakeshop, Basak San Nicolas, Cebu City, Central Visayas, Philippines",
	"lvl": 2,
	"cluster_name": "velocity",
	"faction": 1
	}// don't insert comma in the last item
];



function initialize() {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(showPosition);
    }
}
google.maps.event.addDomListener(window, 'load', initialize);

function showPosition(position) {
   currentLong = position.coords.longitude;
   currentLat = position.coords.latitude;

   var mapOptions = {
      center: new google.maps.LatLng(currentLat,currentLong),
      zoom: 9,
      mapTypeId: 'roadmap',
   };

   map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);

   // a new Info Window is created
   infoWindow = new google.maps.InfoWindow();

   // Event that closes the Info Window with a click on the map
   google.maps.event.addListener(map, 'click', function() {
      infoWindow.close();
   });

   // Finally displayMarkers() function is called to begin the markers creation
   displayMarkers();

}


// This function will iterate over markersData array
// creating markers with createMarker function
function displayMarkers(){

   // this variable sets the map bounds according to markers position
   var bounds = new google.maps.LatLngBounds();
   
   // for loop traverses markersData array calling createMarker function for each marker 
   for (var i = 0; i < markersData.length; i++){

      var latlng = new google.maps.LatLng(markersData[i].lat, markersData[i].lng);
      var name = markersData[i].name;
      var lvl = markersData[i].lvl;
      var cluster_name = markersData[i].cluster_name;
      var postalCode = markersData[i].postalCode;

      createMarker(latlng, name, lvl, cluster_name, postalCode);

      // marker position is added to bounds variable
      bounds.extend(latlng);  
   }

   // Finally the bounds variable is used to set the map bounds
   // with fitBounds() function
   map.fitBounds(bounds);
}

// This function creates each marker and it sets their Info Window content
function createMarker(latlng, name, address1, address2){
   var marker = new google.maps.Marker({
      map: map,
      position: latlng,
      title: name
   });

   // This event expects a click on a marker
   // When this event is fired the Info Window content is created
   // and the Info Window is opened.
   google.maps.event.addListener(marker, 'click', function() {
      
      // Creating the content to be inserted in the infowindow
      var iwContent = '<div id="iw_container">' +
            '<div class="iw_title">' + name + '</div>' +
         '<div class="iw_content">' +'Level: '+ address1 + '<br />' + 'Cluster: '+
         address2 + '<br /></div></div>';
      
      // including content to the Info Window.
      infoWindow.setContent(iwContent);

      // opening the Info Window in the current map and at the current marker location.
      infoWindow.open(map, marker);
   });
}