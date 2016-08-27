<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

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

<title>REAP</title>

<!--	<script type="text/javascript">
    $(document).ready(function () {
        var url = window.location;
        $('ul.nav a[href="'+ url +'"]').parent().addClass('active');
        $('ul.nav a').filter(function() {
             return this.href == url;
        }).parent().addClass('active');
    });


</script> 
<style>
.active{
color:white;
background-color:#505b72;
}
</style>
-->

</head>
</head>

<body>


	<nav class="navbar navbar" style="padding:7px">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#reapnavbar" style="border: 1px solid black">
				<span class="icon-bar" style="background-color: #000 !important"></span>
				<span class="icon-bar" style="background-color: #000 !important"></span>
				<span class="icon-bar" style="background-color: #000 !important"></span>
			</button>
			<a class="navbar-brand" href="#" style="padding: 7px"> <a
				href="#"> <img src="/Reap/resources/img/reap.png" />
			</a> <a href="#" class="hidden-sm hidden-md hidden-xs"
				style="padding-left: 15px"> <img
					src="/Reap/resources/img/reap2.png" />
			</a>
			</a>
		</div>
		<div class="collapse navbar-collapse" id="reapnavbar">
			<ul class="nav navbar-nav navbar-right"
				style="font-size: 18px; color: #000">
				<li class="buttons"><a href="/Reap/index"><img
						src="/Reap/resources/img/ico-dashboard.png" /> Dashboard </a></li>

				<li class="buttons"><a href="#"><img
						src="/Reap/resources/img/ico-badge.png" /> Badges </a></li>
				<li class="buttons"><a href="#" data-toggle="modal"
					data-target="#myModal" data-backdrop="static" data-keyboard="false">
						<img src="/Reap/resources/img/ico-badge.png" />${employee.getEmployeeName()}</a>
			</ul>
			</li>
			</ul>
		</div>
	</div>
	</nav>

	<div class="modal" id="myModal" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">More About
						${employee.getEmployeeName()}</h4>
				</div>
				<div class="modal-body">
					<center>
						<img
							src="data:image/jpg;base64,<c:out value='${employee.getProfilePic()}'/>"
							name="aboutme" width="190" height="190" border="0"
							class="img-rounded">
					</center>
					<br />
					<div class="row">
						<div class="col-md-12">
							<div class="col-lg-4 col-md-4">
								<p>
									Newer Name<span style="float: right">:</span>
								</p>
							</div>


							<div class="col-md-8">
								<p>
									<strong> ${employee.getEmployeeName()} </strong>
								</p>
							</div>
						</div>

						<div class="col-lg-12">
							<div class="col-md-4">
								<p>
									Service Line<span style="float: right">:</span>
								</p>
							</div>


							<div class="col-md-8">
								<p>
									<strong> ${employee.getServiceLine()} </strong>
								</p>
							</div>
						</div>

						<div class="col-lg-12">
							<div class="col-md-4">
								<p>
									Practice<span style="float: right">:</span>
								</p>
							</div>


							<div class="col-md-8">
								<p>
									<strong> ${employee.getPractice()} </strong>
								</p>
							</div>
						</div>

						<div class="col-md-12">
							<div class="col-lg-4 col-md-4">
								<p>
									Email-ID<span style="float: right">:</span>
								</p>
							</div>


							<div class="col-md-8">
								<p>
									<strong> ${employee.getEmployeeEmailId()} </strong>
								</p>
							</div>
						</div>

					</div>
				</div>
				<div class="modal-footer">
					<a href="/Reap/logout">Logout</a>
				</div>
			</div>

		</div>
	</div>

	<div class="content-wrapper">
		<div class="container-fluid">
			<div class="row" style="background-color: f1f4f5">
				<div class="col-md-4">

					<div class="panel panel-default">
						<div class="panel-heading"
							style="background: #8d9fc4; color: #ffffff">
							<img src="/Reap/resources/img/ico-badge.png" /> <strong
								style="font-size: 15px">&nbsp BADGES & POINTS </strong>
						</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-lg-3" style="padding: 10px">
									<center>
										<img
											src="data:image/jpg;base64,<c:out value='${earningKitty.getEmployeeDto().getProfilePic()}'/>"
											alt="image" class="img-rounded" width="50px" height="50px">
									</center>

								</div>

								<div class="col-lg-4" style="padding-top: 10px"
									class="mybadgess">
									<center>
										<div class="row">
											<a href="#"><strong style="font-size: 15px">${employee.getEmployeeName()}</strong></a>
										</div>
										<div class="row" style="padding-top: 5px">
											<div class="col-xs-4">
												<img class="img-rounded"
													src="/Reap/resources/img/ico-badge-orange.png" />
											</div>
											<div class="col-xs-4">
												<img class="img-rounded"
													src="/Reap/resources/img/ico-badge-grey.png" />
											</div>
											<div class="col-xs-4">
												<img class="img-rounded"
													src="/Reap/resources/img/ico-badge-brown.png" />
											</div>
										</div>
										<div class="row" style="padding-top: 5px">
											<div class="col-xs-4">${earningKitty.getGold()}</div>
											<div class="col-xs-4">${earningKitty.getSilver()}</div>
											<div class="col-xs-4">${earningKitty.getBronze()}</div>
										</div>
									</center>
								</div>
								<div class="col-lg-3">

									<div style="position: static; top: -15px;">
										<img src="/Reap/resources/img/points.png" alt="Points"
											class="img-rounded">
										<div style="position: absolute; top: 20px; left: 55px;">
											<center>
												<h1>${earningKitty.getPoints()}
													<small>pts</small>
												</h1>
											</center>
										</div>
									</div>
								</div>
							</div>



						</div>
					</div>
				</div>

				<div class="col-md-8">
					<nav class="navbar navbar"
						style="background:#8d9fc4; color:#ffffff">
					<div class="container-fluid">

						<div class="navbar-header">
							<button type="button" class="navbar-toggle"
								data-toggle="collapse" data-target="#badges"
								style="border: 1px solid black">
								<span class="icon-bar" style="background-color: #000 !important"></span>
								<span class="icon-bar" style="background-color: #000 !important"></span>
								<span class="icon-bar" style="background-color: #000 !important"></span>
							</button>

						</div>
						<div class="collapse navbar-collapse" id="badges"
							style="background: #8d9fc4; color: #ffffff; padding: 5px; font-size: 14px">
							<ul class="nav navbar-nav">

								<li><a
									href="/Reap/badges/All/${employee.getEmployeeEmailId()}">All(<i>${AlllistSize}</i>)
								</a></li>
								<li><a
									href="/Reap/badges/Shared/${employee.getEmployeeEmailId()}">BADGES
										SHARED(<i>${SharedlistSize}</i>)
								</a></li>
								<li><a
									href="/Reap/badges/Received/${employee.getEmployeeEmailId()}">BADGES
										RECEIVED(<i>${ReceivedlistSize}</i>)
								</a></li>
								<li><a href="#">BADGES HISTORY</a></li>
								<li><a href="#">POINTS REDEEMED</a></li>
							</ul>
						</div>
					</div>
					</nav>
					<c:forEach var="Badges" items="${Badges}">

						<div class="row">
							<div class="col-md-2" style="padding-top: 10px">
								<center>
									<img
										src="data:image/jpg;base64,<c:out value='${Badges.getReceiverId().getProfilePic()}'/>"
										alt="image" class="img-rounded" width="50px" height="50px">
								</center>
							</div>
							<div class="col-md-9" style="padding-top: 10px">
								<a href="#"> <strong>${Badges.getReceiverId().getEmployeeName()}</strong>
								</a> has received <img
									src="<c:choose >
										 
										   <c:when  test="${Badges.getBadgeReceived()=='Gold'}">
										   							/Reap/resources/img/ico-badge-orange.png			</c:when>
										   <c:when test="${Badges.getBadgeReceived()=='Silver'}"  >
														/Reap/resources/img/ico-badge-grey.png</c:when> 						 
										   <c:otherwise >/Reap/resources/img/ico-badge-brown.png
																								</c:otherwise>    				
										</c:choose>"
									title="${Badges.getBadgeReceived()}" alt="Star" /> from <a
									href="#"> <strong>${Badges.getSenderId().getEmployeeName()}</strong>
								</a> for Karma : ${Badges.getKarma()}

								<div>
									Reason : ${Badges.getReason() } <br> <i class="momentDate"
										data-date="20160617 15:21:13"> ${Badges.getDateTime() } </i>
								</div>
							</div>
						</div>
						<hr />


					</c:forEach>



				</div>
				<!--main Row END  -->

			</div>
		</div>
	</div>
</body>

</html>
