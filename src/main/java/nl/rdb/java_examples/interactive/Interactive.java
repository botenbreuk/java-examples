package nl.rdb.java_examples.interactive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Interactive {

    public void countTillNumber(int number) {
        int total = 0;
        while (total < number) {
            log.info("Vul getal in");
            Scanner keyboard = new Scanner(System.in);
            total += keyboard.nextInt();
            log.info("Total is: " + total);
        }
    }

    public void shuffleSporifyList() {
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

    class StartAndPrint {
        static String n = "";

        public void start() {
            new Starter().start();
            new Printer().start();
        }

        class Printer extends Thread {

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

        class Starter extends Thread {

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
}
