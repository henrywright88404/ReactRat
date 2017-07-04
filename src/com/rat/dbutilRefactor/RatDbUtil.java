package com.rat.dbutilRefactor;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.rat.appRefactor.Claim;
import com.rat.appRefactor.ClaimNumbers;
import com.rat.appRefactor.ClaimReserveFigures;
import com.rat.appRefactor.EventApportionment;
import com.rat.appRefactor.Payments;
import com.rat.appRefactor.Rat;
import com.rat.appRefactor.ReserveFigures;

public class RatDbUtil {

	private DataSource dataSource;

	public RatDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}

	public List<Rat> getRats() throws Exception {
		List<Rat> rats = new ArrayList<>();

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		try {
			// get a connection
			myConn = dataSource.getConnection();

			// generate sql statement
			String sql = "select * from web_rat_schema.rat order by main_claim_id";
			myStmt = myConn.createStatement();

			// Execute query
			myRs = myStmt.executeQuery(sql);

			// process result set
			while (myRs.next()) {

				// Retrieve data from result set row
				String claimNumber = myRs.getString(1);
				System.out.println("ClaimNumber is" +claimNumber);
				
				Claim claim = new Claim();
				claim.setClaimNumber(claimNumber);
				claim.setMainclaim(true);
				
				ClaimNumbers claimNumbers = new ClaimNumbers();
				claimNumbers.setFeb2011(claim);
				
				Rat tempRat = new Rat();
				tempRat.setClaimNumbers(claimNumbers);				
					
				System.out.println("The main Claim number from competed rat is " + tempRat.getMainClaim().getClaimNumber());
				// add it to the list of rats
				rats.add(tempRat);
			}
			return rats;
		} finally {

			// close JDBC objects
			close(myConn, myStmt, myRs);
		}
	}

	public void addRat(Rat tempRat) throws Exception {

		try ( // get the DB connection
				Connection myConn = dataSource.getConnection();
				// prepare the statements
				PreparedStatement mainClaimStatement = myConn
						.prepareStatement("insert into web_rat_schema.rat" + "(main_claim_id) " + "values (?)");
				PreparedStatement reserveStmt = myConn.prepareStatement("INSERT INTO web_rat_schema.reserve_figures"
						+ "(reserve_figures_id," + "item," + "reference_note," + "amount," + "is_eqc_exempt,"
						+ "is_claim_reserve_figure," + "is_retaining_wall_figure)" + "VALUES (?,?,?,?,?,?,?)");
				PreparedStatement eQCexemptstmt = myConn.prepareStatement("INSERT INTO web_rat_schema.reserve_figures"
						+ "(reserve_figures_id," + "item," + "reference_note," + "amount," + "is_eqc_exempt,"
						+ "is_claim_reserve_figure," + "is_retaining_wall_figure)" + "VALUES (?,?,?,?,?,?,?)");
				PreparedStatement retainingWallStmt = myConn.prepareStatement("INSERT INTO web_rat_schema.reserve_figures" 
						+ "(reserve_figures_id,"+ "item," + "reference_note," + "amount," + "is_eqc_exempt,"
						+ "is_claim_reserve_figure," + "is_retaining_wall_figure)" + "VALUES (?,?,?,?,?,?,?)");
				PreparedStatement paymentsStmt = myConn.prepareStatement("INSERT INTO web_rat_schema.payments" + "(payments_id," + "event_paid_under,"
						+ "payment_type," + "amount," + "item," + "referenceNote" + "VALUES (?,?,?,?,?,?)");
				PreparedStatement lossOfRentStmt = myConn.prepareStatement("insert into web_rat_schema.loss_of_rent"
						+ "(loss_of_rentid, policy_limit, estimated_lor) " + "values (?,?,?)");
				PreparedStatement apportionmentStmt = myConn.prepareStatement("INSERT INTO web_rat_schema.apportionment"
						+ "(claim_apportionment," + "eqc_exempt_apportionment," + "retaining_wall_apportionmnet,"
						+ "event_claim_number," + "apportionment_id," + "VALUES (?,?,?,?,?)");) {


			// create sql statement for new Rat insert

			mainClaimStatement.setString(1, tempRat.getMainClaim().getClaimNumber());
			mainClaimStatement.addBatch();

			// create sql for claim reserve figures

			for (ClaimReserveFigures reserve : tempRat.getReserveFigures().getClaimReserve()) {
				if( reserve.getAmount() != null || !reserve.getAmount().equals(BigDecimal.ZERO)){	
					reserveStmt.setString(1, tempRat.getMainClaim().getClaimNumber());
					reserveStmt.setString(2, reserve.getItem());
					reserveStmt.setString(3, reserve.getReferenceNote());
					reserveStmt.setBigDecimal(4, reserve.getAmount());
					reserveStmt.setBoolean(5, false);
					reserveStmt.setBoolean(6, true);
					reserveStmt.setBoolean(7, false);
					reserveStmt.addBatch();
				}
			}

			// create SQL for EQCexempt

			eQCexemptstmt.setString(1, tempRat.getMainClaim().getClaimNumber());
			eQCexemptstmt.setString(2, tempRat.getReserveFigures().geteQCExempt().getItem());
			eQCexemptstmt.setString(3, tempRat.getReserveFigures().geteQCExempt().getReferenceNote());
			eQCexemptstmt.setBigDecimal(4, tempRat.getReserveFigures().geteQCExempt().getAmount());
			eQCexemptstmt.setBoolean(5, true);
			eQCexemptstmt.setBoolean(6, false);
			eQCexemptstmt.setBoolean(7, false);
			eQCexemptstmt.addBatch();

			// create SQL for Retaining Wall

			retainingWallStmt.setString(1, tempRat.getMainClaim().getClaimNumber());
			retainingWallStmt.setString(2, tempRat.getReserveFigures().getRetainingWall().getItem());
			retainingWallStmt.setString(3, tempRat.getReserveFigures().getRetainingWall().getReferenceNote());
			retainingWallStmt.setBigDecimal(4, tempRat.getReserveFigures().getRetainingWall().getAmount());
			retainingWallStmt.setBoolean(5, false);
			retainingWallStmt.setBoolean(6, false);
			retainingWallStmt.setBoolean(7, true);
			retainingWallStmt.addBatch();

			// create SQL for payments
			for (Payments payment : tempRat.getPayments()) {
				if(payment.getAmount() != null && payment.getEventPaidUnder() != null && payment.getItem() != null){
					paymentsStmt.setString(1, tempRat.getMainClaim().getClaimNumber());
					paymentsStmt.setString(2, payment.getEventPaidUnder().toString());
					paymentsStmt.setString(3, payment.getPaymentType().toString());
					paymentsStmt.setBigDecimal(4, payment.getAmount());
					paymentsStmt.setString(5, payment.getItem());
					paymentsStmt.setString(6, payment.getReferenceNote());
					paymentsStmt.addBatch();
				}
			}

			// create SQL for Loss of Rent

			boolean anyLossOfRent = false;
			if (tempRat.getLossOfRent() != null) {
				anyLossOfRent = true;
				lossOfRentStmt.setString(1, tempRat.getMainClaim().getClaimNumber());
				lossOfRentStmt.setBigDecimal(2, tempRat.getLossOfRent().getPolicyLimit());
				lossOfRentStmt.setBigDecimal(2, tempRat.getLossOfRent().getEstimated());
				lossOfRentStmt.addBatch();
			}

			// create SQL for apportionment


			for (EventApportionment apportionment : tempRat.getApportionment().getEventApportionmentList()) {
				int i = 0;
				String claimNumber = "";
				switch (i) {
				case 0:
					claimNumber = tempRat.getClaimNumbers().getSept2010().getClaimNumber();
					break;
				case 1:
					claimNumber = tempRat.getClaimNumbers().getDec2010().getClaimNumber();
					break;
				case 2:
					claimNumber = tempRat.getClaimNumbers().getFeb2011().getClaimNumber();
					break;
				case 3:
					claimNumber = tempRat.getClaimNumbers().getJune2011().getClaimNumber();
					break;
				case 4:
					claimNumber = tempRat.getClaimNumbers().getDec2011().getClaimNumber();
					break;

				}
				apportionmentStmt.setBigDecimal(1, BigDecimal.valueOf(apportionment.getClaimApportionment()));
				apportionmentStmt.setBigDecimal(2, BigDecimal.valueOf(apportionment.geteQCExemptApportionment()));
				apportionmentStmt.setBigDecimal(3, BigDecimal.valueOf(apportionment.getRetainingWallApportionment()));
				apportionmentStmt.setString(4, claimNumber);
				apportionmentStmt.setString(5, tempRat.getMainClaim().getClaimNumber());
				apportionmentStmt.addBatch();
				i++;
			}

			// excequte the batches.
			
			mainClaimStatement.executeBatch();
			reserveStmt.executeBatch();
			eQCexemptstmt.executeBatch();
			retainingWallStmt.executeBatch();
			paymentsStmt.executeBatch();
			apportionmentStmt.executeBatch();
			// only if there is any loss of rent execute batch (most likely to not have loss of rent) 
			if (anyLossOfRent)
				lossOfRentStmt.executeBatch();

		}
	}

	public void deleteRatFromDataBase(String id) throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// get DB connection
			myConn = dataSource.getConnection();

			// create SQL drop statement
			String sql = "delete from web_rat_db.rat " + "where id=?";
			// prepare statement
			myStmt = myConn.prepareStatement(sql);

			// set param
			myStmt.setString(1, id);

			// Execute statement
			myStmt.execute();

		} finally {
			System.out.println("Finished deleteRatFromDataBase(id) method in RatDbUtil");
			close(myConn, myStmt, null);
		}
	}

	public Rat getSelectedRat(String idOrMainClaimNumber) throws Exception {
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		String id = idOrMainClaimNumber;

		String sql = "";

		try {
			// get a connection
			myConn = dataSource.getConnection();

			// generate sql statement to select this rat
			if (id.contains("*")) {
				sql = "SELECT rat FROM web_rat_db.rat WHERE main_claim='" + id + "'";
			} else {
				sql = "select * from web_rat_db.rat where id=" + id;
			}
			myStmt = myConn.createStatement();

			// Execute query
			myRs = myStmt.executeQuery(sql);
			Rat tempRat = new Rat();
			// process result set
			while (myRs.next()) {

				// Retrieve data from result set

				byte[] buf = myRs.getBytes("rat");
				ObjectInputStream objectIn = null;
				Object deSerializedObject = null;

				if (buf != null) {
					objectIn = new ObjectInputStream(new ByteArrayInputStream(buf));
					deSerializedObject = objectIn.readObject();
					tempRat = (Rat) deSerializedObject;
				} else {
					System.out.println("not pulling up rat in getSelected rat in RatDbUtil.java");
				}

			}
			return tempRat;
		} finally {

			// close JDBC objects
			close(myConn, myStmt, myRs);
		}
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
		try {
			if (myRs != null) {
				myRs.close();
			}
			if (myStmt != null) {
				myStmt.close();
			}

			if (myConn != null) {
				myConn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void updateRat(Rat tempRat, String[] oldMainClaim) throws SQLException {
		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// get the DB connection

			myConn = dataSource.getConnection();
			// create sql statement for insert

			String sql = "update web_rat_db.rat set rat = ? where main_claim = ?";

			myStmt = myConn.prepareStatement(sql);
			// set the param vals for the statement
			myStmt.setString(2, tempRat.getMainClaim().getClaimNumber());
			myStmt.setObject(1, tempRat);

			// excequte the sql insert

			myStmt.execute();
		} finally {
			// clean JDBC objects
			close(myConn, myStmt, null);
		}

	}

}
