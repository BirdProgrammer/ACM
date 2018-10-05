package com.ct;

/**
 * @ Author     ：Cao Tuo
 * @ Date       ：Created in 16:40 2018/10/5
 * @ Description：LeetCode-198. House Robber
 */
public class HouseRobber {

    public static void main(String[] args){
        HouseRobber houseRobber = new HouseRobber();
        int[] nums = {1,2,3,1};
        System.out.println(houseRobber.rob(nums));
    }

    // DP
    public int rob(int[] nums) {
        int length = nums.length;
        if(length == 0){
            return 0;
        }
        // rows mean the index of the houses, column 0 means not stealing, column 1 means stealing
        int[][] record = new int[length][2];
        record[0][0] = 0;
        record[0][1] = nums[0];
        for(int i=1;i<length;i++){
            record[i][0] = record[i-1][0]>record[i-1][1] ? record[i-1][0] : record[i-1][1];
            record[i][1] = record[i-1][0]+nums[i];
        }
        return record[length-1][0]>record[length-1][1] ? record[length-1][0] : record[length-1][1];
    }
}
