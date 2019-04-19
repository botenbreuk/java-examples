package com.example.testapp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.example.testapp.enums.TestEnum;
import com.example.testapp.overerving.TestOverErving;
import com.example.testapp.suppliers.SupplierExample;
import com.example.testapp.time.ClockExample;
import com.example.testapp.time.DateExample;

public class TestApp {

	public static void main(String[] args) {

		SupplierExample supplierExample = new SupplierExample();

		List<String> stringList = supplierExample.getDocumentsReference().getDocumentNames().get();
		System.out.println("Stringlist size: " + stringList.size() + "\n");

		DateExample dateExample = new DateExample();
		System.out.println(dateExample.addDays(LocalDate.of(2017, 11, 2), 3));
		System.out.println(dateExample.formatCurrentDate("yyyyMMdd"));

		String str = "42 B.V.";
		System.out.println(str.replaceAll("[,. ]", "").toLowerCase());
		String str2 = "42bv";
		System.out.println(str2.replaceAll("[,. ]", "").toLowerCase());

		System.out.println(TestEnum.HELLO.name());
		System.out.println(Authority.CLIENTS_MANAGE);

		ClockExample clockExample = new ClockExample();
		System.out.println(clockExample.showRealTime());
		System.out.println(clockExample.showTime());

		LocalDateTime dateTime = LocalDateTime.of(2018, 11, 02, 12, 32, 22, 300);
		System.out.println(dateTime.toLocalTime().toString());

//		int integer = 0;
//		while (integer < 100) {
//			System.out.println("Vul getal in");
//			Scanner keyboard = new Scanner(System.in);
//			integer += keyboard.nextInt();
//			System.out.println("Total is: " + integer);
//		}

		System.out.println("<!-- Unique id generator -->");
		System.out.println(UUID.randomUUID().toString());
		System.out.println(UUID.randomUUID().toString());
		System.out.println(UUID.randomUUID().toString());
		System.out.println(UUID.randomUUID().toString());

		System.out.println("<!-- Enum test -->");
		Test test = Test.TEST1;
		Test test2 = Test.TEST2;
		Test test3 = Test.TEST3;

		returnTest(test);
		returnTest(test2);
		returnTest(test3);

		System.out.println("<!-- Overerving test -->");
		TestOverErving testOverErving = new TestOverErving();
		testOverErving.testClasses();

//		List<String> strings = new ArrayList<>();
//		Scanner keyboard = new Scanner(System.in);
//		int i = 1;
//		while (keyboard.hasNextLine()) {
//			if (keyboard.nextLine().isEmpty()) break;
//			strings.add(i + ": " + keyboard.nextLine());
//			i++;
//		}
//		System.out.println(strings.size());
//		System.out.println("Normal list");
//		strings.forEach(System.out::println);
//
//		System.out.println("Shuffled list");
//		Collections.shuffle(strings);
//		strings.forEach(System.out::println);
	}

	private static void returnTest(Test test) {
		switch(test) {
			case TEST1:
			case TEST2:
				System.out.println("This is 1 or 2");
				break;
			case TEST3:
				System.out.println("This is 3");
				break;
		}
	}

	public enum Test {
		TEST1,
		TEST2,
		TEST3
	}
}