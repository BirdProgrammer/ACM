package com.ct;

/**
 * @ Author     ：Cao Tuo
 * @ Date       ：Created in 16:40 2018/9/10
 * @ Description：LeetCode-43. Multiply Strings
 */
public class MultiplyStrings {

    public static void main(String[] args){
        String num1 = "123";
        String num2 = "456";
        System.out.println(new MultiplyStrings().multiply(num1,num2));
    }

    public String multiply(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();
        int product[] = new int[n+m];
        int temp,p1,p2;
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                temp = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                p1 = i+j;
                p2 = i+j+1;
                temp += product[p2];
                product[p1] += temp/10;
                product[p2] = temp%10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<product.length;i++){
            if(product[i]==0 && sb.length()==0){
                continue;
            }else{
                sb.append(product[i]);
            }
        }
        return sb.length()==0 ? "0" : sb.toString();
    }
}
