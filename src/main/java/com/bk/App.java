package com.bk;

import com.bk.csvwork.StudyManager;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Scanner sc = null;
        try {
            sc = new Scanner(System.in);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String choice = "";
        StudyManager stdm = new StudyManager();

        while (!choice.equalsIgnoreCase("quit")) {
            String filename = "Studied.csv";
            System.out.println("Enter content type");
            System.out.println("1.studied\t 2.reffered");
            String contentType = sc.nextLine();
            if (contentType.contains("2")) {
                filename = "Reffered.csv";
            }

            System.out.println("Enter your choice");
            System.out.println("1.Insert data to csv file");
            System.out.println("2.Display CSV file");
            choice = sc.nextLine();
            if (choice.contains("1")) {
                stdm.initialize(filename, "write");

                String ch="yes";
                while (ch.equalsIgnoreCase("yes")){
                    String[] data = stdm.readData(filename);
                    stdm.addToCSV(filename, data);
                    System.out.println("Do you want to add more info (yes/no)");
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
            System.out.println("Enter any key to continue... type quit to exit");
            choice= sc.nextLine();
        }
    }
}
