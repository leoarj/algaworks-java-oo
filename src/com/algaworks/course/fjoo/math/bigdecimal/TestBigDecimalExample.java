package com.algaworks.course.fjoo.math.bigdecimal;

import java.math.BigDecimal;

public class TestBigDecimalExample {

	public static void main(String[] args) {
		BigDecimalExample example = new BigDecimalExample();
		
		example.calculate();
		example.testFormat(new BigDecimal("7940.14"));
		example.testParse("400,89");
	}
}