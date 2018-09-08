package com.ct;

import java.util.Stack;

/**
 * @ Author     ：Cao Tuo
 * @ Date       ：Created in 23:02 2018/9/8
 * @ Description：LeetCode-856. Score of Parentheses
 */
public class ScoreofParentheses {

    public static void main(String[] args){
        String S = "(())()()()";
        System.out.println(new ScoreofParentheses().scoreOfParentheses_V2(S));
    }

    public int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(char c : S.toCharArray()){
            if(c == '('){
                stack.push(0);
            }else if(c == ')'){
                int increasement = stack.pop();
                int base = stack.pop();
                base += Math.max(2*increasement,1);
                stack.push(base);
            }
        }
        return stack.pop();
    }

    int i=0;
    public int scoreOfParentheses_V2(String S) {
        int res=0;
        while(i<S.length()){
            char c=S.charAt(i++);
            if (c=='('){
                if (S.charAt(i)==')'){
                    res+=1;
                    i++;
                }else {
                    res+=2*scoreOfParentheses_V2(S);
                }
            }else {
                return res;
            }
        }
        return res;
    }
}
