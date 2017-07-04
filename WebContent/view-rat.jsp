<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="java.util.*, com.rat.app.*"%>

<html>
<head>
<title>Reserve Apportionment Template</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>


<body>


	<div class="row">
		<h2 class="text-center">Reserve Apportionment Template View</h2>
	</div>
	<div class="row">
		<div class="table-responsive">
			<table class="table table-striped">
				<tr>
					<td class="col-sm-2">
					<td>
					<th class="col-sm-2 nopadding">Events</th>
					<td class="col-sm-1 nopadding">SEPT</td>
					<td class="col-sm-1 nopadding">DEC</td>
					<td class="col-sm-1 nopadding">FEB</td>
					<td class="col-sm-1 nopadding">JUNE</td>
					<td class="col-sm-1 nopadding">DEC</td>
					<td class="col-sm-2">
					<td>
				</tr>
				<tr>
					<td class="col-sm-2">
					<td>
					<th class="col-sm-2 nopadding">Claim Numbers</th>
					<td class="col-sm-1 nopadding">${THE_RAT.getClaimNumber(0) }</td>
					<td class="col-sm-1 nopadding">${THE_RAT.getClaimNumber(1) }</td>
					<td class="col-sm-1 nopadding">${THE_RAT.getClaimNumber(2) }</td>
					<td class="col-sm-1 nopadding">${THE_RAT.getClaimNumber(3) }</td>
					<td class="col-sm-1 nopadding">${THE_RAT.getClaimNumber(4) }</td>
					<td class="col-sm-2">
					<td>
				</tr>
				<tr>
					<td class="col-sm-2">
					<td>
					<th class="col-sm-2 nopadding">Apportionment</th>
					<td class="col-sm-1 nopadding">${THE_RAT.getApportionment(0) }%</td>
					<td class="col-sm-1 nopadding">${THE_RAT.getApportionment(1) }%</td>
					<td class="col-sm-1 nopadding">${THE_RAT.getApportionment(2) }%</td>
					<td class="col-sm-1 nopadding">${THE_RAT.getApportionment(3) }%</td>
					<td class="col-sm-1 nopadding">${THE_RAT.getApportionment(4) }%</td>
					<td class="col-sm-2">
					<td>
				</tr>

			</table>
		</div>



		<br> <br>

		<!-- code for the tables to show the Base Eng,Geo etc on the left and the Cat 3 / retaining wall on the right -->

		<div class="col-xs-6">
			<div class="table-responsive">
				<table>
					<tr>
						<td class="col-sm-2 nopadding">
							<h4>Reserve Figures</h4>
						</td>
					</tr>
				</table>
				<table class="table table-striped">


					<tr>
						<!-- code for table on the left -->
						<th>Description</th>
						<th>Amount</th>
						<th>Note</th>

						<c:forEach var="tempReserveFigures"
							items="${THE_RAT.getReserveFigures() }">
							<tr>
								<td class="col-sm-2 nopadding"><c:out
										value="${tempReserveFigures.getSourceOfData() }" /></td>
								<td class="col-sm-2 nopadding"><c:out
										value="$ ${tempReserveFigures.getAmount() }" /></td>
								<td class="col-sm-2 nopadding"><c:out
										value="${tempReserveFigures.getName() }" /></td>

							</tr>
						</c:forEach>
					</tr>
				</table>
			</div>
		</div>

		<!-- code for table on the right -->


		<div class="col-sx-6">
			<div class="table-responsive">
				<table>
					<tr>
						<td class="col-sm-6 nopadding">
							<h4>Cat 3 Figures</h4>
						</td>

					</tr>
					<tr>
						<th class="col-sm-2 nopadding">Apportionment</th>
						<td class="col-sm-1 nopadding">SEPT</td>
						<td class="col-sm-1 nopadding">DEC</td>
						<td class="col-sm-1 nopadding">FEB</td>
						<td class="col-sm-1 nopadding">JUNE</td>
						<td class="col-sm-1 nopadding">DEC</td>
						<td class="col-sm-2">
					</tr>
					<tr>
						<th class="col-sm-2 nopadding"></th>
						<td class="col-sm-1 nopadding">${THE_RAT.getCat3Apportionment(0) }%</td>
						<td class="col-sm-1 nopadding">${THE_RAT.getCat3Apportionment(1) }%</td>
						<td class="col-sm-1 nopadding">${THE_RAT.getCat3Apportionment(2) }%</td>
						<td class="col-sm-1 nopadding">${THE_RAT.getCat3Apportionment(3) }%</td>
						<td class="col-sm-1 nopadding">${THE_RAT.getCat3Apportionment(4) }%</td>
						<td class="col-sm-2">
					</tr>

				</table>
				<table class="table table-striped">
					<c:forEach var="tempCat3ReserveFigures"
						items="${THE_RAT.getCat3ReserveFigures() }">
						<tr>
							<td class="col-sm-2 nopadding"><c:out value="${tempCat3ReserveFigures.getName() }" /></td>
							<td><c:out value="$ ${tempCat3ReserveFigures.getAmount() }" /></td>
						</tr>
					</c:forEach>
				</table>

				
					<table>

						<tr>
							<td class="col-sm-6 nopadding">
								<h4>Retaining Wall Figures</h4>
							</td>
						</tr>
						<tr>
							<th class="col-sm-2 nopadding">Apportionment</th>
							<td class="col-sm-1 nopadding">SEPT</td>
							<td class="col-sm-1 nopadding">DEC</td>
							<td class="col-sm-1 nopadding">FEB</td>
							<td class="col-sm-1 nopadding">JUNE</td>
							<td class="col-sm-1 nopadding">DEC</td>
							<td class="col-sm-2">
						</tr>
						<tr>

							<th class="col-sm-2 nopadding"></th>
							<td class="col-sm-1 nopadding">${THE_RAT.getRetainingWallApportionment(0) }%</td>
							<td class="col-sm-1 nopadding">${THE_RAT.getRetainingWallApportionment(1) }%</td>
							<td class="col-sm-1 nopadding">${THE_RAT.getRetainingWallApportionment(2) }%</td>
							<td class="col-sm-1 nopadding">${THE_RAT.getRetainingWallApportionment(3) }%</td>
							<td class="col-sm-1 nopadding">${THE_RAT.getRetainingWallApportionment(4) }%</td>
							<td class="col-sm-2">
						</tr>
					</table>
					<table class="table table-striped">
						<c:forEach var="tempRetainingWallFigure"
							items="${THE_RAT.getRetainingWallFigures() }">
							<tr>
								<td class="col-sm-2 nopadding"><c:out value="${tempRetainingWallFigure.getName() }" /></td>
								<td><c:out value="$ ${tempRetainingWallFigure.getAmount() }" /></td>
							</tr>
						</c:forEach>
					</table>
				
			</div>
		</div>
	</div>

	<div class="row">
		<h3 class="text-center">Reserve</h3>
	</div>
	<div class="table-responsive">
		<table class="table text-center">
			<tr>
				<th class="col-sm-1 nopadding text-center">SEPT</th>
				<th class="col-sm-1 nopadding text-center">DEC</th>
				<th class="col-sm-1 nopadding text-center">FEB</th>
				<th class="col-sm-1 nopadding text-center">JUNE</th>
				<th class="col-sm-1 nopadding text-center">DEC</th>
			</tr>
			<tr>
				<c:forEach items="${THE_RAT.getApportionedClaimReserve() }"
					var="tempApportionedReserves">
					<td>${tempApportionedReserves }</td>
				</c:forEach>
			</tr>
		</table>
	</div>



	<div class="row">
		<h3 class="text-center">Payments</h3>
	</div>

	<div class="col-xs-12">
		<div class="table-responsive">
			<table class="table-striped">
				<tr>
					<th class="col-sm-3 nopadding">Reason for Payment</th>
					<th class="col-sm-3 nopadding">Source of Data</th>
					<th class="col-sm-3 nopadding">Event paid under</th>
					<th class="col-sm-3 nopadding">Amount Paid</th>
				</tr>
				<c:forEach var="tempPaymentsList" items="${THE_RAT.getPayments() }">
					<tr>
						<td class="col-sm-3 nopadding"><c:out
								value="${tempPaymentsList.getName()}" /></td>
						<td class="col-sm-3 nopadding"><c:out
								value="${tempPaymentsList.getSourceOfData()}" /></td>
						<td class="col-sm-3 nopadding"><c:out
								value="${tempPaymentsList.getEvent()}" /></td>
						<td class="col-sm-3 nopadding"><c:out
								value="$ ${tempPaymentsList.getAmount()}" /></td>
					</tr>
				</c:forEach>

			</table>
		</div>
	</div>

	<c:url var="editLink" value="RatControlServlet">
		<c:param name="command" value="EDIT" />
		<c:param name="mainclaim" value="${THE_RAT.getMainClaim() }" />
	</c:url>

	<p>
		<a href="RatControlServlet">Back to List</a> | <a href="${editLink }">
			Edit </a>
	</p>

	<p>
		<c:out value="${THE_RAT.toString() }" />
	</p>
</body>
</html>