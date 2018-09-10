package com.ct;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @ Author     ：Cao Tuo
 * @ Date       ：Created in 23:13 2018/9/10
 * @ Description：LeetCode-62. Unique Paths
 */
public class UniquePaths {

    public static void main(String[] args){
        UniquePaths uniquePaths = new UniquePaths();

        for(int m=1;m<=100;m++){
            for(int n=1;n<100;n++){
                System.out.println("m="+m+"\tn="+n+":\t"+uniquePaths.uniquePaths_V3(m,n));
            }
        }
    }

    // 递归,Time Limit Exceeded,
    public int uniquePaths(int m, int n) {
        return C(m-1+n-1,m-1);
    }
    public int C(int foot,int head){

        if(foot == head){
            return 1;
        }else if(foot<=0 || head<0){
            return 0;
        }else if(head == 0){
            return 1;
        }else if(head ==1){
            return foot;
        }else{
            return C(foot-1,head-1)+C(foot-1,head);
        }
    }
    // 递推，通过，但是效果不好
    public int uniquePaths_V2(int m, int n) {
        if(m==0 || n==0){
            return 0;
        }
        return YHTrangle(m+n-2,m-1);
    }

    public int YHTrangle(int m,int n){
        if(m==0){
            return 1;
        }
        LinkedList<Integer> queue = new LinkedList<Integer>();
        int layer = 0;
        int index = 0;
        int t1=0,t2=0;
        boolean flag = true;
        queue.offer(0);
        queue.offer(1);
        queue.offer(0);
        while(flag){
            layer++;
            queue.offer(0);
            index = 0;
            t1 = queue.poll();
            t2 = -1;
            while(t2!=0){
                t2 = queue.poll();
                if(layer==m && index==n){
                    flag = false;
                    break;
                }
                queue.offer(t1+t2);
                t1 = t2;
                index++;
            }
            queue.offer(0);
        }
        return t1+t2;
    }

    // best solution
    public int uniquePaths_V3(int m, int n) {
        int array[][] = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(array[i],-1);
        }
        return uniquePaths_V3(m-1,n-1,array);
    }
    public int uniquePaths_V3(int m, int n,int[][] array){
        if(m<0 || n<0){
            return 0;
        }
        if(m==0 && n==0){
            return 1;
        }
        if(array[m][n] == -1){
            array[m][n]  = uniquePaths_V3(m-1,n,array)+uniquePaths_V3(m,n-1,array);
        }
        return array[m][n];
    }
}
