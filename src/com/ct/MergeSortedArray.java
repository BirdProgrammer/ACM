package com.ct;

import java.util.Arrays;

/**
 * @ Author     ：Cao Tuo
 * @ Date       ：Created in 13:03 2018/9/12
 * @ Description：LeetCode-88. Merge Sorted Array
 */
public class MergeSortedArray {
    public static void main(String[] args){
        int nums1[] = {1,2,3,0,0,0};
        int nums2[] = {4,5,6};
        new MergeSortedArray().merge(nums1,3,nums2,3);
        System.out.println(Arrays.toString(nums1));
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int temp1[] = new int[m+1];
        int temp2[] = new int[n+1];
        int i=0,j=0;
        for(i=0;i<m;i++){
            temp1[i] = nums1[i];
        }
        temp1[i] = Integer.MAX_VALUE;
        for(i=0;i<n;i++){
            temp2[i] = nums2[i];
        }
        temp2[i] = Integer.MAX_VALUE;

        i = 0;
        j = 0;
        for(int k=0;k<n+m;k++){
            if(temp1[i]<=temp2[j]){
                nums1[k] = temp1[i++];
            }else{
                nums1[k] = temp2[j++];
            }
        }
        return;
    }
}
