package com.kbein.algorithm.RomanNumber;

import java.util.HashMap;

/**
 * com.kbein.javalib
 * Created by KBein on 2018/11/19 14:24
 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 字符          数值
 I             1
 V             5
 X             10
 L             50
 C             100
 D             500
 M             1000
 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。
 数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
 同样地，数字 9 表示为 IX。
 这个特殊的规则只适用于以下六种情况：
 I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 示例 1:
    输入: "III"
    输出: 3
 示例 2:
    输入: "IV"
    输出: 4
 示例 3:
    输入: "IX"
    输出: 9
 示例 4:
    输入: "LVIII"
    输出: 58
    解释: L = 50, V= 5, III = 3.
 示例 5:
    输入: "MCMXCIV"
    输出: 1994
    解释: M = 1000, CM = 900, XC = 90, IV = 4.
 */

public class Solution {
//    I             1
//    V             5
//    X             10
//    L             50
//    C             100
//    D             500
//    M             1000
//    I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
//    X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
//    C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
    public static int romanToInt(String romanNumber){

        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < romanNumber.length(); i++) {
            switch (String.valueOf(romanNumber.charAt(i))){
                case "I":
                    hashMap.put(i,1);
                    break;
                case "V":
                    hashMap.put(i,5);
                    break;
                case "X":
                    hashMap.put(i,10);
                    break;
                case "L":
                    hashMap.put(i,50);
                    break;
                case "C":
                    hashMap.put(i,100);
                    break;
                case "D":
                    hashMap.put(i,500);
                    break;
                case "M":
                    hashMap.put(i,1000);
                    break;
            }
        }
        int result = 0;
        for (int i = 0; i < romanNumber.length(); i++) {
            if (i > romanNumber.length()-1){
                return result;
            }
            if (i == romanNumber.length()-1){
                result += hashMap.get(i);
                return result;
            }
            if (hashMap.get(i) < hashMap.get(i+1)){
                if (hashMap.get(i) == 1 && hashMap.get(i+1) == 5){
                    result +=4;

                }
                if (hashMap.get(i) == 1 && hashMap.get(i+1) == 10){
                    result +=9;
                }

                if (hashMap.get(i) == 10 && hashMap.get(i+1) == 50){
                    result +=40;
                }
                if (hashMap.get(i) == 10 && hashMap.get(i+1) == 100){
                    result +=90;
                }


                if (hashMap.get(i) == 100 && hashMap.get(i+1) == 500){
                    result +=400;
                }
                if (hashMap.get(i) == 100 && hashMap.get(i+1) == 1000){
                    result +=900;
                }
                i++;
            }else {
                result += hashMap.get(i);
            }
        }
        return result;

    }

    //优化
    public static int anInt(String s){

        if("".equals(s) || null == s) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int sum = 0;
        for(int i = 0; i < chars.length; i++){
            switch (chars[i]) {
                case 'I':
                    if(i + 1 == chars.length) {
                        sum += 1;
                        break;
                    } else{
                        if(chars[i + 1] == 'V' || chars[i + 1] == 'X'){
                            sum -= 1;
                        } else{
                            sum += 1;
                        }
                        break;
                    }
                case 'V':
                    sum += 5;
                    break;
                case 'X':
                    if(i + 1 == chars.length) {
                        sum += 10;
                        break;
                    } else{
                        if(chars[i + 1] == 'L' || chars[i + 1] == 'C'){
                            sum -= 10;
                        } else {
                            sum += 10;
                        }
                        break;
                    }
                case 'L':
                    sum +=50;
                    break;
                case 'C':
                    if(i + 1 == chars.length) {
                        sum += 100;
                        break;
                    } else{
                        if(chars[i + 1] == 'D' || chars[i + 1] == 'M'){
                            sum -= 100;
                        } else{
                            sum += 100;
                        }
                        break;
                    }
                case 'D':
                    sum += 500;
                    break;
                case 'M':
                    sum += 1000;
                    break;
                default:
                    return 0;
            }
        }
        return sum;

    }



    public static void main(String args[]){
//        int mcmxciv = Solution.anInt("III");
        int mcmxciv = Solution.romanToInt("III");
        System.out.println(mcmxciv);
    }


}
