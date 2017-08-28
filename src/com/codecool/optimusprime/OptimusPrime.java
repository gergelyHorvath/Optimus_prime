package com.codecool.optimusprime;

import java.util.List;
import java.util.ArrayList;
import java.util.BitSet;

public class OptimusPrime {

    private int finalNumberInList;

    private OptimusPrime(int num){
        this.finalNumberInList = num;
    }

    private int numberOfPrimes(){
        int n = this.finalNumberInList + 1;

        // create a BitSet object representing our list of numbers
        BitSet bits = new BitSet(n);
        bits.set(1, n);
        for (int i = 2; i < Math.sqrt(n); i++){
            for (int j = 2 * i; j <= n; j += i){
                bits.clear(j);
            }
        }
        //System.out.println(bits);
        return bits.cardinality();
    }

    private int numberOfPrimes2(){
        int n = this.finalNumberInList;
        List<Integer> primes = new ArrayList<>();
        primes.add(2);
        for (int num = 3; num <= n; num += 2){
            boolean isPrime = false;
            for (Integer prime: primes){
                if (prime > Math.sqrt(num)){
                    isPrime = true;
                    break;
                }
                if (num % prime == 0) break;
            }
            if (isPrime) primes.add(num);
        }
        //System.out.println(primes);
        return primes.size() + 1;
    }

    public static void main(String[] args) {
        OptimusPrime numbers = new OptimusPrime(100000000);
        System.out.println(numbers.numberOfPrimes());
        //System.out.println(numbers.numberOfPrimes2());
    }
}
