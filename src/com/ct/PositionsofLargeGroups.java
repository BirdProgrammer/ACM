package com.ct;

import java.util.LinkedList;
import java.util.List;

/**
 * @ Author     ：Cao Tuo
 * @ Date       ：Created in 22:22 2018/9/8
 * @ Description：LeetCode-830. Positions of Large Groups
 */
public class PositionsofLargeGroups {

    public static void main(String[] args){
        String s = "aaa";
        System.out.println(new PositionsofLargeGroups().largeGroupPositions(s));
    }

    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> ans = new LinkedList<>();
        int length = 1;
        int start = 0;
        List<Integer> list = new LinkedList<>();
        for(int i=1;i<S.length();i++){
            if(S.charAt(i-1) == S.charAt(i)){
                length++;
            }else{
                if(length>=3){
                    list.add(start);
                    list.add(i-1);
                    ans.add(list);
                    list = new LinkedList<>();
                }
                length = 1;
                start = i;
            }
        }
        if(length>=3){
            list.add(start);
            list.add(S.length()-1);
            ans.add(list);
        }
        return ans;
    }
}
