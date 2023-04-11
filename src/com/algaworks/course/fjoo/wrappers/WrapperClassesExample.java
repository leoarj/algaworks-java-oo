package com.algaworks.course.fjoo.wrappers;

public class WrapperClassesExample {

	private Long wrapperLong;
	private Integer wrapperInteger;
	private Double wrapperDouble;
	private Boolean wrapperBoolean;

	public WrapperClassesExample() {
		// Até o Java 1.8
		/*
		 * wrapperLong = new Long(975452L); wrapperInteger = new Integer("15");
		 * wrapperDouble = new Double(452.78f); wrapperBoolean = new Boolean(true);
		 */

		// A partir do Java 1.9
		wrapperLong = Long.valueOf(975452L);
		wrapperInteger = Integer.parseInt("15");
		wrapperDouble = Double.valueOf(452.78f);
		wrapperBoolean = Boolean.valueOf(true);

		System.out.println("WrapperClassesExample -> Constructor:");
		System.out.println("wrapperLong: " + wrapperLong);
		System.out.println("wrapperInteger: " + wrapperInteger);
		System.out.println("wrapperDouble: " + wrapperDouble);
		System.out.println("wrapperBoolean: " + wrapperBoolean);
		System.out.println("========================================");
	}

	public void wrapperDoubleConversionTestException() {
		Double wrapperDoubleException = Double.parseDouble("trinta e um"); // Lança uma NumberFormatException
	}

	public void testConversions() {
		byte byteValue = wrapperInteger.byteValue();
		short shortValue = wrapperInteger.shortValue();
		double doubleValue = wrapperInteger.doubleValue();

		// Converter Strings para tipos primitivos (Métodos Parse<Tipo> da classe
		// wrapper correspondente):
		String someNumber = "40";
		doubleValue = Double.parseDouble(someNumber);

		System.out.println("WrapperClassesExample -> testConversions:");
		System.out.println("byteValue: " + byteValue);
		System.out.println("shortValue: " + shortValue);
		System.out.println("doubleValue: " + doubleValue);
		System.out.println("========================================");
	}

	// Autoboxing (A partir do Java 1.5)
	public void testAutoboxing() {
		Double doubleAutoboxing = 45.89;
		Long longAutoboxing = 784569L;

		System.out.println("WrapperClassesExample -> testAutoboxing:");
		System.out.println("doubleAutoboxing: " + doubleAutoboxing);
		System.out.println("longAutoboxing: " + longAutoboxing);
		System.out.println("========================================");
	}

	// Autounboxing (A partir do Java 1.5)
	public void testAutounboxing() {
		Integer someInteger = Integer.valueOf(10);
		int someInt = someInteger;

		System.out.println("WrapperClassesExample -> testAutounboxing:");
		System.out.println("someInteger: " + someInteger);
		System.out.println("someInt: " + someInt);
		System.out.println("========================================");
	}

	public static void main(String args[]) {
		WrapperClassesExample classesExample = new WrapperClassesExample();

		classesExample.testConversions();
		classesExample.testAutoboxing();
		classesExample.testAutounboxing();
		classesExample.wrapperDoubleConversionTestException();
	}
}
