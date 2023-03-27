<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>RegistrationForm_v1 by Colorlib</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		
		<!-- MATERIAL DESIGN ICONIC FONT -->
		<link rel="stylesheet" href="<%=request.getContextPath()%>/register.fonts/material-design-iconic-font/css/material-design-iconic-font.min.css">

		<!-- STYLE CSS -->
		<link rel="stylesheet" href="<%=request.getContextPath()%>/register.css/style.css">
	</head>

	<body>

		<div class="wrapper" style="background-image: url('<%=request.getContextPath()%>/register.images/bg-registration-form-1.jpg');">
			<div class="inner">
				<div class="image-holder">
					<img src="<%=request.getContextPath()%>/img/dong-ho-deo-tay-cho-soai-ca-2.webp" alt="">
				</div>
				<form action="<%=request.getContextPath()%>/UserServlet" method="post">
					<h3>Registration Form</h3>
					<div class="form-wrapper">
						<input type="text" name="fullname" placeholder="Full Name" class="form-control">
<%--						<input type="text" placeholder="Last Name" class="form-control">--%>
					</div>
					<div class="form-wrapper">
						<input type="text" placeholder="Username" name="username" class="form-control">
						<i class="zmdi zmdi-account"></i>
					</div>
					<div class="form-wrapper">
						<input type="password" placeholder="Password" name="password" class="form-control">
						<i class="zmdi zmdi-lock"></i>
					</div>
					<div class="form-wrapper">
						<input type="password" placeholder="Confirm Password" name="confirmPass" class="form-control">
						<i class="zmdi zmdi-lock"></i>
					</div>
					<div class="form-wrapper">
						<input type="date" placeholder="Birthdate" name="birthdate" class="form-control">
						<i class="zmdi zmdi-lock"></i>
					</div>
					<div class="form-wrapper">
						<input type="text" placeholder="Phone" name="phone" class="form-control">
						<%--						<input type="text" placeholder="Last Name" class="form-control">--%>
					</div>
					<div class="form-wrapper">
						<input type="text" placeholder="Email Address" name="email" class="form-control">
						<i class="zmdi zmdi-email"></i>
					</div>
					<div class="form-wrapper">
						<input type="text" placeholder="Address" name="address" class="form-control">
						<i class="zmdi zmdi-email"></i>
					</div>
<%--					<div class="form-wrapper">--%>
<%--						<select name="sex" id="sex" class="form-control">--%>
<%--							<option value="" disabled selected>Address</option>--%>
<%--							<option value="male">Male</option>--%>
<%--							<option value="femal">Female</option>--%>
<%--							<option value="other">Other</option>--%>
<%--						</select>--%>
<%--						<i class="zmdi zmdi-caret-down" style="font-size: 17px"></i>--%>
<%--					</div>--%>
                        <input class="zmdi zmdi-arrow-right" type="submit" name="action" value="Register"/>
<%--					<button><a href="indexadmin.jsp" rel="">Register</a>--%>
<%--						<i class="zmdi zmdi-arrow-right"></i>--%>
<%--					</button>--%>
				</form>
			</div>
		</div>
		
	</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>