package com.ct;

/**
 * @ Author     ：Cao Tuo
 * @ Date       ：Created in 19:01 2018/10/7
 * @ Description：LeetCode-264. Ugly Number II
 */
public class UglyNumberII {

    public static void main(String[] args){
        int n = 441;
        System.out.println(new UglyNumberII().nthUglyNumber(n));
    }

    public int nthUglyNumber(int n) {
        int counter = 0;
        for(int i=1;;i++){
            if(isUgly(i)){
                counter++;
                if(counter == n){
                    return i;
                }
            }
        }
    }

    public boolean isUgly(int num) {
        for(int i=2;i<6&&num>1;i++){
            while(num%i == 0){
                num /= i;
            }
        }
        return num==1;
    }

    // excellent solution
    public int nthUglyNumber_V2(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for(int i=1;i<n;i++){
            int min = Math.min(Math.min(factor2,factor3),factor5);
            ugly[i] = min;
            if(factor2 == min)
                factor2 = 2*ugly[++index2];
            if(factor3 == min)
                factor3 = 3*ugly[++index3];
            if(factor5 == min)
                factor5 = 5*ugly[++index5];
        }
        return ugly[n-1];
    }
}
