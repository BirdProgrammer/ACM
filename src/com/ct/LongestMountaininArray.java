package com.ct;

/**
 * @ Author     ：Cao Tuo
 * @ Date       ：Created in 14:56 2018/9/8
 * @ Description：
 */
public class LongestMountaininArray {

    public static void main(String[] args){
        int[] A = new int[]{9,8,7,3,2,1,0};
        System.out.println(new LongestMountaininArray().longestMountain(A));
    }

    public int longestMountain(int[] A) {
        int maxLength = 1;
        boolean up = true;
        int length = 1;
        for(int i=1;i<A.length;i++){
            if(up){
                if(A[i-1]<A[i]) {
                    length++;
                }else if(A[i-1] == A[i]){
                    if(length > maxLength){
                        maxLength = length;
                    }
                    up = true;
                    length=1;
                }else {
                    if(length != 1){
                        up = false;
                        length++;
                    }
                }
            }else{
                if(A[i-1]>A[i]){
                    length++;
                }else{
                    if(length > maxLength){
                        maxLength = length;
                    }
                    up = true;
                    if(A[i-1] == A[i]){
                        length = 1;
                    }else{
                        length =2;
                    }
                }
            }
            //System.out.println(length);
        }
        if(!up) {
            maxLength = length > maxLength ? length : maxLength;
        }
        return maxLength>=3 ? maxLength:0;
    }
}
