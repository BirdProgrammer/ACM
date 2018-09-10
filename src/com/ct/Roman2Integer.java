package com.ct;

/**
 * @ Author     ：Cao Tuo
 * @ Date       ：Created in 15:19 2018/9/10
 * @ Description：LeetCode-13. Roman to Integer
 */
public class Roman2Integer {

    public static void main(String[] args){
        String s =  "III";
        System.out.println(new Roman2Integer().romanToInt_V2(s));
    }

    public int romanToInt(String s) {
        s = s.replaceAll("IV","IIII");
        s = s.replaceAll("IX","VIIII");
        s = s.replaceAll("XL","XXXX");
        s = s.replaceAll("XC","LXXXX");
        s = s.replaceAll("CD","CCCC");
        s = s.replaceAll("CM","DCCCC");
        System.out.println(s);
        int ans = 0;
        for(int i=0;i<s.length();i++){
            switch (s.charAt(i)){
                case 'M':ans+=1000;break;
                case 'D':ans+=500;break;
                case 'C':ans+=100;break;
                case 'L':ans+=50;break;
                case 'X':ans+=10;break;
                case 'V':ans+=5;break;
                case 'I':ans+=1;break;
            }
        }
        return ans;
    }

    public int romanToInt_V2(String s) {
        int ans = 0;
        int index = 0;
        while(index < s.length()-1){
            switch (s.charAt(index)){
                case 'M':ans+=1000;break;
                case 'D':ans+=500;break;
                case 'C':
                    if(s.charAt(index+1)=='D'){
                        ans += 400;
                        index++;
                    }else if(s.charAt(index+1)=='M'){
                        ans += 900;
                        index++;
                    }else{
                        ans += 100;
                    }
                    break;
                case 'L':ans+=50;break;
                case 'X':
                    if(s.charAt(index+1)=='L'){
                        ans += 40;
                        index++;
                    }else if(s.charAt(index+1)=='C'){
                        ans += 90;
                        index++;
                    }else{
                        ans += 10;
                    }
                    break;
                case 'V':ans+=5;break;
                case 'I':
                    if(s.charAt(index+1)=='V'){
                        ans += 4;
                        index++;
                    }else if(s.charAt(index+1)=='X'){
                        ans += 9;
                        index++;
                    }else{
                        ans += 1;
                    }
                    break;
                 default:break;
            }
            index++;
        }
        if(index == s.length()-1)
        switch (s.charAt(index)) {
            case 'I':ans++;break;
            case 'V':ans+=5;break;
            case 'X':ans += 10;break;
            case 'L':ans += 50;break;
            case 'C':ans += 100;break;
            case 'D':ans += 500;break;
            case 'M':ans += 1000;break;
            default:break;
        }
        return ans;
    }
}
