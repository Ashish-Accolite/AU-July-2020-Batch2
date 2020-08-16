package com.company;

import java.util.ArrayList;
import java.util.stream.Collectors;

class Person{
    int age;
    String name;

    public Person(int age, String name){
        this.age = age;
        this.name = name;
    }
}

public class Main {
    public static void main(String[] args) {

        Integer countMe = 0;
        final Integer finalCountMe = 1;
        Integer size = 10;
        ArrayList<Person> arrayList = new ArrayList<>();
        arrayList.add(new Person(10,"Ashish"));
        arrayList.add(new Person(20,"Rishav"));

        arrayList.stream().forEach( element -> {
            //The following are final, effectively final and
            //local variables which if used will throw errors, To check out errors uncomment the variables

            //*********************************************
            // ++countMe; //Not final So can't use inside lambda expression
           // ++finalCountMe // It is final so it is allowed inside lambda expression but since it is final we can't update
           // int someVar = size; //Size is allowed inside because after declaration we haven't changed value of size
                                //so it is effectively final and can be used inside

            //*************************************************

            element.age += 1; //Adding 1 to Age which is the instance variable

        });

        System.out.println(arrayList.get(0).age); //The instance variable age of first element of the arrayList was 10
                                                  //before applying the stream API but after applying we have successfully
                                                  //increased count by 1 to 11
    }
}
