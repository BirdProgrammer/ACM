package com.ct;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @ Author     ：Cao Tuo
 * @ Date       ：Created in 21:10 2018/9/22
 * @ Description：LeetCode-20. Valid Parentheses
 */
public class ValidParentheses {

    public static void main(String[] args){
        String s = "[";
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid(s));
    }
    public boolean isValid(String s) {
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c=='{' || c=='[' || c=='('){
                stack.push(c);
            }else{
                if(!stack.empty() && map.get(c)!=null && map.get(c) == stack.pop()){
                    continue;
                }else{
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
