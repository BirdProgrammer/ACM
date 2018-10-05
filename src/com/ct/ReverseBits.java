package com.ct;

/**
 * @ Author     ：Cao Tuo
 * @ Date       ：Created in 15:52 2018/10/5
 * @ Description：LeetCode-190. Reverse Bits
 */
public class ReverseBits {

    public static void main(String[] args){
        int n = -2147483648;
        ReverseBits reverseBits = new ReverseBits();
        System.out.println(reverseBits.reverseBits(n));
    }

    public int reverseBits(int n) {
        int result = 0;
        for(int i=0;i<32;i++){
            result <<= 1;
            result += (n & 1);
            n >>= 1;
        }
        return result;
    }
}
