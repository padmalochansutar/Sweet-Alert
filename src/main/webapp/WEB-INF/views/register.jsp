<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RegisterAndViewPage</title>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.12.1/css/datatables.bootsrap4.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script
	src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.8.0/js/bootstrap-datepicker.min.js"></script>
	<!-- swal Link -->
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</head>
<body>

<c:if test="${messag ne null}">
   <div class="alert alert-success">
<script>
   Swal.fire({
     title: 'Failed!',
     text: 'All fields are manadatory.',
     icon: 'Failed',
     confirmButtonText: 'OK'
   })
 </script>
   </div>
</c:if>

<c:if test="${message  ne null}">
   <div class="alert alert-success">
<script>
   Swal.fire({
     title: 'Failed!',
     text: 'Upload photo',
     icon: 'Failed',
     confirmButtonText: 'OK'
   })
 </script>
   </div>
</c:if>

<c:if test="${res ne null}">
   <div class="alert alert-success">
<script>
   Swal.fire({
     title: 'Failed!',
     text: 'Already number is register',
     icon: 'Failed',
     confirmButtonText: 'OK'
   })
 </script>
   </div>
</c:if>
<c:if test="${ema ne null}">
   <div class="alert alert-success">
<script>
   Swal.fire({
     title: 'Failed!',
     text: 'Already emailId is register',
     icon: 'Failed',
     confirmButtonText: 'OK'
   })
 </script>
   </div>
</c:if>

<c:if test="${data ne null}">
   <div class="alert alert-success">
<script>
   Swal.fire({
     title: 'sucess!',
     text: ' registered sucessfully ',
     icon: 'success',
     confirmButtonText: 'OK'
   })
 </script>
   </div>
</c:if>

<c:if test="${failed eq 1}">
   <div class="alert alert-success">
<script>
   Swal.fire({
     title: 'failed!',
     text: ' registered failed',
     icon: 'failed',
     confirmButtonText: 'OK'
   })
 </script>
   </div>
</c:if>

	<div class="container   mt-0">
		<h1 align="center" class="display-4">CABLE REGISTER FORM</h1>

		<div class=" bg-light clearfix ">
			<button value="add" class="btn-warning float-left mr-2">ADD</button>
			&nbsp;&nbsp;
			<button value="view" class="btn-danger float-left" ><a href="./allData"  data-bs-toggle="collapse">VIEW</a></button>
			
		</div>

		<div class="card">
			<div class="card-body">
				<form autocomplete="off"   class="form-group" action="./saveData" method="POST" onsubmit="return valiatedForm()"
					onsubmit="return message()"	 enctype="multipart/form-data"  >
				 
					<div class="row text-danger"  >
						<div class="col-sm-4">
							<label>USER NAME: <span class="text-danger">*</span></label> <input
								type="text" name="name" id="nameId" 
								class="form-control" >
						</div>
						<div class="col-sm-4">
							<label> MOBILE NUMBER:(+91)<span class="text-danger">*</span></label>
							<input type="text" name="number" id="numberId"
								class="form-control" autocomplete="chrome-off">

						</div>
						<div class="col-sm-4">
							<label>EMAILID:<span class="text-danger">*</span></label> <input
								type="email" name="email" id="emailId" class="form-control"
								autocomplete="chrome-off" />
						</div>
					</div>
					<div class="row text-danger mt-5">
						<div class="col-sm-4">
							<label> GENDER:<span class="text-danger">*</span></label> <br>
							<input type="radio" name="gender" value="male" id="maleId">&nbsp;MALE&nbsp;<input
								type="radio" name="gender" value="female" id="maleId">&nbsp;FEMALE&nbsp;<input
								type="radio" name="gender" value="female" id="maleId">&nbsp;OTHER
						</div>
						<div class="col-sm-4">
							<label>DOB:<span class="text-danger">*</span></label> <input
								type="date" name="dob" id="dateId"
								class="form-control " >
						</div>
						<div class="col-sm-4">
							<label>UPLOAD PIC:<span class="text-danger">*</span></label> <input
								type="file" name="pic" id="picId">
								<h4 class="text-secondary text-danger"></h4>
						</div>
					</div>

					<div class="row text-danger mt-8">
						<div class="col-sm-4">
							<label class="text-secondary text-danger">DIST:</label><span
								class="text-danger">*</span><br> <select name="distId"
								onchange="return dist()" id="distId">
								<option value="0">-SELECT-</option>
								<c:forEach items="${distList }" var="dist">
									<option value="${dist.distId }">${dist.distName }</option>
								</c:forEach>
							</select>
						</div>
						<div class="col-sm-4">
							<label class="text-secondary text-danger">BLOCK:<span
								class="text-danger">*</span></label><br> <select name="blockId"
								onchange="return village()" id="blockData">
								<option value="0">-select-</option>

							</select>

						</div>


						<div class="col-sm-4">
							<label class="text-secondary text-danger">VILLAGE:<span
								class="text-danger">*</span></label><br> <select name="villageId" id="villageData"
								autocomplete="off">
								<option value="0">-select-</option>

							</select>

						</div>
             </div>
			<div class="row text-danger mt-5">
			<div class="col-sm-4">
							<label class="text-secondary text-danger">CABLE:</label><span
								class="text-danger">*</span><br> <select name="cableId"
								id="distId">
								<option value="0">-SELECT-</option>
								<c:forEach items="${cableList }" var="cable">
									<option value="${cable.cableId }">${cable.cableName }</option>
								</c:forEach>
							</select>
						</div>
				<div class="col-sm-4">
					<label for="address">ADDRESS:<span class="text-danger">*</span></label>
					<textarea rows="3" cols="40" name="address" id="addressId" autocomplete="chrome-off"></textarea>

				</div>
				
                <div class="col-sm-4">
					<label for="address">PINCODE:<span class="text-danger">*</span></label>
					<input type="text" name="pin" id="pinId" autocomplete="chrome-off"
								class="form-control">

				</div>
			
				
			</div>

			<div style="text-align: center">
				<input type="submit" value="REGISTER" class="btn-success" onclick="return confirm('Are you sure?')" >&nbsp;&nbsp;<input
					type="reset" value="RESET" class="btn-danger">
			</div>
		</div>

		</form>


		<script type="text/javascript">
			function dist() {
				var dist = $("#distId").val();
				alert("Click on OK Access Block!");

				$.ajax({
					type : "GET",
					url : "./getDistId",
					data : "distBlock=" + dist,

					success : function(response) {

						$("#blockData").html(response)

					}

				});
			}

			function village() {
				var block = $("#blockData").val();
                  alert("Click on OK Access village!")
				$.ajax({
					type : "GET",
					url : "./getBlockId",
					data : "blockVillage=" + block,

					success : function(response) {

						$("#villageData").html(response)

					}

				});
			}
		</script>
		<script type="text/javascript">
		$(function() {
			$('.datepicker').datepicker({
				format : 'dd-mm-yyyy'
			});

		});
	</script>
		
         <script type="text/javascript">
          function valiatedForm() {

		let n = document.getElementById("nameId").value;
		let letters = /[^A-Za-z]+$/;
		let upper = /^[A-Z]/;
		let num=document.getElementById("numberId").value;
		let dob = $('#dateId').val();
		
		var phoneno =  /^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/;
		var email=document.getElementById("emailId").value;

        var regs=/^[a-zA-Z0-9.!#$%&'+\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)$/;
        let pin = document.getElementById("pinId").value;
        
        let address = document.getElementById("addressId").value;
        
		 if (letters.test(n)) {
				alert("Give Only Alphabet");
				return false;
			}
		 else if (n == "") {
				alert("Please Give Your  Name");
				return false;
			} 
		 else if (n[0].toUpperCase() != n[0]) {
				//alert("sucessful name");
				 alert("Give the first letter user name capital");
				return false;
			}
		 else if(n.length < 3 || n.length > 20 ){
		        alert("Give Name Between 3-20 character");
		        return false;
		    }
		 if (num==""){
				alert("mobileNumber not blank");
				return false;
			}
		 else  if ( num.length != 10) {
			  alert("give 10 digit number only");
			  return false;
			  }
		 else if(!(num.match(phoneno))){
			 alert("check your mobile number");
			 return false
             
			 }
		 if(!(regs.test(email))){
              alert("Give Correct Email ID");
              return false;
			 }
		 else if(email[0].toLowerCase()!=email[0]){
                  alert("Give character as Small letter");
                  return false;
			 }
		 if (address==""){
             alert("Give Your address !");
             return false;
			 }
		 else if(address.length < 5 || address.length > 200){
			 swal("Give address between 5-200 character !! ");
			 return false;
                  
			 }
		 if (!(pin=="" || pin.length ==6)){
              alert("Give 6 digit pincode number!!");
              return false;
			 }

		
		 if(new Date() <= new Date(dob)){
				alert("Date Of Birth Must Not Be Greater!");
				return false;
			}

		
	    
      return true;
         } 


        
        </script>
        
        <script type="text/javascript">
         function confirm(){
        	 
        	
             }
        
    </script>
</body>





</html>