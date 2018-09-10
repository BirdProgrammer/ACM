package com.ct;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：Cao Tuo
 * @ Date       ：Created in 20:05 2018/9/10
 * @ Description：LeetCode-54. Spiral Matrix
 */
public class SpiralMatrix {

    public static void main(String[] args){
        int matrix[][] = {{1,2,3,4,5,6,7,8,9,10},{11,12,13,14,15,16,17,18,19,20}};
        System.out.println(new SpiralMatrix().spiralOrder(matrix));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if(matrix == null || matrix.length==0){
            return list;
        }else{
            spiralOrder(matrix,0,list);
            return list;
        }
    }
    public void spiralOrder(int[][] matrix,int layer,List<Integer> list) {
        if(layer<matrix.length/2 && layer<matrix[0].length/2){
            for(int i=layer;i<matrix[0].length-layer;i++){
                list.add(matrix[layer][i]);
            }
            for(int i=layer+1;i<matrix.length-layer;i++){
                list.add(matrix[i][matrix[0].length-layer-1]);
            }
            for(int i=matrix[0].length-layer-2;i>=layer;i--){
                list.add(matrix[matrix.length-layer-1][i]);
            }
            for(int i=matrix.length-layer-2;i>layer;i--){
                list.add(matrix[i][layer]);
            }
            spiralOrder(matrix,layer+1,list);
        }else if(layer==matrix.length/2 && layer<matrix[0].length/2 && matrix.length%2!=0){
            for(int i=layer;i<matrix[0].length-layer;i++){
                list.add(matrix[layer][i]);
            }
        }else if(layer<matrix.length/2 && layer==matrix[0].length/2 && matrix[0].length%2!=0){
            for(int i=layer;i<matrix.length-layer;i++){
                list.add(matrix[i][matrix[0].length-layer-1]);
            }
        }else if(layer==matrix.length/2 && layer==matrix[0].length/2 && matrix.length%2!=0 && matrix[0].length%2!=0){
            list.add(matrix[layer][layer]);
        }
    }
}
