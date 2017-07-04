package com.rat.controlRefactor.ratFormConversion;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.rat.appRefactor.Apportionment;
import com.rat.appRefactor.Claim;
import com.rat.appRefactor.ClaimNumbers;
import com.rat.appRefactor.ClaimReserveFigures;
import com.rat.appRefactor.EQCExempt;
import com.rat.appRefactor.Event;
import com.rat.appRefactor.EventApportionment;
import com.rat.appRefactor.PaymentType;
import com.rat.appRefactor.Payments;
import com.rat.appRefactor.RetainingWall;

public class RatConvertor {

	public static ClaimNumbers convertClaimNumbers(String[] claimNumbersFromForm) {

		ClaimNumbers tempClaimNumbers = new ClaimNumbers();
		for (int i = 0; i < claimNumbersFromForm.length; i++) {
			String claimNumberString = claimNumbersFromForm[i];
			boolean mainclaim = false;

			if (claimNumberString.contains("*")) {
				mainclaim = true;
				claimNumberString = claimNumberString.substring(0, claimNumberString.length() - 1);
			}

			Claim claim = new Claim(claimNumberString, mainclaim);

			switch (i) {
			case 0:
				tempClaimNumbers.setSept2010(claim);
				break;
			case 1:
				tempClaimNumbers.setDec2010(claim);
				break;
			case 2:
				tempClaimNumbers.setFeb2011(claim);
				break;
			case 3:
				tempClaimNumbers.setJune2011(claim);
				break;
			case 4:
				tempClaimNumbers.setDec2011(claim);
				break;
			}

		}
		return tempClaimNumbers;
	}

	public static Apportionment convertApportionment(String[] claimapportionment, String[] eQCExemptApportionment,
			String[] retainingWallApportionment) {

		Apportionment apportionment = new Apportionment();

		for (int i = 0; i < claimapportionment.length; i++) {

			Float claim = Float.valueOf(claimapportionment[i]);
			Float eQCExempt = Float.valueOf(eQCExemptApportionment[i]);
			Float retainingWall = Float.valueOf(retainingWallApportionment[i]);

			EventApportionment eventApportionment = new EventApportionment();

			eventApportionment.setClaimApportionment((claim == null) ? 0f : claim);
			eventApportionment.seteQCExemptApportionment((eQCExempt == null) ? 0f : eQCExempt);
			eventApportionment.setRetainingWallApportionment((retainingWall == null) ? 0f : retainingWall);

			switch (i) {
			case 0:
				apportionment.setSept2010(eventApportionment);
				break;
			case 1:
				apportionment.setDec2010(eventApportionment);
				break;
			case 2:
				apportionment.setFeb2011(eventApportionment);
				break;
			case 3:
				apportionment.setJune2011(eventApportionment);
				break;
			case 4:
				apportionment.setDec2011(eventApportionment);
				break;
			}

		}

		return apportionment;
	}

	public static List<ClaimReserveFigures> convertClaimReserve(String[] resFigureDescription, String[] resFigureSource,
			String[] resFigureAmounts) {
		List<ClaimReserveFigures> claimReserveFigures = new ArrayList<>();

		for (int i = 0; i < resFigureDescription.length; i++) {
			if (resFigureAmounts[i] == null) {
				continue;
			} else {

				BigDecimal bigDecimal = BigDecimalMoneyConvertor.stringToBigDecimal(resFigureAmounts[i]);

				ClaimReserveFigures newFigure = new ClaimReserveFigures(resFigureDescription[i], resFigureSource[i],
						bigDecimal);

				claimReserveFigures.add(newFigure);
			}
		}

		return claimReserveFigures;
	}

	public static EQCExempt convertEQCExempt(String[] eQCExemptNote, String[] eQCExcemptAmount) {
		if (eQCExemptNote[0] != null && eQCExcemptAmount[0] != null) {
			BigDecimal bigDecimal = BigDecimalMoneyConvertor.stringToBigDecimal(eQCExcemptAmount[0]);
			EQCExempt eQCExemptCosts = new EQCExempt("EQC Exempt Costs", eQCExemptNote[0], bigDecimal);
			return eQCExemptCosts;
		}
		return null;
	}

	public static RetainingWall convertRetaininingWallReserve(String[] retWallNote, String[] retainingWallAmount) {
		if (retWallNote[0] != null && retainingWallAmount[0] != null) {
			BigDecimal bigDecimal = BigDecimalMoneyConvertor.stringToBigDecimal(retainingWallAmount[0]);
			RetainingWall retainingWallCosts = new RetainingWall("Retaining Wall Costs", retWallNote[0], bigDecimal);
			return retainingWallCosts;
		}
		return null;
	}

	public static List<Payments> convertPayments(String[] paymentName, String[] paymentAmount, String[] paymentEvent,
			String[] paymentType) {
		
		List<Payments> paymentList = new ArrayList<>();
	
		for (int i = 0; i < paymentName.length; i++) {
			
			if (paymentAmount[i]==null){
				continue;
			}else{
				BigDecimal bigDecimal = BigDecimalMoneyConvertor.stringToBigDecimal(paymentAmount[i]);
				Enum<PaymentType> paymentTypeEnum = null;
				Enum<Event> paidUnderEvent = null;
				
				if (paymentType[i].equalsIgnoreCase("Claim_Payment")){
					paymentTypeEnum = PaymentType.CLAIMPAYMENT;
				}else if (paymentType[i].equalsIgnoreCase("Legal_Payment")){
					paymentTypeEnum = PaymentType.LEGALFEES;
				}else if (paymentType[i].equalsIgnoreCase("LOR_Payment")){
					paymentTypeEnum = PaymentType.LOSSOFRENT;
				}else if (paymentType[i].equalsIgnoreCase("Accomodation")){
					paymentTypeEnum = PaymentType.ACCOMODATION;
				}
				
				if (paymentEvent[i].equalsIgnoreCase("sept2010")){
					paidUnderEvent = Event.SEPT2010;
				}else if (paymentEvent[i].equalsIgnoreCase("Dec2010")){
					paidUnderEvent = Event.DEC2010;
				}else if (paymentEvent[i].equalsIgnoreCase("Feb2011")){
					paidUnderEvent = Event.FEB2011;
				}else if (paymentEvent[i].equalsIgnoreCase("June2011")){
					paidUnderEvent = Event.JUNE2011;
				}else if (paymentEvent[i].equalsIgnoreCase("Dec2011")){
					paidUnderEvent = Event.DEC2011;
				}
				
				
				Payments payment = new Payments("Payment", paymentName[i], bigDecimal, paidUnderEvent, paymentTypeEnum);
				paymentList.add(payment);
			}
		}
		return paymentList;
	}


}


















