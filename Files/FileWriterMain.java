package Files;

import java.io.*;
import java.util.Date;
import java.util.Scanner;
import java.io.IOException;
import java.text.SimpleDateFormat;
public class FileWriterMain {

    public static void main(String[] args) throws IOException {
        FileWriterMain.readFromFile();
        FileWriterMain fileWriterMain = new FileWriterMain();


        FileWriterMain fileWriterMain1 = new FileWriterMain();
        fileWriterMain1.appendData("");
    }

    public static void appendData(String data) throws IOException {
        File myFile = new File("transaction.txt");
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(myFile, true);  // Set the second parameter to true for append mode
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        PrintWriter printWriter = new PrintWriter(bufferedWriter);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateTime = dateFormat.format(new Date());
        String line = dateTime + " - " + data;
        printWriter.println(line);  // Write the transaction data
        printWriter.close();
        bufferedWriter.close();
        fileWriter.close();
    }

    public static void writeData(String data, String fileName) {
        try {
            FileWriter writeToFile = new FileWriter(fileName, true);

            writeToFile.write(data);
            writeToFile.append("");
            writeToFile.flush();
            writeToFile.close();

        } catch (IOException ioException) {
            System.out.println("Can not write to this file");
        }
    }

    public static void readFromFile() {
        File myFile = new File("transaction.txt");
        try {
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNext()) {
                String dataInFile = myReader.nextLine();
                System.out.println(dataInFile);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist");
        }
    }

}
