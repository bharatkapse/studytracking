package com.bk;

import com.bk.csvwork.StudyManager;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        System.out.println("Welcome to Study Tracking!");
        Scanner sc = null;
        try {
            sc = new Scanner(System.in);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String choice = "";
        StudyManager stdm = new StudyManager();

        while (!choice.equalsIgnoreCase("quit")) {
            String filename = "studied.csv";
            System.out.println("Enter content type");
            System.out.println("1.studied\t 2.reffered");
            String contentType = sc.nextLine();
            if (contentType.contains("2")) {
                filename = "reffered.csv";
            }

            System.out.println("Enter your choice");

            System.out.println("1.Add data to record");
            System.out.println("2.show previous records");

            choice = sc.nextLine();
            if (choice.contains("1")) {
                stdm.initialize(filename, "write");

                String ch="yes";
                while (ch.equalsIgnoreCase("yes")){
                    String[] data = stdm.readData(filename);
                    stdm.addToCSV(filename, data);

                    System.out.println("Do you want to add more records (yes/no)");

                    ch= sc.nextLine();
                    if(!ch.contains("no")){
                        ch="yes";
                    }
                }

            }
            if (choice.contains("2")) {
                stdm.initialize(filename, "read");
                stdm.showCSVContent(filename);
            }

            System.out.println("press any key to continue..... type quit to exit");

            choice= sc.nextLine();
        }
    }
}
