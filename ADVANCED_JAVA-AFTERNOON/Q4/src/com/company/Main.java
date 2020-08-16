package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for(int i =1; i<= 10; ++i){
            arrayList.add(i);
        }

        arrayList.stream().forEach(number -> {
            if(number > 4 && number < 7)return; //Using Return Keyword to skip conditionally
            System.out.println(number);
        });
    }
}
