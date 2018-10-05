package com.ct;

/**
 * @ Author     ：Cao Tuo
 * @ Date       ：Created in 16:20 2018/10/5
 * @ Description：
 */
public class Numberof1Bits {

    public static void main(String[] args){
        Numberof1Bits numberof1Bits = new Numberof1Bits();
        int n = 3;
        System.out.println(numberof1Bits.hammingWeight(n));
    }

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int counter = 0;
        int temp;
        for(int i=0;i<32;i++){
            temp = n&1;
            if(temp == 1){
                counter++;
            }
            n >>= 1;
        }
        return counter;
    }
}
