package com.company;

import java.io.*;
import java.nio.channels.FileChannel;

public class Main {

    private static void copyFileUsingChannel(File source, File dest) throws IOException {
        FileChannel sourceChannel = null;
        FileChannel destChannel = null;
            sourceChannel = new FileInputStream(source).getChannel();
            destChannel = new FileOutputStream(dest).getChannel();
            destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
            sourceChannel.close();
            destChannel.close();
    }

    public static void main(String[] args) {
        String filePath = "/Users/ashishsamanta/Desktop/mid/testFile.txt";
        String destPath = "/Users/ashishsamanta/Desktop/testFile.txt";
        try{
            copyFileUsingChannel(new File(filePath),new File(destPath));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
