package com.ct;

import java.util.*;

public class FindAllDuplicatesInAnArray {
    public List<Integer> findDuplicates(int[] nums) {

        List<Integer> ans = new LinkedList<>();
        int[] array = new int[nums.length+1];

        for(int num : nums){
            array[num]++;
        }

        for(int i = 0;i < array.length;i++){
            if(array[i]==2){
                ans.add(i);
            }
        }

        return ans;
    }
}
