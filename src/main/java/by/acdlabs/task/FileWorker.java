package by.acdlabs.task;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWorker {
    public static List<List<String>> readFromFile(String fileName) throws IOException {
        File inputFile = new File((fileName));
        FileReader fileReader = new FileReader(inputFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String[] records;
        String line;

        List<List<String>> list = new ArrayList<>();
        List<String> stringOfRecords;

        while ((line = bufferedReader.readLine()) != null) {
            stringOfRecords = new ArrayList<>();
            records = line.split("\t");
            Collections.addAll(stringOfRecords, records);
            list.add(stringOfRecords);
        }

        bufferedReader.close();
        fileReader.close();

        return list;
    }
    public static void writeToFile(String fileName,List<List<String>> list) throws IOException {
        File outputFile = new File(fileName);
        FileWriter fileWriter = new FileWriter(outputFile);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(prepareToWrite(list));
        bufferedWriter.close();
        fileWriter.close();
    }
    private static String prepareToWrite(List<List<String>> list){
        StringBuilder result = new StringBuilder();

        list.forEach(record -> {
            record.forEach(columnRecord -> {
                result.append(columnRecord).append("\t");
            });
            result.append("\n");
        });

        return result.toString();
    }
}
