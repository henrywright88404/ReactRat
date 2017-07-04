package com.rat.controlRefactor.ratFormConversion;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;

public class BigDecimalMoneyConvertor {
	public static BigDecimal stringToBigDecimal(String amount){
		if(amount.isEmpty())
			amount = "0.00";
		
		DecimalFormatSymbols symbols = new DecimalFormatSymbols();
		symbols.setGroupingSeparator(',');
		symbols.setDecimalSeparator('.');

		String pattern = "###,###,##0.0#";
		DecimalFormat decimalFormat = new DecimalFormat(pattern, symbols);
		decimalFormat.setParseBigDecimal(true);

		BigDecimal bigDecimal = null;
		try {
			bigDecimal = (BigDecimal) decimalFormat.parse(amount);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return bigDecimal;
	}
}
