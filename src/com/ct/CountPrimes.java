package com.ct;

/**
 * @ Author     ：Cao Tuo
 * @ Date       ：Created in 13:40 2018/10/7
 * @ Description：LeetCode-204. Count Primes
 */
public class CountPrimes {

    public static void main(String[] args){
        int n = 499979 ;
        System.out.println(new CountPrimes().countPrimes_V2(n));
    }

    // time limit exceeded
    public int countPrimes(int n) {
        int counter = 0;
        for(int i=1;i<n;i++){
            if(isPrime(i)){
                counter++;
            }
        }
        return counter;
    }
    public boolean isPrime(int n){
        if( n <= 3){
            return n>1;
        }else{
            for(int i=2;i<=Math.sqrt(n);i++){
                if(n%i == 0){
                    return false;
                }
            }
            return true;
        }
    }

    public int countPrimes_V2(int n){
        boolean[] notPrime = new boolean[n];
        int counter = 0;
        for(int i=2;i<n;i++){
            if(!notPrime[i]){
                counter++;
                for(int j=2;i*j<n && i*j>0;j++){
                    notPrime[i*j] = true;
                }
            }
        }
        return counter;
    }
}
