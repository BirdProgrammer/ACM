package com.ct;

/**
 * @ Author     ：Cao Tuo
 * @ Date       ：Created in 21:13 2018/9/19
 * @ Description：LeetCode-67. Add Binary
 */
public class AddBinary {

    public static void main(String[] args){
        String a = "1111";
        String b = "1111";
        System.out.println(new AddBinary().addBinary(a,b));
    }
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int index = 1;
        int up = 0;
        int aLength = a.length();
        int bLength = b.length();
        while(index<=aLength && index<=bLength){
            int temp = up+a.charAt(aLength-index)+b.charAt(bLength-index)-'0';
            switch (temp){
                case '0':sb.insert(0,'0');up = 0;break;
                case '1':sb.insert(0,'1');up = 0;break;
                case '2':sb.insert(0,'0');up = 1;break;
                case '3':sb.insert(0,'1');up = 1;break;
            }
            index++;
        }

        while(index<=aLength){
            int temp = up+a.charAt(aLength-index);
            switch (temp){
                case '0':sb.insert(0,'0');up = 0;break;
                case '1':sb.insert(0,'1');up = 0;break;
                case '2':sb.insert(0,'0');up = 1;break;
                case '3':sb.insert(0,'1');up = 1;break;
            }
            index++;
        }
        while(index<=bLength){
            int temp = up+b.charAt(bLength-index);
            switch (temp){
                case '0':sb.insert(0,'0');up = 0;break;
                case '1':sb.insert(0,'1');up = 0;break;
                case '2':sb.insert(0,'0');up = 1;break;
                case '3':sb.insert(0,'1');up = 1;break;
            }
            index++;
        }
        if(up == 1){
            sb.insert(0,'1');
        }
        return sb.toString();
    }
}
