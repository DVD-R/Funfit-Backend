<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
		<noscript>
			<link rel="stylesheet" href="css/skel.css" />
			<link rel="stylesheet" href="css/style.css" />
			<link rel="stylesheet" href="css/style-xlarge.css" />
		</noscript>
	</head>
	<body id="top">

	<script>
	function passParameter(){
		var username = $('#username').val();
		var password = $('#password').val();
		var confirmPassword = $('#confirmPassword').val();
		var email = $('#email').val();
		
		$.ajax({
			type:"GET",
			url:"http://localhost:8081/funfit-backend/signupTransaction",
			data:"username=" +username+ "&password=" +password+ "&confirmPassword="
			+confirmPassword+ "&email="+email
		});
	}
	</script>



		<!-- Header -->
			<header id="header" class="skel-layers-fixed">
				<h1><a href="index.html"><img id="logo-header" src="images/funfit_header.png"/></a></h1>
				<nav id="nav">
					<ul>
						<li><a href="home">Home</a></li>
						<li><a href="login" class="button special">Login</a></li>
					</ul>
				</nav>
			</header>

			<!-- Two -->
				<section id="two" class="wrapper style2">
					<div class="container">
						<div class="row">
							<div class="6u">
								<section class="special">
									<img class="image fit" src="images/pic01.jpg" alt="" />
								</section>
							</div>
							<div class="6u">
								<section class="special">
									<div class="9u">
									<h1 class="login-head">Sign Up</h1>
									<input id="username" type="text" placeholder="Username">
									<input id="password" type="password" placeholder="Password">
									<input id="confirmPassword" type="password" placeholder="Confirm Password">
									<input id="email" type="email" placeholder="E-mail Address">

									<ul class="actions">
										<li><a href="login" class="button alt">Login</a></li>
										<li><a href ="login"><input type="button" value ="Signup" class="button special" onclick="passParameter();"/></a></li>
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

	</body>
</html>