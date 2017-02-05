<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error Page</title>
<!--Import jQuery before materialize.js-->
<script type="text/javascript" src="/resources/common/js/jquery-2.1.1.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<style type="text/css">
* {
	box-sizing: border-box;
}

body {
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	background-color: #fff;
	overflow-x: hidden;
	font-family: Maven Pro;
}

section {
	width: 100vw;
	max-width: 500px;
	height: 100vh;
	max-height: 700px;
	background-color: #444;
	text-align: center;
	font-size: 20px;
	padding: 25px;
	color: #eee;
}

.glitch {
	position: absolute;
	top: 0;
	left: 0;
	right: 0;
	bottom: 0;
	margin: auto;
	z-index: -1;
	width: 100vw;
	max-width: 500px;
	height: 100vh;
	max-height: 700px;
}

.glitch:not (.f0f ) {
	animation: glitchfader 2s infinite;
}

.glitch.f0f {
	opacity: 0.3;
	max-height: 689px;
}

.fa-exclamation-triangle {
	font-size: 80px;
	margin-top: 25px;
	margin-bottom: 25px;
}

.main {
	font-size: 50px;
	margin-bottom: 5px;
}

hr {
	margin: 20px;
	border: none;
	height: 1px;
	background-color: #bbb;
}

.code {
	font-size: 25px;
}

.learn {
	text-decoration: none;
	background-color: #eee;
	color: #444;
	display: inline-block;
	width: 90%;
	max-width: 150px;
	height: 50px;
	line-height: 45px;
	margin-top: 20px;
	margin-bottom: 30px;
	border: transparent 1px solid;
	font-size: 1em;
	transition: border-color 0s 0.05s, color 0.05s 0.1s;
}

.learn:hover {
	font-size: 1.1em;
	color: #eee;
	background-color: transparent;
	border-color: #eee;
}

a {
	color: #eee;
	display: inline-block;
	margin-top: 8px;
	margin-bottom: 8px;
	padding: 2px;
	text-decoration: none;
	font-size: 25px;
	border-bottom: transparent 1px solid;
	transition: border-color 0.05s;
}

a:hover {
	border-color: #ccc;
}

.countdown {
	margin-bottom: 20px;
	display: inline-block;
	width: 85%;
}

@media screen and (max-width: 400px) {
	section {
		min-height: 100vh;
	}
}

@
-moz-keyframes glitchfader { 50% {
	opacity: 0.2;
}

}
@
-webkit-keyframes glitchfader { 50% {
	opacity: 0.2;
}

}
@
-o-keyframes glitchfader { 50% {
	opacity: 0.2;
}

}
@
keyframes glitchfader { 50% {
	opacity: 0.2;
}
}
</style>
</head>
<body>
	<div class="glitch"></div>
	<div class="glitch f0f"></div>

	<section> <i class="fa fa-exclamation-triangle"></i>
	<div>
		<div class="main">Internal Server Error</div>
	</div>
	<hr />
	<div class="code">
		Response code <b>500</b>
	</div>
	<a href="#" class="learn">Read more</a>
	<div class="countdown">
		Your browser will return to the previous page in <span class="count">15</span>
		seconds. You can also:
	</div>
	<a href="#" onclick="history.back(-1)"><i class="fa fa-reply"></i>Return now</a> <br />
	<a href="/"><i class="fa fa-home"></i>
		Return to home page</a> </section>

	<script type="text/javascript">

		var i = 15;
		setInterval(
			function() {
				if (i > 0) {
					i--;
					$(".count").text(i);
				} else {
					//here would be
					history.back(-1);
					// $(".countdown").text("Or not. That would be annoying on Codepen, wouldn't it? You can also:");
				}
			}, 1000);
	</script>
</body>
</html>