/**
 * 
 */
package com.rat.controlRefactor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.rat.appRefactor.Apportionment;
import com.rat.appRefactor.Claim;
import com.rat.appRefactor.ClaimNumbers;
import com.rat.appRefactor.ClaimReserveFigures;
import com.rat.appRefactor.EQCExempt;
import com.rat.appRefactor.Payments;
import com.rat.appRefactor.Rat;
import com.rat.appRefactor.ReserveFigures;
import com.rat.appRefactor.RetainingWall;
import com.rat.controlRefactor.ratFormConversion.RatConvertor;


/**
 * @author Marc
 *
 */
public class RatControlHelper {
	
	public static Rat catureRat(HttpServletRequest request){
		
		// read form data
				String[] claimNumbersFromForm = request.getParameterValues("claimnumbers");	
				String[] claimapportionment = request.getParameterValues("apportionment");
				String[] resFigureDescription = request.getParameterValues("reserveFiguresDescripton");
				String[] resFigureSource = request.getParameterValues("reserveFiguresNote");
				String[] resFigureAmounts = request.getParameterValues("reserveFiguresAmount");
				//TODO change cat3 to EQCexempt on jsp page. 
				String[] eQCExemptAmount = request.getParameterValues("cat3Amount");
				String[] eQCExemptNote = request.getParameterValues("cat3Note");
				String[] eQCExemptApportionment = request.getParameterValues("cat3apportionment");
				String[] retainingWallAmount = request.getParameterValues("retainingwallamount");
				String[] retWallNote = request.getParameterValues("retWallNote");
				String[] retainingWallApportionment = request.getParameterValues("retainingWallApportionment");
				String[] paymentType = request.getParameterValues("PaymentType");
				String[] paymentName = request.getParameterValues("Paymentname");
				String[] paymentAmount = request.getParameterValues("Paymentamount");
				String[] paymentEvent = request.getParameterValues("PaymentEvent");



				// convert form data to Rat object. 
				
				// convert claimNumbers to ClaimNumbers Object and main claim object
				ClaimNumbers claimNumbers = RatConvertor.convertClaimNumbers(claimNumbersFromForm);
				
				// convert claimapportionment, eQCExemptApportionment, and retainingWallApportionment to Apportionment object 
				Apportionment claimApportionment = RatConvertor.convertApportionment(claimapportionment, eQCExemptApportionment, retainingWallApportionment );
				
				//convert resFigureDescription,resFigureSource, resFigureAmounts from form to list of ClaimReserveFigures.
				List<ClaimReserveFigures> claimReserve = RatConvertor.convertClaimReserve(resFigureDescription,resFigureSource, resFigureAmounts);

				EQCExempt eQCExemptReserve = RatConvertor.convertEQCExempt(eQCExemptNote,eQCExemptAmount);
				
				RetainingWall retainingWallReserve = RatConvertor.convertRetaininingWallReserve(retWallNote,retainingWallAmount);
			
				List<Payments> payments= RatConvertor.convertPayments(paymentName,paymentAmount,paymentEvent, paymentType);
				
				ReserveFigures reserveFigures = new ReserveFigures(eQCExemptReserve, retainingWallReserve, claimReserve);

				Rat tempRat = new Rat(claimNumbers.getMainClaim(), claimNumbers, claimApportionment, reserveFigures, payments, null, null);
		
		return tempRat;
		
	}

}
