package com.company;

import java.io.*;
public class Main {

    static FileReader fileReader;
    static BufferedReader bufferedReader;
    static FileWriter fileWriter;
    static BufferedWriter bufferedWriter;

    public static void main(String[] args) {
        String filePath = "/Users/ashishsamanta/Desktop/mid/testFile.txt";
        String outFilePath = "/Users/ashishsamanta/Desktop/testFile.txt";
        try {
            fileReader = new FileReader(filePath);
            bufferedReader = new BufferedReader(fileReader);
            fileWriter = new FileWriter(outFilePath);
            bufferedWriter = new BufferedWriter(fileWriter);

            String currLine = bufferedReader.readLine();
            while(currLine != null){
                bufferedWriter.write(currLine);
                currLine = bufferedReader.readLine();
            }
        }
        catch(IOException exc){
            exc.printStackTrace();
        }
        finally {
            try{
                if(bufferedReader != null) {
                    bufferedReader.close();
                    bufferedReader = null;
                }
                if(fileReader != null){
                    fileReader.close();
                    fileReader = null;
                }
                if(bufferedWriter != null){
                    bufferedWriter.close();
                    bufferedWriter = null;
                }
                if(fileWriter != null){
                    fileWriter.close();
                    fileWriter = null;
                }
            }catch(IOException exc){
                exc.printStackTrace();
            }
        }
    }
}
