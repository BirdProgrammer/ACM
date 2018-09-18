package com.ct;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：Cao Tuo
 * @ Date       ：Created in 13:49 2018/9/18
 * @ Description：LeetCode-120. Triangle
 */
public class Triangle {

    public static void main(String[] args){
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(2);
        triangle.add(new ArrayList<>(list));
        list.clear();
        list.add(3);
        list.add(4);
        triangle.add(new ArrayList<>(list));
        list.clear();
        list.add(6);
        list.add(5);
        list.add(7);
        triangle.add(new ArrayList<>(list));
        list.clear();
        list.add(4);
        list.add(1);
        list.add(8);
        list.add(3);
        triangle.add(new ArrayList<>(list));
        System.out.println(triangle);
        System.out.println(new Triangle().minimumTotal_V2(triangle));
    }

    int minimumSum = Integer.MAX_VALUE;
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0){
            return 0;
        }else{
            minimumTotal(triangle,0,0,0);
            return minimumSum;
        }
    }
    public void minimumTotal(List<List<Integer>> triangle,int layer,int index,int sum) {
        int left = index;
        int right = index+1;
        sum += triangle.get(layer).get(index);
        layer+=1;
        if(layer == triangle.size()){
            minimumSum = Math.min(minimumSum,sum);
        }else{
            minimumTotal(triangle,layer,left,sum);
            minimumTotal(triangle,layer,right,sum);
        }
    }

    public int minimumTotal_V2(List<List<Integer>> triangle) {
        if (triangle.size() == 0){
            return 0;
        }else if(triangle.size() ==1 ) {
            return triangle.get(0).get(0);
        }else{
            int i,j,left,right;
            List<Integer> previous = new ArrayList<>();
            List<Integer> current = new ArrayList<>();
            previous.add(triangle.get(0).get(0));
            System.out.println(previous);
            for(i=1;i<triangle.size();i++){
                current.clear();
                current.add(previous.get(0)+triangle.get(i).get(0));
                for(j=1;j<triangle.get(i).size()-1;j++){
                    left = previous.get(j-1);
                    right = previous.get(j);
                    current.add(Math.min(left,right)+triangle.get(i).get(j));
                }
                current.add(previous.get(previous.size()-1)+triangle.get(i).get(j));
                previous = new ArrayList<>(current);
                System.out.println(previous);
            }
            int minimumSum = Integer.MAX_VALUE;
            for(i=0;i<current.size();i++){
                minimumSum = Math.min(minimumSum,current.get(i));
            }
            return minimumSum;
        }
    }

    // perfect answer
    public int minimumTotal_V3(List<List<Integer>> triangle) {
        int[] res = new int[triangle.size()+1];
        for(int i=triangle.size()-1; i>=0; i--){
            for(int j=0; j<triangle.get(i).size(); j++){
                res[j]=Math.min(res[j],res[j+1])+triangle.get(i).get(j);
            }
        }
        return res[0];
    }
}
