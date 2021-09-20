package by.acdlabs.task;

import java.io.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<List<String>> records;
        try {
            records = FileWorker.readFromFile("src/main/resources/in.txt");
            records.sort(RecordComparator::compare);
            FileWorker.writeToFile("src/main/resources/out.txt",records);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
