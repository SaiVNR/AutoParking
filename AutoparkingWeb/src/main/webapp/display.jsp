<!DOCTYPE html>
<%@ page trimDirectiveWhitespaces="true" %>
<html lang="en">
<head>
    <title>Login V1</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->  
    <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->  
    <link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="css/util.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->
</head>
<body>
    <div class="limiter">      
        <div class="container-login100">
            <div class="wrap-login100">
                    <span class="login100-form-title">
                            Auto Parking Application
                        </span>
               
	                <form action="" method="post" class="login100-form validate-form">
	                    <span class="login100-form-title">
	                        Lobby Details 
	                    </span>
	                    <table class="table table-bordered">
	                    <tr>
	                    
	                    <th> Slot Number</th>
	                    <th>Car Number</th>
	                    <%
	                    java.util.Map<String,Integer> parkedCarDetails = com.epam.teja.parking_operations.ParkingOperations.getCarsInParkingArea();
	                    java.util.TreeMap<Integer,String> details = new java.util.TreeMap<Integer,String>();
	                    for(java.util.Map.Entry<String,Integer> entry:parkedCarDetails.entrySet()){                        
                            details.put(entry.getValue()+1,entry.getKey());
	                    }
	                    out.println("Total cars in Lobby "+parkedCarDetails.size());
	                    for(java.util.Map.Entry<Integer,String> entry:details.entrySet()){
	                        %><tr>
	                        
	                        <td><% out.println(entry.getKey()); %></td>
	                        <td><% out.println(entry.getValue()); %></td>
	                        
	                        </tr>
	                        <%
	                    }
	                    %>
	                    </tr>
	                    </table>
	                    <div class="container-login100-form-btn">
	                        <button class="login100-form-btn">
	                            Go Back..
	                        </button>
	                    </div>
	                </form>
              
            </div>
        </div>
    </div>
    
    

    
<!--===============================================================================================-->  
    <script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
    <script src="vendor/bootstrap/js/popper.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
    <script src="vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
    <script src="vendor/tilt/tilt.jquery.min.js"></script>
    <script >
        $('.js-tilt').tilt({
            scale: 1.1
        })
    </script>
<!--===============================================================================================-->
    <script src="js/main.js"></script>

</body>
</html>