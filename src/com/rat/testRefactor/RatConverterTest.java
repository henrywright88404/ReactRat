package com.rat.testRefactor;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


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
import com.rat.controlRefactor.ratFormConversion.RatConvertor;

public class RatConverterTest {
	
	private ClaimNumbers claimNumbers;
	private Apportionment apportionment;
	private List<ClaimReserveFigures> claimReserveFigures = new ArrayList<>();
	private EQCExempt eQCExempt;
	private RetainingWall retainingWall;
	private List<Payments> paymentsList = new ArrayList<>();
	
	@Before
	public void setUp() throws Exception {
		Claim claim1 = new Claim("11111", false);
		Claim claim2 = new Claim("22222", false);
		Claim claim3 = new Claim("33333", true);
		Claim claim4 = new Claim("44444", false);
		Claim claim5 = new Claim("55555", false);
		
		claimNumbers = new ClaimNumbers(claim1,claim2,claim3,claim4,claim5);
		
		
		EventApportionment sept2010 = new EventApportionment(0.10f, 0.30f, 0.00f);
		EventApportionment dec2010 = new EventApportionment(0.20f, 0.20f, 0.10f);
		EventApportionment feb2011 = new EventApportionment(0.30f, 0.10f, 0.20f);
		EventApportionment june2011 = new EventApportionment(0.40f, 0.40f, 0.30f);
		EventApportionment dec2011 = new EventApportionment(0.00f, 0.00f, 0.40f);
		
		apportionment = new Apportionment(sept2010,dec2010,feb2011,june2011,dec2011);
		
		ClaimReserveFigures reserveFigure1 = new ClaimReserveFigures("Base", "From Scope of works", BigDecimal.valueOf(100_000));
		ClaimReserveFigures reserveFigure2 = new ClaimReserveFigures("Foundations", "From Scope of works", BigDecimal.valueOf(50_000));
		ClaimReserveFigures reserveFigure3 = new ClaimReserveFigures("Engineering", "From short form agreement", BigDecimal.valueOf(12_500.88));
		ClaimReserveFigures reserveFigure4 = new ClaimReserveFigures("Design", "From case manager", BigDecimal.valueOf(500.99));
		
		claimReserveFigures.add(reserveFigure1);
		claimReserveFigures.add(reserveFigure2);
		claimReserveFigures.add(reserveFigure3);
		claimReserveFigures.add(reserveFigure4);
		
		eQCExempt = new EQCExempt("EQC Exempt Costs", "From Contract", BigDecimal.valueOf(32_000.00));

		retainingWall = new RetainingWall("Retaining Wall Costs", "From Contract", BigDecimal.valueOf(52_000.00));
		
		Payments payment1 = new Payments("Payment", "Progress Payment", BigDecimal.valueOf(29_000.00), Event.FEB2011, PaymentType.CLAIMPAYMENT);
		Payments payment2 = new Payments("Payment", "Progress Payment", BigDecimal.valueOf(67_000.78), Event.DEC2011, PaymentType.CLAIMPAYMENT);
		Payments payment3 = new Payments("Payment", "Design", BigDecimal.valueOf(5_500.90), Event.JUNE2011, PaymentType.CLAIMPAYMENT);
		Payments payment4 = new Payments("Payment", "Loss of Rent", BigDecimal.valueOf(40_000.00), Event.FEB2011, PaymentType.LOSSOFRENT);
		Payments payment5 = new Payments("Payment", "Engineering", BigDecimal.valueOf(1_000.00), Event.SEPT2010, PaymentType.CLAIMPAYMENT);

		paymentsList.add(payment1);
		paymentsList.add(payment2);
		paymentsList.add(payment3);
		paymentsList.add(payment4);
		paymentsList.add(payment5);
		
	}

	@Test
	public final void testConvertClaimReserve(){
		String[] description = {"Base","Foundations","Engineering","Design"};
		String[] source = {"From Scope of works","From Scope of works","From short form agreement","From case manager"};
		String[] amount = {"100,000","50,000","12,500.88","500.99"};
		
		List<ClaimReserveFigures> other = RatConvertor.convertClaimReserve(description, source, amount);
		
		assertEquals(claimReserveFigures, other);
		
	}
	@Test
	public final void testConvertClaimNumbers() {
		String[] claimNumbersFromForm = {"11111","22222","33333*","44444","55555"};
		
		ClaimNumbers other = RatConvertor.convertClaimNumbers(claimNumbersFromForm);
		
		assertEquals(claimNumbers, other);
		
	}
	@Test
	public final void testConvertApportionment() {
		String[] claimApportionment = {"0.10","0.20","0.30","0.40","0.00"};
		String[] eQCExemptApportionment = {"0.30","0.20","0.10","0.40","0.00"};
		String[] retainingWallApportionment = {"0.00","0.10","0.20","0.30","0.40"};
		
		Apportionment other = RatConvertor.convertApportionment(claimApportionment, eQCExemptApportionment, retainingWallApportionment);
		
		assertEquals(apportionment, other);
	}
	@Test
	public final void convertEQCExempt() {
		String[] eQCexemptNote = {"From Contract"};
		String[] eQCExemptAmount = {"32,000.00"};
			
		EQCExempt other = RatConvertor.convertEQCExempt(eQCexemptNote, eQCExemptAmount);
			
		assertEquals(eQCExempt, other);
	}
	@Test
	public final void convertRetainingWall() {
		String[] retaingWallNote = {"From Contract"};
		String[] retainingWallAmount = {"52,000.00"};
			
		RetainingWall other = RatConvertor.convertRetaininingWallReserve(retaingWallNote, retainingWallAmount);
			
		assertEquals(retainingWall, other);
	}
	@Test
	public final void convertPayments(){
		String[] paymentName = {"Progress Payment","Progress Payment","Design","Loss of Rent","Engineering"};
		String[] paymentAmount = {"29,000","67,000.78","5,500.90","40,000.00","1,000.00"};
		String[] paymentEvent = {"feb2011","dec2011","June2011","feb2011","sept2010"};
		String[] paymentType = {"Claim Payment","Claim Payment","Claim Payment","Loss Of Rent","Claim Payment"}; 
		
		List<Payments> other = RatConvertor.convertPayments(paymentName, paymentAmount, paymentEvent, paymentType);
		
		assertEquals(paymentsList, other);
	}

}
