package com.ct;

/**
 * @ Author     ：Cao Tuo
 * @ Date       ：Created in 17:22 2018/10/5
 * @ Description：LeetCode-213. House Robber II
 */
public class HouseRobberII {

    public int rob(int[] nums) {
        int length = nums.length;
        if(length == 0){
            return 0;
        }else if(length == 1){
            return nums[0];
        }
        // assume the last house is not stolen
        // rows mean the index of the houses, column 0 means not stealing, column 1 means stealing
        int[][] record = new int[length][2];
        record[0][0] = 0;
        record[0][1] = nums[0];
        for(int i=1;i<length-1;i++){
            record[i][0] = record[i-1][0]>record[i-1][1] ? record[i-1][0] : record[i-1][1];
            record[i][1] = record[i-1][0]+nums[i];
        }
        record[length-1][0] = record[length-2][0]>record[length-2][1] ? record[length-2][0] : record[length-2][1];

        // assume the last house is stolen
        // rows mean the index of the houses, column 0 means not stealing, column 1 means stealing
        record[0][0] = 0;
        record[0][1] = 0;
        for(int i=1;i<length-1;i++){
            record[i][0] = record[i-1][0]>record[i-1][1] ? record[i-1][0] : record[i-1][1];
            record[i][1] = record[i-1][0]+nums[i];
        }
        record[length-1][1] = record[length-2][0]+nums[length-1];
        return Math.max(record[length-1][0],record[length-1][1]);
    }
}
