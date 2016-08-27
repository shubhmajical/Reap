<%@page import="java.util.ArrayList"%>
<%@page import="com.ttnd.reap.pojo.EarningKitty"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>REAP</title>
<!--
	<script type="text/javascript">
    $(document).ready(function () {
        var url = window.location;
        $('ul.nav a[href="'+ url +'"]').addClass('active');

    });


</script> 
<style>
.active{
background-color:#505b72;
}
</style>
-->
<style>
.karmareason {
	border: solid 1px #e5e5e5;
	border-radius: 0;
	padding: 10px 15px;
	height: auto;
	margin: 0;
	overflow-x: hidden;
	overflow-y: auto;
	float: left;
	width: 100%;
	height: 150px !important;
}
</style>

<style>
.no-js #loader {
	display: none;
}

.js #loader {
	display: block;
	position: absolute;
	left: 100px;
	top: 0;
}

.se-pre-con {
	position: fixed;
	left: 0px;
	top: 0px;
	width: 100%;
	height: 100%;
	z-index: 9999;
	background: url(/Reap/resources/img/preloader.gif) center no-repeat #fff;
}
</style>

<!--
<script>
function toggleSelect(selectbox){ 
 if(selectbox.size>1){
  selectbox.size=1;
  selectbox.style.position='static';
 }else{
  selectbox.size = selectbox.options.length;
  selectbox.style.position='absolute';
  selectbox.style.height='auto';
 }
}
</script>

-->
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.2/modernizr.js"></script>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="shortcut icon" href="/Reap/resources/img/favicon.ico"
	type="image/x-icon" />
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet"
	href="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.5.4/bootstrap-select.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>


<script type="text/javascript"
	src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"> </script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />


<script>
        $(document).ready(function() {
            $(function() {
                $("#selectNewer").autocomplete({
                    source: function(request, response) {
                        $.ajax({
                            url: "${pageContext.request.contextPath}/getEmployees",
                            type: "GET",
                    
                            data: { term: request.term },

                            dataType: "json",

                            success: function(data) {
                            	response($.map(data, function(v,i){
                  
                            		
                            	    return {
                            	                label: v.employeeId +":" +"     		   " +v.employeeName,
                            	                value: v.employeeId +":" + "      		   " + v.employeeName
                            	                
                            	                	
                            	                
                            	               };
                            	}));
                            }
                       });              
                    }   
                });
            });
        });
        </script>

<script>	
		   
   $(document).ready(function()
{
	$('select[name="changeRole"]').change(function () {
	var newer = $('input[name="selectNewer"]').val().split(":");
	var test= newer[0];
    $("#user").val(test); 

	});
});
        
	</script>

</head>



<script>
						
							$(window).load(function() {
		// Animate loader off screen
		$(".se-pre-con").fadeOut("slow");;
	});</script>
<body>
	<div class="wraper">
		<nav class="navbar navbar" style="padding-top:7px">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#reapnavbar" style="border: 1px solid black">
				<span class="icon-bar" style="background-color: #000 !important"></span>
				<span class="icon-bar" style="background-color: #000 !important"></span>
				<span class="icon-bar" style="background-color: #000 !important"></span>
			</button>
			<a class="navbar-brand" href="#" style="padding: 7px"> <a
				href="#"> <img src="/Reap/resources/img/reap.png" />
			</a> <a href="#" class="hidden-sm hidden-xs" style="padding-left: 15px">
					<img src="/Reap/resources/img/reap2.png" />
			</a>
			</a>
		</div>
		<div class="collapse navbar-collapse" id="reapnavbar">
			<ul class="nav navbar-nav navbar-right"
				style="font-size: 18px; color: #000">
				<li class="buttons"><a href="#"> <img
						src="/Reap/resources/img/ico-dashboard.png" /> Dashboard

				</a></li>
				<li class="buttons"><a href="#" data-toggle="modal"
					data-target="#myModal" data-keyboard="false"> <img
						src="/Reap/resources/img/ico-badge.png" />${employee.getEmployee().getEmployeeName()}
				</a>
			</ul>
			</li>
			</ul>
		</div>
		</nav>
	</div>

	<div class="modal" id="myModal" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">More About
						${employee.getEmployee().getEmployeeName()}</h4>
				</div>
				<div class="modal-body">
					<center>
						<img src="data:image/jpg;base64,<c:out value='${employee.getEmployee().getProfilePic()}'/>" name="aboutme"
							width="190" height="190" border="0" class="img-rounded">
					</center>
					<br />
					<div class="row">
						<div class="col-md-12">
							<div class="col-md-4">
								<p>
									Newer Name <span style="float: right">:</span>
								</p>
							</div>
							<div class="col-md-8">
								<p>
									<strong> ${employee.getEmployee().getEmployeeName()} </strong>
								</p>
							</div>
						</div>
						<div class="col-lg-12">
							<div class="col-md-4">
								<p>
									Service Line <span style="float: right">:</span>
								</p>
							</div>
							<div class="col-md-8">
								<p>
									<strong> ${employee.getEmployee().getServiceLine()} </strong>
								</p>
							</div>
						</div>
						<div class="col-lg-12">
							<div class="col-md-4">
								<p>
									Practice <span style="float: right">:</span>
								</p>
							</div>
							<div class="col-md-8">
								<p>
									<strong> ${employee.getEmployee().getPractice()} </strong>
								</p>
							</div>
						</div>
						<div class="col-md-12">
							<div class="col-lg-4 col-md-4">
								<p>
									Email-ID <span style="float: right">:</span>
								</p>
							</div>
							<div class="col-md-8">
								<p>
									<strong>
										${employee.getEmployee().getEmployeeEmailId()} </strong>
								</p>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<!--     <button type="button" class="btn btn-default" data-dismiss="modal"><p><a href="login">Logout</a></button> -->
					<a href="logout">Logout</a>
				</div>
			</div>
		</div>
	</div>
	
	
	<!-- Revoke Karma Model Starts -->
	
		<div class="modal fade" id="revokeKarma" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- Modal Header -->
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span> <span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Revoke Recognition</h4>
				</div>

				<!-- Modal Body -->
				<div class="modal-body">

					<form class="form-horizontal" role="form" action="revokeKarma" method="POST">
						<div class="form-group">
						
							<div class="col-md-5">
								<div class="radio">
									<label for="radios-Male"> 
									<input type="radio" name="karmaReason" id="incorrectName" value="Selected Incorrect Name" checked="checked">
										Selected Incorrect Name
									</label>
								</div>
								<div class="radio">
									<label for="radios-Female"> 
									<input type="radio" name="karmaReason" id="incorrectBadge" value="Selected Incorrect Badge"> 
										
										Selected Incorrect Badge
									</label>
								</div>
								<div class="radio">
									<label for="radios-Female"> 
									<input type="radio" name="karmaReason" id="incorrectKarma" value="Selected Incorrect Karma"> 
										
										Selected Incorrect Karma
									</label>
								</div>
								<div class="radio">
									<label for="radios-Female"> 
									<input type="radio" name="karmaReason" id="incorrectLanguage" value="Inappropriate Language Used"> 
										
										Inappropriate Language Used
									</label>
								</div>
							
								<input type="hidden" name="revokedKarmaId" value="temp" id="revokedKarmaId" ></input>

							</div>
						</div>
						<hr />
						<button type="button" class="btn btn-default" data-dismiss="modal">
							Close</button>
						<input type="submit" value="Submit" class="btn btn-primary"></input>
					</form>

				</div>

				<!-- Modal Footer -->
				<!--             <div class="modal-footer">
                
            </div> -->
			</div>
		</div>
	</div>
	
	
	<!-- Revoke Karma Model Ends -->
	
	

	<div class="content-wrapper">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-9">
					<div class="panel panel-default">
						<a data-toggle="collapse" href="#collapse1">
							<div class="panel-heading"
								style="background: #ea8744; color: #ffffff">

								<img src="/Reap/resources/img/ico-badge.png" />Change User Role
							</div>
						</a>

						<div id="collapse1" class="panel-collapse collapse">
							<div class="panel-body">
								<form:form action="changeUserRole" method="POST"
									modelAttribute="changeUserRole" class="form-group">
									<div class="row">
										<div class="col-md-12">
											<div class="col-md-1"></div>

											<div class="col-md-10" align="center">
												<div class="form-group">
													<input type="text" class="form-control"
														placeholder="Select a Newer" id="selectNewer"
														name="selectNewer" required="required"></input>
													<form:input type="hidden" path="selectnewer" name="user"
														value="user" id="user"></form:input>
												</div>
											</div>
											<div class="col-md-1"></div>
										</div>
									</div>
									<br />
									<div class="row">
										<div class="col-md-3"></div>
										<div class="col-md-6" align="center">
											<div class="form-group">
												<span class="dd"> <form:select class="form-control"
														path="changeRole" id="changeRole" name="changeRole">
														<option value="0">Change User Role</option>
														<option value="User">User</option>
														<option value="SuperVisor">Super Visor</option>
														<option value="PracticeHead">Practice Head</option>
													</form:select>
												</span>
											</div>
										</div>
										<div class="col-md-3"></div>
									</div>
									<br />
									<div class="row">
										<div class="col-md-12" align="center">
											<input type="submit" name="submit" value="Change User Role"
												class="btn btn-default" id="submit"
												style="background: #505B72; color: white" />
										</div>
									</div>
								</form:form>
							</div>
						</div>


						<!-- panel body -->
					</div>
					<!-- panel main -->
					<!--  Wall of Fame Part   isme bhi panel banegaaa-->



					<div class="panel-group">
						<div class="panel panel-default">
							<div class="panel-heading"
								style="background: #8d9fc4; color: #ffffff">
								<div class="row">
									<div class="col-lg-8">
										<img src="/Reap/resources/img/ico-badge.png" /> <strong
											style="font-size: 16px"> &nbsp WALL OF FAME</strong>
									</div>
									<form action="#" method="post">
										<div class="col-md-3">
											<div class="form-group">
												<input type="text" class="form-control" placeholder="Search"
													value="">
											</div>
										</div>
									</form>
								</div>
							</div>
							<!-- End of panel heading  -->
							<div class="panel-body">
								<div class="content">

									<c:forEach var="wallOfFame"
										items="${employee.getWallOfthefamedtao()}">

										<div class="row">
										<input type="hidden" name="karmaId" value="${wallOfFame.getId()}" id="karmaId" ></input>
											<div class="col-md-2" style="padding-top: 10px">
												<center>
													<img src="data:image/jpg;base64,<c:out value='${wallOfFame.getReceiverId().getProfilePic()}'/>" alt="image"
														class="img-rounded" width="50px" height="50px">
												</center>
											</div>
											<div class="col-md-9" style="padding-top: 10px">
												<a href="#"> <strong>${wallOfFame.getReceiverId().getEmployeeName()}</strong>
												</a> has received <img
													src="	<c:choose >
										 
										   <c:when  test="${wallOfFame.getBadgeReceived()=='Gold'}">
										   							/Reap/resources/img/ico-badge-orange.png			</c:when>
										   <c:when test="${wallOfFame.getBadgeReceived()=='Silver'}"  >
														/Reap/resources/img/ico-badge-grey.png</c:when> 						 
										   <c:otherwise >/Reap/resources/img/ico-badge-brown.png
																								</c:otherwise>    				
										</c:choose>"
													title="${wallOfFame.getBadgeReceived()}" alt="Star" /> from <a href="#"> <strong>${wallOfFame.getSenderId().getEmployeeName()}</strong>
												</a> for Karma : ${wallOfFame.getKarma()}

												<div>
													Reason : ${wallOfFame.getReason() } <br> <i
														class="momentDate" data-date="20160617 15:21:13">
														${wallOfFame.getDateTime() } </i>
												</div>
											</div>
											<div class="col=md-1" align="center">
											<a href="#" data-toggle="modal" data-target="#revokeKarma"
												data-keyboard="false"> <img
												src="/Reap/resources/img/delete.png" /></a>
										</div>
										</div>
										<hr />


									</c:forEach>
								</div>
							</div>
							<!-- panel body -->
						</div>
						<!-- panel main -->
					</div>
					<!-- panel group -->
					<!--  end of Wall of fame   -->
				</div>
				<!--col-md-9 -->
				<div class="col-md-3">
					
					
					<div class="tabbable">
						<ul class="nav nav-tabs">
							<li class="active"><a href="#tab1" data-toggle="tab">NEWER
									BOARDS</a></li>
						</ul>
						<div class="tab-content">
							<div class="tab-pane active" id="tab1">
								<c:forEach var="newerlist" items="${employee.getNewerBoard()}">

									<div class="row">
										<div class="col-lg-4" style="padding-top: 10px">
											<center>
												<img src="data:image/jpg;base64,<c:out value='${newerlist.getEmployeeDto().getProfilePic()}'/>" alt="image"
													class="img-rounded" width="50px" height="50px">
											</center>
										</div>
										<div class="col-lg-8" style="padding-top: 10px">
											<center>
												<div class="row">
													<a href="#"> <strong style="font-size: 15px">
															${newerlist.getEmployeeDto().getEmployeeName()}</strong>
													</a>
												</div>
												<div class="row" style="padding-top: 5px">
													<div class="col-xs-4">
														<img class="img-rounded img-responsive"
															src="/Reap/resources/img/ico-badge-orange.png" />
													</div>
													<div class="col-xs-4">
														<img class="img-rounded img-responsive"
															src="/Reap/resources/img/ico-badge-grey.png" />
													</div>
													<div class="col-xs-4">
														<img class="img-rounded img-responsive"
															src="/Reap/resources/img/ico-badge-brown.png" />
													</div>
												</div>
												<div class="row" style="padding-top: 5px">
													<div class="col-xs-4">${newerlist.getGold()}</div>
													<div class="col-xs-4">${newerlist.getSilver()}</div>
													<div class="col-xs-4">${newerlist.getBronze()}</div>
												</div>
											</center>
										</div>
									</div>
									<hr />

								</c:forEach>
					</div>
				</div>
			</div>
			<!-- Main Row End -->
		</div>
		<!-- Container-fluid -->
	</div>
	</div>
	<!-- Content-wrapper -->

</body>
<div class="se-pre-con"></div>
</html>