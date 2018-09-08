package com.ct;

/**
 * @ Author     ：Cao Tuo
 * @ Date       ：Created in 14:42 2018/9/8
 * @ Description：
 */
public class BackspaceStringCompare {

    public static void main(String[] args){
        String S = "ab#c";
        String T = "ad#c";
        System.out.println(new BackspaceStringCompare().backspaceCompare(S,T));
    }
    public boolean backspaceCompare(String S, String T) {

        String s = getString(S);
        String t = getString(T);
        return s.equals(t);
        
    }
    
    private String getString(String S){
        StringBuffer sb = new StringBuffer();
        for(int i = 0;i<S.length();i++){
            if(S.charAt(i) != '#'){
                sb.append(S.charAt(i));
            }else{
                if(sb.length()!=0){
                    sb.deleteCharAt(sb.length()-1);
                }
            }
        }
        return sb.toString();
    }
}
