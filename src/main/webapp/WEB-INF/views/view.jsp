<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Recored</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.min.css">
<link
	rel="https://cdnjs.datatables/1.12.1/css/dataTables.bootstrap4.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script
	src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/1.12.1/js/dataTables.bootstrap4.min.js"></script>
	
	<!-- soumya link used foe tab bar below two link -->
	<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
 
	
</head>
<body>

 

<div class="display-4" align="center">Register Details</div>
<div class="container border color bg-success ">
		<div class="height:10%"></div>
             <div class="row mt-5 "  align="center">
			<div class="col-md-3">
			<form action="./data" >
				<label class="text-secondary text-warning">CableName:</label><span
						class="text-danger">*</span>
				<select name="cableId"  id="cableId" class="form-controller">
					<option value="0">-SELECT-</option>
					<c:forEach items="${cableList }" var="cable">
						<option value="${cable.cableId }">${cable.cableName }</option>
					</c:forEach>
					
				</select>
				</div>
				<div class="col-md-1">
				  <button class="btn-success float-left mr-0">Search</button>
				  </div>
				  
                   </form>

			

			
			
			
			<div class="col-md-3">
			 <form action="./data1" >
				<label class="text-secondary text-warning">DistName:</label><span
						class="text-danger">*</span>
				<select name="distId"  id="distId">
					<option value="0">-SELECT-</option>
					<c:forEach items="${distList }" var="dist">
						<option value="${dist.distId }">${dist.distName }</option>
					</c:forEach>
				</select>
				</div>
				<div class="col-md-1">
			  <button class="btn-success float-left mr-0">Search</button>
			  </div>
			</div>
			</div>
			
				
	</form>					
				
		
	

<!-- <div  class="container mt-5 text-danger"> -->

		
		<div class=" bg-light clearfix ">
			<button value="add" class="btn-warning float-left mr-2"><a href="./test">ADD</a></button>
			&nbsp;&nbsp;
			<button value="view" class="btn-danger float-left" >VIEW</a></button>
		</div>
		
		<table border="1" class ="table table-striped" id="dateTableId">
			<thead>
				<tr>
					<th>SL#</th>
					<th>Name</th>
					<th>Email</th>
					<th>Address</th>
					<th>MobileNo</th>
					<th>Image</th>
					<th>Gender</th>
					<th>Pincode</th>
					<th>Dist</th>
					<th>Block</th>
					<th>Village</th>
					<th>CableName</th>
					<th>TotalCable</th>
					<th>TotalPrice</th>
					
					
					
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${dataList }" var="data" varStatus="count">
					<tr>
						<td>${count.count }</td>
						<td>${data.rName }</td>
						<td>${data.emailId }</td>
						<td>${data.address }</td>
						<td>${data.mobileNo }</td>
						<td>${data.pic }</td>
						<td>${data.gender }</td>
						<td>${data.pincode }</td>
						<td>${data.dist.distName }</td>
						<td>${data.block.blockName }</td>
						<td>${data.village.villageName }</td>
						<td>${data.cable.cableName }</td>
						<td>${data.cable.totalCable }</td>
						<td>${data.cable.cablePrice }</td>
						

					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>






<script type="text/javascript">
$(document).ready(function (){
	$('#dateTableId').DataTable();
});
</script>




</table>
</body>
</html>