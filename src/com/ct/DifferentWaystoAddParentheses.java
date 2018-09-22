package com.ct;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：Cao Tuo
 * @ Date       ：Created in 9:52 2018/9/21
 * @ Description：LeetCode-241. Different Ways to Add Parentheses
 */
public class DifferentWaystoAddParentheses {
    public static void main(String[] args){
        String input = "11";
        DifferentWaystoAddParentheses differentWaystoAddParentheses = new DifferentWaystoAddParentheses();
        System.out.println(differentWaystoAddParentheses.diffWaysToCompute(input));
    }
    public List<Integer> diffWaysToCompute(String input) {
        if(input.length() == 0){
            return new ArrayList<>();
        }else{
            List<String> inputs = new ArrayList<>();
            int temp = -1;
            for(int i=0;i<input.length();i++){
                char c = input.charAt(i);
                if(c>='0' && c<='9'){
                    continue;
                }else{
                    inputs.add(input.substring(temp+1,i));
                    inputs.add(String.valueOf(c));
                    temp = i;
                }
            }
            inputs.add(input.substring(temp+1,input.length()));
            return diffWaysToCompute(inputs.toArray(new String[input.length()]),0,inputs.size()-1);
        }
    }
    public List<Integer> diffWaysToCompute(String[] inputs,int left,int right) {
        List<Integer> list = new ArrayList<>();
        if(left == right){
            list.add(Integer.parseInt(inputs[left]));
        }else{
            for(int i=left;i<=right;i++){
                if(inputs[i].matches("[+-/*]")){
                    List<Integer> leftList = diffWaysToCompute(inputs,left,i-1);
                    List<Integer> rightList = diffWaysToCompute(inputs,i+1,right);
                    for(Integer num1 : leftList){
                        for(Integer num2 : rightList){
                            switch (inputs[i]){
                                case "+":list.add(num1+num2);break;
                                case "-":list.add(num1-num2);break;
                                case "*":list.add(num1*num2);break;
                            }
                        }
                    }
                }
            }
        }
        return list;
    }
}
