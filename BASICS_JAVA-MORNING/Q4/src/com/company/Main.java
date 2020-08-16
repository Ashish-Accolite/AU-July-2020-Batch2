package com.company;

import java.io.*;

class Student implements Serializable{
    private static final long serialversionUID = 129348938L;
    String name;
    int age;
    String course;
    transient Double cgpa;
    transient Boolean internshipDone;

    Student(String name, int age, String course, Double cgpa, Boolean internshipDone){
        this.name = name;
        this.age = age;
        this.course = course;
        this.cgpa = cgpa;
        this.internshipDone = internshipDone;
    }
}

public class Main {

    public static void printStudentObject(Student student){
        System.out.print("Name: " + student.name);
        System.out.print(" | Age: " + student.age);
        System.out.print(" | Course: " + student.course);
        System.out.print(" | Cgpa: " + student.cgpa);
        System.out.println(" | Internship Done: " + student.internshipDone);
    }

    public static void main(String[] args) {
        Student s1 = new Student("Ashish",22,"IT",8.32,true);
        String filePath = "/Users/ashishsamanta/Desktop/testFile.txt"; //Ensure File Location

        try{
            FileOutputStream fout = new FileOutputStream(filePath);
            ObjectOutputStream oout = new ObjectOutputStream(fout);
            oout.writeObject(s1);
            oout.close();
            fout.close();
            System.out.print("Object Serialization Complete: ");
            printStudentObject(s1);
        }
        catch(IOException exc) {
            System.out.println(exc.getMessage());
        }

        s1 = null;

        try{
            FileInputStream fin = new FileInputStream(filePath);
            ObjectInputStream oin = new ObjectInputStream(fin);
            s1 = (Student)oin.readObject();

            oin.close();
            fin.close();
            System.out.print("Object Deserialization Complete: ");
            printStudentObject(s1);
        }
        catch(IOException | ClassNotFoundException exc){
            System.out.println(exc.getMessage());
        }
    }
}
