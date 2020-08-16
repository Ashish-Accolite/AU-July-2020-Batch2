package com.company;

class PrimeNumberException extends Exception{
    public PrimeNumberException(String str){
        super(str);
    }
}
public class Main {

    public static void main(String[] args){
        for(int i=1; i<= 100; ++i){
            try{
                if(isPrime(i) == true) {
                    throw new PrimeNumberException("Prime Number Caught: " + i);
                }
            }
            catch(PrimeNumberException primeNumberException){
                System.out.println(primeNumberException.getMessage());
            }
        }
    }

    static boolean isPrime(int num){
        if(num == 1){
            return false;
        }
        for(int i=2;i <= Math.floor(Math.sqrt(num)); ++i){
            if(num%i == 0){
                return false;
            }
        }
        return true;
    }
}

