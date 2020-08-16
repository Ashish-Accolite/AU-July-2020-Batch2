package com.company;

import java.io.File;

public class Main {

    static void recursiveFilePrint(File[] arr){
        for(File file : arr){
            if(file.isDirectory() && file.exists()){
                recursiveFilePrint(file.listFiles());
            }
            else{
                if(file.exists()) {
                    System.out.println("FILE DISCOVERED: " + file.getName());
                }
            }
        }
    }
    public static void main(String[] args) {
	    String directoryPath = "/Users/ashishsamanta/Desktop/mid";
	    File mainDir = new File(directoryPath);
	    if(mainDir.exists() && mainDir.isDirectory()){
	        recursiveFilePrint(mainDir.listFiles());
        }
	    else{
	        if(mainDir.exists()){
	            System.out.println(mainDir.getName());
            }
	        else{
	            System.out.println("No files exist");
            }
        }
    }
}
