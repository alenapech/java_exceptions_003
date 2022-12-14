package com.alenapech;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static final int DATA_COUNT = 6;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input string (<Last Name> <First Name> <Middle Name> <Birth Date> (dd.mm.yyyy) <Phone Number> (f.g. 71233211122) <Gender (f/m)>)");
        String inputString = input.nextLine();
        saveData(getDataRow(inputString));
    }

    private static void saveData(DataRow dataRow) {
        try (FileWriter fileWriter = new FileWriter(dataRow.getLastName(), true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) { // .close()/final block is not needed here
            bufferedWriter.write(dataRow.toString());
            bufferedWriter.newLine();
        } catch (IOException e) {
            throw new BusinessException("Writing to the file was failed", e, 1009);
        }
    }

    private static DataRow getDataRow(String inputString) {
        // Note, we can't get data in random order since we don't have ability to determine if we get first name
        // or last name etc. (all these fields are strings without any template)
        String[] inputArr = inputString.split(" ");
        checkDataCount(inputArr);
        DataRow dataRow = new DataRow(inputArr[0], inputArr[1], inputArr[2], inputArr[3], inputArr[4], inputArr[5]);
        System.out.println(dataRow);
        return dataRow;
    }

    private static void checkDataCount(String[] stringArr) {
        if (stringArr.length > DATA_COUNT) {
            throw new BusinessException("Input string has more values then needed", 1001);
        }
        if (stringArr.length < DATA_COUNT) {
            throw new BusinessException("Input string has less values then needed", 1002);
        }
    }
}
