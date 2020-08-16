package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Collectors;

class Product{
    int id;
    String category;
    Double price;
    String name;

    Product(int id,String category,Double price,String name){
        this.id = id;
        this.category = category;
        this.price = price;
        this.name = name;
    }
}

class ProductFactory{
    ArrayList<Product> productList;

    public ProductFactory(){
        productList = new ArrayList<>();
    }

    void createAndAssign(){
        productList.add(new Product(1,"IT",1000.50,"Laptop"));
        productList.add(new Product(2,"IT",700.0,"Phone"));
        productList.add(new Product(3,"Vehicle",500.0,"Bike"));
        productList.add(new Product(5,"Vehicle",1500.50,"Car"));
        productList.add(new Product(4,"Home",300.20,"Washing Machine"));
        productList.add(new Product(2,"IT",100.0,"Mouse"));
    }
}

class PriceTrack{
    Double lowerBound;
    Double upperBound;
    PriceTrack(Double lowerBound,Double upperBound){
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }
}

public class Main {

    static void printArrayList(ArrayList<Product> resultList){
        for(Product element : resultList){
            System.out.print("Id: " + element.id);
            System.out.print(" | Category: " + element.category);
            System.out.print(" | Name: " + element.name);
            System.out.println(" | Price: " + element.price);
        }
    }

    static void printCategoryBounds(HashMap<String,PriceTrack> categoryPriceMap){
       for(Map.Entry<String,PriceTrack> element : categoryPriceMap.entrySet()){
            System.out.println(element.getKey() + " | LowerBound: " + element.getValue().lowerBound + " | UpperBound: " + element.getValue().upperBound);
       }

    }

    public static void main(String[] args) {
        HashMap<String,PriceTrack> categoryPriceMap = new HashMap<>();
        PriceTrack filterPrice = new PriceTrack(400.52,800.90);
        ProductFactory productFactory = new ProductFactory();
        productFactory.createAndAssign();
        ArrayList<Product> resultList = productFactory.productList.stream().filter(product -> {
            if(categoryPriceMap.containsKey(product.category)){
                Double lb = categoryPriceMap.get(product.category).lowerBound;
                Double hb = categoryPriceMap.get(product.category).upperBound;
                categoryPriceMap.get(product.category).lowerBound = lb > product.price ? product.price : lb;
                categoryPriceMap.get(product.category).upperBound = hb > product.price ? hb : product.price;
            }
            else{
                categoryPriceMap.put(product.category, new PriceTrack(product.price, product.price));
            }
            return product.price > filterPrice.lowerBound && product.price < filterPrice.upperBound;
        }).collect(Collectors.toCollection(ArrayList::new));
        System.out.println("Original List->");
        printArrayList(productFactory.productList);
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("Total Categories: " + categoryPriceMap.size());
        System.out.println("-----------------------------------------------------------------------------------------");
        printCategoryBounds(categoryPriceMap);
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("Filtered List->");
        printArrayList(resultList);
    }
}
