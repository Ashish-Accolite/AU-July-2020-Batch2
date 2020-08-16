package com.company;

import com.sun.source.tree.Tree;

import java.util.*;

public class Main {

    public static <K,V> void sortByKeys(Map<K,V> map){

       if(map.getClass().getName() == "java.util.TreeMap"){
            System.out.print("Tree Map Before Reversal: ");
            System.out.println(map);
            TreeMap<K,V> treeMap = (TreeMap<K,V>)map;
            System.out.print("Reversed Tree Map After Reversal: ");
            System.out.println(treeMap.descendingMap());
        }
       else if(map.getClass().getName() == "java.util.LinkedHashMap"){
           System.out.print("Linked Hash Map Before Reversal: ");
           System.out.println(map);
           LinkedHashMap<K,V> linkedHashMap = new LinkedHashMap<>();
           List<K> keys = new ArrayList<K>(map.keySet());
           Collections.reverse(keys);
           ListIterator<K> itr = keys.listIterator();
           while(itr.hasNext()){
               K key = itr.next();
               linkedHashMap.put(key,map.get(key));
           }
           System.out.print("Reversed Linked Hash Map After Reversal: ");
           System.out.println(linkedHashMap);
       }
       else {
           System.out.print("Other Maps don't have a fixed order hence reversing them doesn't make sense");
       }
    }

    public static void main(String[] args) {
        TreeMap<String,String> treeMap = new TreeMap<>();
        treeMap.put("Noida","India");
        treeMap.put("los Angeles","Usa");
        treeMap.put("Bangalore","India");
        treeMap.put("Paris","France");
        sortByKeys(treeMap);
        LinkedHashMap<String,String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("aa","bb");
        linkedHashMap.put("cc","dd");
        linkedHashMap.put("rr","qq");
        sortByKeys(linkedHashMap);
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("something","else");
        sortByKeys(hashMap);
    }
}
