package com.ct;
import java.util.Arrays;

/**
 * @ Author     ：Cao Tuo
 * @ Date       ：Created in 14:11 2018/10/5
 * @ Description：LeetCode-48. Rotate Image
 */
public class RotateImage {

    public static void main(String[] args){
        RotateImage rotateImage = new RotateImage();
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotateImage.rotate(matrix);
        for(int i=0;i<matrix.length;i++){
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    // an excellent solution at https://leetcode.com/problems/rotate-image/discuss/174991/Java-solution-without-copy-matrix
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        if(length <= 1){
            return;
        }else{
            for (int i=0;i<length/2;i++){
                for (int j=i;j<length-i-1;j++){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[length-1-j][i];
                    matrix[length-1-j][i] = matrix[length-1-i][length-1-j];
                    matrix[length-1-i][length-1-j] = matrix[j][length-1-i];
                    matrix[j][length-1-i] = temp;
                }
            }
        }
    }
}
