package com.ct;

/**
 * @ Author     ：Cao Tuo
 * @ Date       ：Created in 10:42 2018/9/9
 * @ Description：LeetCode-12. Integer to Roman
 */
public class IntegertoRoman {

    public static void main(String[] args){
        System.out.println(new IntegertoRoman().intToRoman_V2(58));
    }

    public String intToRoman(int num) {
        StringBuffer sb = new StringBuffer();
        int temp = num/1000;
        while(temp!=0){
            sb.append("M");
            temp--;
        }
        num = num%1000;
        sb.append(intToRoman(num,100));
        return sb.toString();
    }

    public String intToRoman(int num,int base){
        char i,v,x;
        switch (base){
            case 1:i='I';v='V';x='X';break;
            case 10:i='X';v='L';x='C';break;
            case 100:i='C';v='D';x='M';break;
            default:return "";
        }
        StringBuffer sb = new StringBuffer();
        int temp = num/base;
        while(temp!=0){
            if(temp == 9){
                sb.append(new char[]{i,x});
                break;
            }else if(temp>=5){
                sb.append(v);
                temp -= 5;
            }else if(temp == 4){
                sb.append(new char[]{i,v});
                break;
            }else{
                sb.append(i);
                temp--;
            }
        }
        num %= base;
        base /= 10;
        sb.append(intToRoman(num,base));
        return sb.toString();
    }

    // others'code
    public String intToRoman_V2(int num){
        String[] letters = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        int index = 0;
        StringBuffer sb = new StringBuffer();
        while(num>0){
            if(num>=values[index]){
                sb.append(letters[index]);
                num -= values[index];
            }else{
                index ++;
            }
        }
        return sb.toString();
    }
}
