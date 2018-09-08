package com.ct;

import org.jetbrains.annotations.NotNull;
import java.util.Arrays;
import java.util.Random;

/**
 * @ Author     ：Cao Tuo
 * @ Date       ：Created in 10:06 2018/9/7
 * @ Description：provide methods for sorting an array
 */
public class SortMethod {

    public static void main(String[] args){
        int[] A = new int[100000];
        long beforeTime;
        long afterTime;

        initArray(A);
        beforeTime = System.currentTimeMillis();
        SortMethod.SelectSort(A);
        afterTime = System.currentTimeMillis();
        System.out.println("选择排序用时："+(afterTime-beforeTime)+"ms");
        //show(A);

        initArray(A);
        beforeTime = System.currentTimeMillis();
        SortMethod.InsertSort(A);
        afterTime = System.currentTimeMillis();
        System.out.println("插入排序用时："+(afterTime-beforeTime)+"ms");
        //show(A);

        initArray(A);
        beforeTime = System.currentTimeMillis();
        SortMethod.BubbleSort(A);
        afterTime = System.currentTimeMillis();
        System.out.println("冒泡排序用时："+(afterTime-beforeTime)+"ms");
        //show(A);

        initArray(A);
        beforeTime = System.currentTimeMillis();
        SortMethod.QuickSort(A);
        afterTime = System.currentTimeMillis();
        System.out.println("快速排序用时："+(afterTime-beforeTime)+"ms");
        //show(A);

        initArray(A);
        beforeTime = System.currentTimeMillis();
        SortMethod.MergeSort(A);
        afterTime = System.currentTimeMillis();
        System.out.println("归并排序用时："+(afterTime-beforeTime)+"ms");
        //show(A);
    }

    public static void initArray(@NotNull int[] A){
        Random random = new Random(0);
        for(int i=0;i<A.length;i++){
            A[i] = (int)(random.nextFloat()*10000);
        }
    }
    // 选择排序
    public static void SelectSort(@NotNull int[] A){
        for(int i=0;i<A.length;i++){
            int min = A[i];
            int index = i;
            for(int j=i+1;j<A.length;j++){
                if(min > A[j]){
                    min = A[j];
                    index = j;
                }
            }
            if(index != i){
                swap(A,i,index);
            }
        }
    }
    // 插入排序
    public static void InsertSort(@NotNull int[] A){
        for(int i=1;i<A.length;i++){
            for(int j=i-1;j>=0;j--){
                if(A[j] > A[j+1]){
                    swap(A,j,j+1);
                }else{
                    break;
                }
            }
        }
    }
    // 冒泡排序
    public static void BubbleSort(@NotNull int[] A){
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A.length-i-1;j++){
                if(A[j] > A[j+1]){
                    swap(A,j,j+1);
                }
            }
        }
    }
    // 快速排序
    public static void QuickSort(@NotNull int[] A){
        QuickSort(A,0,A.length-1);
    }
    public static void QuickSort(@NotNull int[] A,int left,int right){
        if(left > right){
            return;
        }
        int key = A[left];
        int l = left;
        int r = right;
        while(l<r){
            while(key <= A[r] && l<r){
                r--;
            }
            A[l] = A[r];
            while(key > A[l] && l<r){
                l++;
            }
            A[r] = A[l];
        }
        A[l] = key;
        QuickSort(A,left,l-1);
        QuickSort(A,l+1,right);
    }
    // 归并排序
    public static void MergeSort(@NotNull int[] A){
        MergeSort(A,0,A.length-1);
    }
    public static void MergeSort(@NotNull int[] A,int left,int right){
        if(left >= right){
            return;
        }
        MergeSort(A,left,(left+right)/2);
        MergeSort(A,(left+right)/2+1,right);
        merge(A,left,(left+right)/2,right);
    }
    private static void merge(int[] A,int p,int q,int r){
        int[] leftArray = new int[q-p+2];
        int[] rightArray = new int[r-q+1];
        for(int i=0,j=p;j<=q;i++,j++){
            leftArray[i] = A[j];
        }
        leftArray[leftArray.length-1] = Integer.MAX_VALUE;
        for(int i=0,j=q+1;j<=r;i++,j++){
            rightArray[i] = A[j];
        }
        rightArray[rightArray.length-1] = Integer.MAX_VALUE;
        for(int i=0,j=0,k=p;k<=r;k++){
            if(leftArray[i]<=rightArray[j]){
                A[k] = leftArray[i];
                i++;
            }else{
                A[k] = rightArray[j];
                j++;
            }
        }
    }
    // swap A[i] with A[j]
    private static void swap(@NotNull int[] A, int i , int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    // show the elements of array A
    public static void show(int A[]){
        System.out.println(Arrays.toString(A));
    }
}
