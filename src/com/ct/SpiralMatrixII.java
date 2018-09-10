package com.ct;

import java.util.Arrays;

/**
 * @ Author     ：Cao Tuo
 * @ Date       ：Created in 21:02 2018/9/10
 * @ Description：LeetCode-59. Spiral Matrix II
 */
public class SpiralMatrixII {

    public static void main(String[] args){
        int n =5;
        int[][] ans = new SpiralMatrixII().generateMatrix(n);
        for(int i=0;i<n;i++){
            System.out.println(Arrays.toString(ans[i]));
        }
    }

    public int[][] generateMatrix(int n) {
        int ans[][] = new int[n][n];
        int directions[][] = {{0,1},{1,0},{0,-1},{-1,0}};
        int index = 0;
        int counter = 1;
        int max = n*n;
        int i=0,j=0;
        while(counter <= max){
            while(i<n && j<n && i>=0 && j>=0 && ans[i][j] == 0){
                ans[i][j] = counter++;
                i += directions[index][0];
                j += directions[index][1];
            }
            switch (index){
                case 0:i++;j--;break;
                case 1:i--;j--;break;
                case 2:i--;j++;break;
                case 3:i++;j++;break;
            }
            index = (index+1)%4;
        }
        return ans;
    }
}
