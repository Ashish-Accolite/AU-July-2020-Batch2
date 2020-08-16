package com.company;

import java.io.File;
import java.io.IOException;

public class Main {

    static void recursiveFindAndDelete(File[] arr){
        for(File file : arr){
            if(file.isDirectory() && file.exists()){
                recursiveFindAndDelete(file.listFiles());
            }
            else{
                if(file.exists() && file.getName().contains("txt")){
                    try{
                        String fileName = file.getName();
                        if(file.delete()){
                            System.out.println("FILE DELETED: " + fileName);
                        }
                        else{
                            System.out.println("FILE COULDN'T BE DELETED: " + fileName);
                        }
                    }
                    catch(SecurityException exc){
                        exc.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        String directoryPath = "/Users/ashishsamanta/Desktop/mid";
        File mainDir = new File(directoryPath);

        if(mainDir.exists() && mainDir.isDirectory()){
            recursiveFindAndDelete(mainDir.listFiles());
        }
        else{
            if(mainDir.exists()){
                System.out.println("Not a Directory");
            }
            else {
                System.out.println("Does not exist");
            }
        }
    }
}
