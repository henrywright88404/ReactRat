package com.rat.testRefactor;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;


import com.rat.appRefactor.Claim;
import com.rat.appRefactor.ClaimNumbers;
import com.rat.appRefactor.Event;
import com.rat.appRefactor.PaymentType;
import com.rat.appRefactor.Payments;
import com.rat.appRefactor.Rat;

public class TestRat {



	@Test
	public final void testGetMainClaimNumber() {
		Rat testRat = new Rat();
		
		ClaimNumbers testClaimNumbers = new ClaimNumbers();
		
		Claim testClaim = new Claim();
		testClaim.setClaimNumber("MAINclaimTEST");
		testClaim.setMainclaim(true);
		
		testClaimNumbers.setFeb2011(testClaim);
		
		testRat.setClaimNumbers(testClaimNumbers);
		assertEquals("MAINclaimTEST", testRat.getMainClaim().getClaimNumber() );
	}
	
	@Test
	public final void testGetpaymentType() {
		

		Payments payment = new Payments("TeSt PaYment", "Test Ref note", new BigDecimal(10), Event.FEB2011, PaymentType.CLAIMPAYMENT);
		
		
	
		
		assertEquals("FEB2011", payment.getPaymentType() );
	}

}
