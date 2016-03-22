<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<title>LoginForm</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>


	<div class="container" style="width:300px;">
		<div class="row">
			<form class="form-signin mg-btm" action="/login" method="POST">
	    	<h3 class="heading-desc">
			Login</h3>
	
			<div class="main">	
	            <label>Username</label>    
	            <div class="input-group">
	                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
	            	<input type="text" class="form-control" name="username" placeholder="" autofocus>
	            </div>
	            <label>Password</label>
	            <div class="input-group">
	                <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
	                <input type="password" class="form-control" name="password" placeholder="">
	            </div>
	    
	        	<div class="row">
	                <div class="col-xs-6 col-md-6">
	                     
	                </div>
	                <div class="col-xs-6 col-md-6 pull-right">
	                    <button type="submit" class="btn btn-large btn-success pull-right">Submit</button>
	                </div>
	                <input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
	            </div>
			</div>
	      </form>
		</div>
	</div>
 	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>	
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	
</body>
</html>