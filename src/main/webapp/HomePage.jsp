<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
	<link href="style.css" rel="stylesheet">
</head>
<body>
	<header>
		<h1>Welcome 
			<label id="name">ee </label>
			<input type="hidden" id="jsonData" value='<%= request.getAttribute("jsonData") %>'>
		</h1>
	</header>
	 
	<div class="container">
		<form action="update" method="GET">
		
			<label for="editname">Name:</label>
	        <input type="text" id="editname" name="name" required>
	        
	        <label for="editemail">Email:</label>
	        <input type="email" id="editemail" name="email" required>
	        
	        <label for="editdob">Date Of Birth: </label>
	        <input type="date" id="editdob" name="dob" required>
	        
	        <label for="editmob"> Mobile Number: </label>
	        <input type="tel" id="editmob" name="mob" required>
	     
	        <label for="editpass">Password: </label>
	        <input type="password" id="editpass" name="password" required>
	     
	        <input type="submit" value="Update profile" >
	        <script src="script.js"></script> 
	     </form>
   </div>
</body>
</html>