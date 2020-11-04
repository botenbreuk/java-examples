package com.example.java_examples;

import static com.example.java_examples.Authority.CLIENTS_MANAGE;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import com.example.java_examples.enums.TestEnum;
import com.example.java_examples.inheritance.TestOverErving;
import com.example.java_examples.suppliers.SupplierExample;
import com.example.java_examples.time.ClockExample;
import com.example.java_examples.time.DateExample;

public class JavaExamples {

	public static void main(String[] args) throws IOException {

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
		System.out.println(CLIENTS_MANAGE);

		ClockExample clockExample = new ClockExample();
		System.out.println(clockExample.showRealTime());
		System.out.println(clockExample.showTime());

		LocalDateTime dateTime = LocalDateTime.of(2018, 11, 02, 12, 32, 22, 300);
		System.out.println(dateTime.toLocalTime().toString());

//		System.out.println("<!-- Count user input util it reaches maximum -->");
//		countTillNumber(100);

		System.out.println("<!-- Unique id generator -->");
		generateUID(4);

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

		//		shuffleSporifyList();

		start();

		//		Looping.loopie(0, 100000, System.out::println);
	}

	static String n = "";

	static class Printer extends Thread {

		@Override
		public void run() {

			while (!n.equals(null)) {

				try {
					Thread.sleep(1000);

					if (n.trim().equals("1"))
						System.out.println("Learning..");

				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}

		}

	}

	static class Starter extends Thread {

		@Override
		public void run() {

			Scanner reader = new Scanner(System.in);

			while (true) {
				System.out.println("1 = ON \n 0 = OFF");
				n = reader.nextLine();
			}
		}

	}

	private static void start() {

		new Starter().start();
		new Printer().start();

	}

	private static void countTillNumber(int number) {
		int total = 0;
		while (total < number) {
			System.out.println("Vul getal in");
			Scanner keyboard = new Scanner(System.in);
			total += keyboard.nextInt();
			System.out.println("Total is: " + total);
		}
	}

	private static void generateUID(int number) {
		for(int i = 0; i < number; i++) {
			System.out.println(UUID.randomUUID().toString());
		}
	}

	private static void shuffleSporifyList() {
		List<String> strings = new ArrayList<>();
		Scanner keyboard = new Scanner(System.in);
		int i = 1;
		while (keyboard.hasNextLine()) {
			if (keyboard.nextLine().isEmpty()) break;
			strings.add(i + ": " + keyboard.nextLine());
			i++;
		}
		System.out.println(strings.size());
		System.out.println("Normal list");
		strings.forEach(System.out::println);

		System.out.println("Shuffled list");
		Collections.shuffle(strings);
		strings.forEach(System.out::println);
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