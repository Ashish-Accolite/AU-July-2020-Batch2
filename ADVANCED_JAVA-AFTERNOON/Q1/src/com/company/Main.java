package com.company;


class SquaredClass{

    public static int getAreaStatic(int x){
        return x*x;
    }

    public int getAreaInstance(int x) {
        return x*x;
    }
}

class Messaged{
    public Messaged(String str){
        System.out.println("Functional Interface Instantiation Using Constructor: " + str);
    }
}
public class Main {

    @FunctionalInterface
    public interface Square{
        int calculate(int x);
    }

    @FunctionalInterface
    public interface Message{
        void sendMessage(String str);
    }

    public static void main(String[] args) {
        Square lambdaMethod = (int x) -> x*x;
        System.out.println("Functional Interface Instantiation Using Lambda Expression: " + lambdaMethod.calculate(2));

        Square staticMethod = SquaredClass::getAreaStatic;
        System.out.println("Functional Interface Instantiation Using Static Method: " + staticMethod.calculate(3));

        SquaredClass squaredObject = new SquaredClass();
        Square instanceMethod = squaredObject::getAreaInstance;
        System.out.println("Functional Interface Instantiation Using Instance Method: " + instanceMethod.calculate(4));

        Message messageObject = Messaged::new; //Using Constructor Reference
        messageObject.sendMessage("Hello World");
    }

}
