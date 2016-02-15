<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<!--
	Ion by TEMPLATED
	templated.co @templatedco
	Released for free under the Creative Commons Attribution 3.0 license (templated.co/license)
-->

<html>
	<head>
		<title>Funfit</title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<!--[if lte IE 8]><script src="js/html5shiv.js"></script><![endif]-->
		<script src="js/jquery.min.js"></script>
		<script src="js/skel.min.js"></script>
		<script src="js/skel-layers.min.js"></script>
		<script src="js/init.js"></script>
		<script src="js/bootstrap-datepicker.js"></script>
		<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
		<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
		<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
		<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?v=3&libraries=places"></script>
		
		<noscript>
			<link rel="stylesheet" href="css/skel.css" />
			<link rel="stylesheet" href="css/style.css" />
			<link rel="stylesheet" href="css/style-xlarge.css" />
		</noscript>
		<link rel="stylesheet" href="css/event.css" />
		<link rel="stylesheet" href="css/datepicker.css" />
		<link rel="stylesheet" href="css/bootstrap.css" />
	</head>
	<body id="top">

	<script>
	function bindAutocomplete() {
		  var acService = new google.maps.places.AutocompleteService(),
		    placesService = new google.maps.places.PlacesService(document.createElement('div'));
		  var defaultBounds = new google.maps.LatLngBounds(
				  new google.maps.LatLng(10.4690427,122.5892202));
		  
		  
		  $("input#location").autocomplete({
		    source: function(req, resp) {

		      acService.getPlacePredictions({
		        input: req.term,
		        bounds: defaultBounds,
		        types:['establishment']
		      }, function(places, status) {
		        if (status === google.maps.places.PlacesServiceStatus.OK) {
		          var _places = [];
		          for (var i = 0; i < places.length; ++i) {
		            _places.push({
		              id: places[i].place_id,
		              value: places[i].description,
		              label: places[i].description
		            });
		          }
		          resp(_places);
		        }
		      });
		    },
		    select: function(e, o) {
		      placesService.getDetails({
		        placeId: o.item.id
		      }, function(place, status) {
		        if (status === google.maps.places.PlacesServiceStatus.OK) {
				  var coordinatesRaw = place.geometry.location.toUrlValue();
				  var coordinates = coordinatesRaw.split(",");
		          document.getElementById("latitude").value = coordinates[0];
		          document.getElementById("longitude").value = coordinates[1];
		        }
		      });


		    }
		  });
		}
		$(window).load(bindAutocomplete);
	</script>

	<script>
	function createEvents(){
		var eventName = $("#eventName").val();
		var locationName = $("#location").val();
		var latitude = $("#latitude").val();
		var longitude = $("#longitude").val();
		var eventDate = $("#eventDate").val();
		var promotionalImage = $("#promotionalImage").val();
		alert("test");
		$.ajax({
			type:"GET",
			url:"http://localhost:8081/funfit-backend/createEvent",
			data:"eventName="+eventName+"&locationName=" +locationName+ "&latitude=" +latitude+ "&longitude=" +longitude+ "&eventDate=" +eventDate+"&promotionalImage="+promotionalImage
		});
	
	}
	</script>

		<!-- Header -->
			<header id="header" class="skel-layers-fixed">
				<h1><a href="dashboard.html"><img id="logo-header" src="images/funfit_header.png"/></a></h1>
				<nav id="nav">
					<ul>
						<li><a href="dashboard.html">Dashboard</a></li>
						<li><a href="events.html">Create Event</a></li>
							<li><a href="marker">Create Marker</a></li>
						<li><a href="index.html" class="button special">Log Out</a></li>
					</ul>
				</nav>
			</header>

						<!-- Two -->
							<section id="two" class="wrapper style2">
								<div class="container">
									<div class="row">
										<div class="6u">
											<section class="special">
												<img class="image fit" src="images/pic02.jpg" alt="" />
											</section>
										</div>
										<div class="6u">
											<section class="special">
												<div class="9u">
												<h1 class="login-head">Create Event</h1>
												<input type="text" placeholder="Event Name" id="eventName">
												<input type="text" placeholder="Location" id="location">
												<input type="text" placeholder="Latitude" id = "latitude" disabled>
												<input type="text" placeholder="Longitude" id = "longitude"  disabled>
												<input type="text" placeholder="Event Date" id="eventDate">
												<input type="text" placeholder="Promotional Image" id="promotionalImage">

												<ul class="actions">
													<li><input type="button" value="Create" class="button special" onclick="createEvents();"/></li>
													</ul>
											</div>
											</section>
									</div>
								</div>
							</section>

					<!-- Footer -->
						<footer id="footer">
							<div class="container">

								<ul class="copyright">
									<li>&copy; 2016 Funfit All rights reserved.</li>
									<li>Design: <a href="http://templated.co">TEMPLATED</a></li>
								</ul>
							</div>
						</footer>

						<script>
            // When the document is ready
            $(document).ready(function () {

                $('#eventDate').datepicker({
                    format: "dd/mm/yyyy"
                });

            });
        </script>

				</body>
			</html>

