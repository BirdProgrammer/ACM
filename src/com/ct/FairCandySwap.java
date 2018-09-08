package com.ct;

import java.util.HashSet;
import java.util.Set;

public class FairCandySwap {

    public int[] fairCandySwap(int[] A, int[] B) {

        int sumA = 0;
        for(int a : A){
            sumA += a;
        }

        int sumB = 0;
        Set<Integer> set = new HashSet<Integer>();
        for(int b : B){
            set.add(b);
            sumB += b;
        }

        int avg = (sumA+sumB)/2;

        for(int a : A){
            int dif = avg - (sumA - a);
            if(set.contains(dif)){
                return new int[]{a,dif};
            }
        }
        return null;
    }
}
