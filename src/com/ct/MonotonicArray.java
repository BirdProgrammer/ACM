package com.ct;

/**
 * @ Author     ：Cao Tuo
 * @ Date       ：Created in 16:36 2018/9/8
 * @ Description：判断一个数组是否单调
 */
public class MonotonicArray {

    public static void main(String[] args){
        int[] A = new int[]{4,4,4,3,2,1,5};
        System.out.println(new MonotonicArray().isMonotonic(A));
    }

    public boolean isMonotonic(int[] A) {
        // direct=1,表示单调递增，direct=-1,表示单调递减，direct=0,表示未知
        int direct = 0;
        for(int i=0;i<A.length-1;i++){
            if(A[i] == A[i+1]){
                continue;
            }else if(A[i] < A[i+1]){
                if(direct == -1){
                    return false;
                }else if(direct == 0){
                    direct = 1;
                }
            }else{
                if(direct == 1){
                    return false;
                }else if(direct == 0){
                    direct = -1;
                }
            }
        }
        return true;
    }
}
