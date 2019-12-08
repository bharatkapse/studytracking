package com.bk.csvwork;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
/** Welcome to study reporting program
* this program manages the history of study
*/
public class StudyManager {

    public void initialize(String csvFileName, String mode){
        String userDir=System.getProperty("user.dir");
        File checkFile= new File(userDir+"/"+csvFileName);
        if(!checkFile.exists()){
            if(mode.equalsIgnoreCase("read")){
                System.out.println("Records are empty or "+csvFileName+"file is missing");
                System.exit(0);
            }
            CSVWriter writer =null;
            String[] header= new String[8];
            header[0]="Name of subject/topic";
            header[1]="Year";
            header[2]="Month";
            header[3]="Date";
            if(csvFileName.equalsIgnoreCase("studied.csv"))
            header[4]="Contents Studied/Reffered";
            else
                header[4]="Contents Reffered";
            header[5]="Time spent in minutes";
            header[6]="Purpose Solved";
            header[7]="Page url/Book name/pdf link";
            try {
                writer = new CSVWriter(new FileWriter(csvFileName, true));
                writer.writeNext(header);
                writer.close();

            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }

    public boolean addToCSV(String csvFileName, String[] data)
    {
        String userDir=System.getProperty("user.dir");
        csvFileName=userDir+"/"+csvFileName;
        if(data==null){
            System.out.println("No data for write");
        }

        CSVWriter writer =null;
       try {
           writer = new CSVWriter(new FileWriter(csvFileName, true));
           writer.writeNext(data);
           writer.close();
           System.out.println("Record stored to file successfully");
           return true;

       }catch (Exception e){
           e.printStackTrace();
       }

       return false;
    }

    public void showCSVContent(String csvFileName)
    {
        String userDir=System.getProperty("user.dir");
        csvFileName=userDir+"/"+csvFileName;
        CSVReader csvReader=null;
        try {
            csvReader = new CSVReader(new FileReader(csvFileName));

            String[] record = null;
            int i=1;
            while ((record = csvReader.readNext()) != null) {
                System.out.print(i+"\t");
                for(String col:record){
                    System.out.print(col+"\t");
                }
                System.out.println();
                i++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public String[] readData(String filename){
        String contents="";
        if(filename.equalsIgnoreCase("studied.csv")){
            contents="studied";
        }else{
            contents="reffred";
        }
        Scanner sc=null;
        try{
            sc= new Scanner(System.in);
        }catch(Exception e){
            e.printStackTrace();
        }

        String[] data= new String[8];


        String choice="";

        System.out.println("Enter the name of subject/topic");
        data[0]= sc.nextLine();
        System.out.println("Enter current year");
        data[1]= sc.nextLine();
        System.out.println("Enter current month");
        data[2]= sc.nextLine();
        System.out.println("Enter today's date");
        data[3]= sc.nextLine();
        System.out.println("Enter the contents that you "+contents);
        data[4]= sc.nextLine();
        System.out.println("Enter the Time spent in minutes for this subject/topic");
        data[5]= sc.nextLine();
        System.out.println("Purpose solved? (Enter one of these: yes/no/partially)");
        data[6]= sc.nextLine();
        System.out.println("Enter the web page url/ book name/ pdf link");
        data[7]= sc.nextLine();

        return data;
    }
}
