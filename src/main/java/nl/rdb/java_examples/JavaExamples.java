package nl.rdb.java_examples;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;
import nl.rdb.java_examples.enums.TestEnum;
import nl.rdb.java_examples.inheritance.TestOverErving;
import nl.rdb.java_examples.pokemon.pokemon_kinds.Charmander;
import nl.rdb.java_examples.string.CodeGenerator;
import nl.rdb.java_examples.suppliers.SupplierExample;
import nl.rdb.java_examples.time.ClockExample;
import nl.rdb.java_examples.time.DateExample;

@Slf4j
public class JavaExamples {

    static String n = "";

    public static void main(String[] args) {
        String numberConcat = 1 + 1 + 2 + "6";
        log.info(numberConcat);
        SupplierExample supplierExample = new SupplierExample();

        List<String> stringList = supplierExample.getDocumentsReference().getDocumentNames().get();
        log.info("Stringlist size: " + stringList.size());

        DateExample dateExample = new DateExample();
        log.info("{}", dateExample.addDays(LocalDate.of(2017, 11, 2), 3));
        log.info(dateExample.formatCurrentDate("yyyyMMdd"));

        String str = "42 B.V.";
        log.info(str.replaceAll("[,. ]", "").toLowerCase());
        String str2 = "42bv";
        log.info(str2.replaceAll("[,. ]", "").toLowerCase());

        log.info(TestEnum.HELLO.name());
        log.info("{}", Authority.CLIENTS_MANAGE);

        ClockExample clockExample = new ClockExample();
        log.info("{}", clockExample.showRealTime());
        log.info("{}", clockExample.showTime());

        LocalDateTime dateTime = LocalDateTime.of(2018, 11, 02, 12, 32, 22, 300);
        log.info(dateTime.toLocalTime().toString());

        //		log.info("<!-- Count user input util it reaches maximum -->");
        //		countTillNumber(100);

        log.info("<!-- Unique id generator -->");
        generateUID(4);

        log.info("<!-- Enum test -->");
        Test test = Test.TEST1;
        Test test2 = Test.TEST2;
        Test test3 = Test.TEST3;

        returnTest(test);
        returnTest(test2);
        returnTest(test3);

        log.info("<!-- Overerving test -->");
        TestOverErving testOverErving = new TestOverErving();
        testOverErving.testClasses();

        //		shuffleSporifyList();

        start();

        log.info(Charmander.class.getName());
        log.info(Charmander.class.getSimpleName());

        //		Looping.loopie(0, 100000, log::info);

        log.info("{}", TimeUnit.HOURS.toMillis(1));
        log.info(new CodeGenerator().getCode());

    }

    private static void start() {

        new Starter().start();
        new Printer().start();

    }

    private static void countTillNumber(int number) {
        int total = 0;
        while (total < number) {
            log.info("Vul getal in");
            Scanner keyboard = new Scanner(System.in);
            total += keyboard.nextInt();
            log.info("Total is: " + total);
        }
    }

    private static void generateUID(int number) {
        for (int i = 0; i < number; i++) {
            log.info(UUID.randomUUID().toString());
        }
    }

    private static void shuffleSporifyList() {
        List<String> strings = new ArrayList<>();
        Scanner keyboard = new Scanner(System.in);
        int i = 1;
        while (keyboard.hasNextLine()) {
            if (keyboard.nextLine().isEmpty())
                break;
            strings.add(i + ": " + keyboard.nextLine());
            i++;
        }
        log.info("{}", strings.size());
        log.info("Normal list");
        strings.forEach(log::info);

        log.info("Shuffled list");
        Collections.shuffle(strings);
        strings.forEach(log::info);
    }

    private static void returnTest(Test test) {
        switch (test) {
            case TEST1, TEST2 -> log.info("This is 1 or 2");
            case TEST3 -> log.info("This is 3");
        }
    }

    public enum Test {
        TEST1,
        TEST2,
        TEST3
    }

    static class Printer extends Thread {

        @Override
        public void run() {
            while (!n.equals(null)) {
                try {
                    Thread.sleep(1000);
                    if (n.trim().equals("1"))
                        log.info("Learning..");
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
                log.info("0 = OFF");
                log.info("1 = ON");
                n = reader.nextLine();
            }
        }
    }
}