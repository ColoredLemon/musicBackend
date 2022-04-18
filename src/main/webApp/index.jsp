<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" lang="en">
<head>
	<meta charset="UTF-8">
	<title>MUSIFY Login Page</title>
	<link rel="stylesheet" href="/style/styles.css">
	<script
  src="https://code.jquery.com/jquery-2.2.4.js"
  integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
  crossorigin="anonymous"></script>
</head>
<body>

<div class="wrapper unauthenticated">
	<div class="header">
		<div class="top">
			<div class="logo">
				<img src="/images/Musify.png" style="width: 275px;">
			</div>
			<div class="form">
				<div class="input_field">
					<input type="text" placeholder="Phone number/Username/Email" class="input">
				</div>
				<div class="input_field">
					<input type="password" placeholder="Password" class="input">
				</div>
				<div class="btn"><a href="#">Log In</a></div>
			</div>
			<div class="or">
				<div class="line"></div>
				<p>OR</p>
				<div class="line"></div>
			</div>
			<div class="dif">
				<div class="login">
					<img src="/images/facebook.png">
					<p><a href="/login">Log in with Facebook</a></p>
					
				</div>
				<div class="forgot">
					<a href="#">Forgot password?</a>
				</div>
			</div>
		</div>
		<div class="signup">
			<p>Don't have an account? <a href="#">Sign up</a></p>
		</div>
		<!-- <div class="apps">
			<p>Get the app.</p>
			<div class="icons">
				<a href="#"><img src="appstore.png" alt="appstore"></a>
				<a href="#"><img src="googleplay.png" alt="googleplay"></a>
			</div>
		</div> -->
	</div>
	<div class="footer">
		<!-- <div class="links">
			<ul>
				<li><a href="#">ABOUT US</a></li>
				<li><a href="#">SUPPORT</a></li>
				<li><a href="#">PRESS</a></li>
				<li><a href="#">API</a></li>
				<li><a href="#">JOBS</a></li>
				<li><a href="#">PRIVACY</a></li>
				<li><a href="#">TERMS</a></li>
				<li><a href="#">DIRECTORY</a></li>
				<li><a href="#">PROFILES</a></li>
				<li><a href="#">HASHTAGS</a></li>
				<li><a href="#">LANGUAGE</a></li>
			</ul>
		</div> -->
		<div class="copyright">
			© 2022 MUSIFY
		</div>
	</div>
</div>
<div  class = "authenticated">
<h1 id = "user"></h1>
</div>
</body>

<script type="text/javascript">
    $.get("/user", function(data) {
        
      $(".unauthenticated").hide()
        $(".authenticated").show() 
        $.get("/user/registerMember?name="+data.userAuthentication.details.name +"&email="+data.userAuthentication.details.email, function(res){
        	console.log(res);
        	$("#user").html(res);
        })
    });
    
   

</script>

</html>