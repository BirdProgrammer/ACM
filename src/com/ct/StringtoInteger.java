package com.ct;

/**
 * @ Author     ：Cao Tuo
 * @ Date       ：Created in 10:21 2018/10/5
 * @ Description：LeetCode-8. String to Integer (atoi)
 */
public class StringtoInteger {

    public static void main(String[] args){
        String str = "2147483646";
        StringtoInteger stringtoInteger = new StringtoInteger();
        System.out.println(stringtoInteger.myAtoi(str));
    }

    public int myAtoi(String str) {
        int result = 0;
        int index = 0;
        boolean minus = false;
        while(index < str.length()){
            char c = str.charAt(index);
            if(c == ' '){

            }else if(c == '-' || c == '+'){
                if(index+1 < str.length() && str.charAt(index+1)<='9' && str.charAt(index+1)>='0'){
                    if(c == '-'){
                        minus = true;
                    }
                }else{
                    return 0;
                }
            }else if(c>='0' && c<='9'){
                while(index < str.length()){
                    c = str.charAt(index);
                    index++;
                    if(c>='0' && c<='9'){
                        if(minus){
                            if(result > -214748364) {
                                result = result*10-c+'0';
                            }else if( result == -214748364 && c<='8'){
                                return result*10-c+'0';
                            }else{
                                return Integer.MIN_VALUE;
                            }
                        }else{
                            if(result < 214748364) {
                                result = result*10+c-'0';
                            }else if( result == 214748364 && c<='7'){
                                return result*10+c-'0';
                            }else{
                                return Integer.MAX_VALUE;
                            }
                        }
                    }else{
                        break;
                    }
                }
                return result;
            }else{
                return result;
            }
            index ++;
        }
        return result;
    }
}