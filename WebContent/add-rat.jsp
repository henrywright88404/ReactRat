<!DOCTYPE html>

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


<body onload="add_reserve_figure_fields();">
	<form action="RatControlServlet" method="post">
		<input type="hidden" name="command" value="ADD" />

		<div class="container-fluid">




			<h2 class="text-center">Reserve Apportionment Template</h2>




			<h3 class="text-center">New Rat</h3>

			<div class="col-xs-12">
				<div class="table-responsive">
					<table>
						<tr>
							<th>Event</th>
							<td class="text-center">Sept</td>
							<td class="text-center">Dec</td>
							<td class="text-center">Feb</td>
							<td class="text-center">June</td>
							<td class="text-center">Dec</td>
						</tr>
						<tr>
							<th>Claim Numbers</th>
							<td><input type="text" class="form-control"
								name="claimnumbers" value="0" /></td>
							<td><input type="text" class="form-control"
								name="claimnumbers" value="0" /></td>
							<td><input type="text" class="form-control"
								name="claimnumbers" value="0" /></td>
							<td><input type="text" class="form-control"
								name="claimnumbers" value="0" /></td>
							<td><input type="text" class="form-control"
								name="claimnumbers" value="0" /></td>
						</tr>
						<tr>
							<th>Apportionment</th>
							<td><input type="number" class="form-control"
								name="apportionment" value="0" /></td>
							<td><input type="number" class="form-control"
								name="apportionment" value="0" /></td>
							<td><input type="number" class="form-control"
								name="apportionment" value="0" /></td>
							<td><input type="number" class="form-control"
								name="apportionment" value="0" /></td>
							<td><input type="number" class="form-control"
								name="apportionment" value="0" /></td>
						</tr>

					</table>
				</div>
			</div>


			<br> <br>



			<h4 class="text-center">Reserve Figures</h4>

			<div class="col-sm-12"></div>
			<div id="reserveFigureFields"></div>


			<div class="form-group">
				<div class="row">
					<div class="col-sm-1">
						<h5 class="text-center">Cat 3 Figures</h5>
					</div>
					<div class="col-sm-3">
						<input type="text" class="form-control" name="cat3Note"
							placeholder="Enter source of data" />
					</div>

					<div class="col-sm-3" id="figureamount">
						<input type="number" step="0.01" class="form-control"
							name="cat3Amount" placeholder="Amount" />
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-sm-1">
					<h5 class="text-center">Cat 3 Apportionment</h5>
				</div>
				<div class="col-sm-1">
					<input type="number" class="form-control" name="cat3apportionment"
						value="0" />
				</div>
				<div class="col-sm-1">
					<input type="number" class="form-control" name="cat3apportionment"
						value="0" />
				</div>
				<div class="col-sm-1">
					<input type="number" class="form-control" name="cat3apportionment"
						value="0" />
				</div>
				<div class="col-sm-1">
					<input type="number" class="form-control" name="cat3apportionment"
						value="0" />
				</div>
				<div class="col-sm-1">
					<input type="number" class="form-control" name="cat3apportionment"
						value="0" />
				</div>
			</div>


			<div class="form-group">
				<div class="row">

					<div class="col-sm-1">
						<h5 class="text-center">Retaining Wall Figures</h5>
					</div>
					<div class="col-sm-3">
						<input type="text" class="form-control" name="retWallNote"
							placeholder="Enter source of data" />
					</div>
					<div class="col-sm-3" id="figureamount">
						<input type="number" step="0.01" class="form-control"
							name="retainingwallamount" placeholder="Amount" />
					</div>
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-1">
					<h5 class="text-center">Retaining wall Apportionment</h5>
				</div>
				<div class="col-sm-1">
					<input type="number" class="form-control"
						name="retainingWallApportionment" value="0" />
				</div>
				<div class="col-sm-1">
					<input type="number" class="form-control"
						name="retainingWallApportionment" value="0" />
				</div>
				<div class="col-sm-1">
					<input type="number" class="form-control"
						name="retainingWallApportionment" value="0" />
				</div>
				<div class="col-sm-1">
					<input type="number" class="form-control"
						name="retainingWallApportionment" value="0" />
				</div>
				<div class="col-sm-1">
					<input type="number" class="form-control"
						name="retainingWallApportionment" value="0" />
				</div>
			</div>



			<div class="row">
				<div class="col-sm-12">
					<h5 class="text-center">Payments</h5>
				</div>
			</div>


			<div id="payment_fields"></div>
			<div class="col-sm-3 nopadding">
				<div class="form-group">
					<input type="text" class="form-control" id="PaymentName"
						name="Paymentname" value="" placeholder="Reason for payment">
				</div>
			</div>
			<div class="col-sm-3 nopadding">
				<div class="form-group">
					<input type="number" class="form-control" id="PaymentAmount"
						name="Paymentamount" value="" placeholder="Payment Amount">
				</div>
			</div>
			<div class="col-sm-2 nopadding">
				<div class="form-group">
					<div class="input-group">
						<select class="form-control" id="PaymentEvent" name="PaymentEvent">
							<option value="">Event</option>
							<option value="SEPT2010">SEPT2010</option>
							<option value="DEC2010">DEC2010</option>
							<option value="FEB2011">FEB2011</option>
							<option value="JUNE2011">JUNE2011</option>
							<option value="DEC2011">DEC2011</option>
						</select>
					</div>
				</div>
			</div>

			<div class="col-sm-3 nopadding">
				<div class="form-group">
					<div class="input-group">
						<select class="form-control" id="PaymentType" name="PaymentType">

							<option value="">Payment Type</option>
							<option value="Claim_Payment">Claim Payment</option>
							<option value="Legal_Payment">Legal Fees</option>
							<option value="LOR_Payment">Loss Of Rent</option>
							<option value="Accommodation">Accommodation</option>
						</select>
						<div class="input-group-btn">
							<button class="btn btn-success" type="button"
								onclick="payment_fields();">
								<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
							</button>
						</div>
					</div>
				</div>
			</div>
			<div class="clear"></div>

		</div>
		<div class="panel-footer">
			<small>Press <span class="glyphicon glyphicon-plus gs"></span>
				to add another form field :)
			</small>, <small>Press <span class="glyphicon glyphicon-minus gs"></span>
				to remove form field :)
			</small>
		</div>


		<div class="form-group">
			<div class="col-sm-12 col-sm-offset-11">
				<button type="submit" class="btn btn-primary">Submit</button>
			</div>
		</div>

		<div style="clear: both;"></div>
		<p>
			<a href="RatControlServlet">Back to List</a>
		</p>




	</form>

	<!--Function to generate the reserve figure fields  -->
	<script type="text/javascript">
		function add_reserve_figure_fields() {
			var fields = [ 'Base Estimate or SI',
					'Betterment (deducted) <$30k or 10%',
					'Deductions (if incl in Base Est)', 'Variations',
					'Demolition', 'TC Foundation Costs',
					'Scoping Report Costs', 'Geotech Report Costs',
					'Engineering Costs', 'CWI Premium Costs',
					'Architectural / Design Costs', 'Other', 'Other', 'Other',
					'LA Fees Costs', 'Legal Fees', 'Loss of Rent' ];

			for (i = 0; i < fields.length; i++) {
				var objTo = document.getElementById("reserveFigureFields");
				var divtest = document.createElement("div");
				divtest.innerHTML = '<div class="reserveFigureFields"><div class="col-sm-2"> <input type="text" class="form-control" name="reserveFiguresDescripton" value="'+ fields[i] +'" readonly/></div><div class="col-sm-3"><input type="text" class="form-control" name="reserveFiguresNote" placeholder="Enter source of data"  /></div><div class="col-sm-3"><input type="number" step="0.01" class="form-control" name="reserveFiguresAmount" placeholder="Amount" /></div><div class="col-sm-12"></div></div>';
				objTo.appendChild(divtest)
			}

		}
	</script>



	<script type="text/javascript">
		var room = 1;
		function payment_fields() {

			room++;
			var objTo = document.getElementById('payment_fields')
			var divtest = document.createElement("div");
			divtest.setAttribute("class", "form-group removeclass" + room);
			var rdiv = 'removeclass' + room;
			divtest.innerHTML = '<div class="col-sm-3 nopadding"><div class="form-group"><input type="text" class="form-control" id="PaymentName" name="Paymentname" value="" placeholder="Reason for payment"></div></div><div class="col-sm-3 nopadding"><div class="form-group"><input type="number" class="form-control" id="PaymentAmount"name="Paymentamount" value= "" placeholder="Payment Amount"></div></div><div class="col-sm-2 nopadding"><div class="form-group"><div class="input-group"><select class="form-control" id="PaymentEvent" name="PaymentEvent"><option value=>Event</option><option value="SEPT2010">SEPT2010</option><option value="DEC2010">DEC2010</option><option value="FEB2011">FEB2011</option><option value="JUNE2011">JUNE2011</option><option value="DEC2011">DEC2011</option></select></div></div></div><div class="col-sm-3 nopadding"><div class="form-group"><div class="input-group"><select class="form-control" id="PaymentType" name="PaymentType"><option value="">Payment Type</option><option value="Claim_Payment">Claim Payment</option><option value="Legal_Payment">Legal Fees</option><option value="LOR_Payment">Loss Of Rent</option><option value="Accommodation">Accommodation</option></select><div class="input-group-btn"><button class="btn btn-danger" type="button" onclick="remove_payment_fields('
					+ room
					+ ');"> <span class="glyphicon glyphicon-minus" aria-hidden="false"></span></button></div></div></div></div><div class="clear"></div>';

			objTo.appendChild(divtest)
		}
	</script>

	<script type="text/javascript">
		function remove_payment_fields(rid) {
			$('.removeclass' + rid).remove();
		}
	</script>


	<!-- TODO add validation for input fields relating to money - ensuring a number is passed in and not any illegal characters.  -->

</body>
</html>