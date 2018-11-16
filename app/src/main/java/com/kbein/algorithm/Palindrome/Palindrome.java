package com.kbein.algorithm.Palindrome;

/**
 * com.kbein.algorithm.Palindrome
 * Created by KBein on 2018/11/16 16:03
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *示例 1:
 *  输入: 121
 *  输出: true
 *示例 2:
 *  输入: -121
 *  输出: false
 *  解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 *示例 3:
 *  输入: 10
 *  输出: false
 *  解释: 从右向左读, 为 01 。因此它不是一个回文数。
 *
 */

public class Palindrome {


    public boolean isPalindrome(int x){

        int result = 0;
        int copyX = x;

        if (x == 0){
            return true;
        }else if (x > 0){
            while (x !=0){
                int pop = x % 10;
                x /=10;
                result = result * 10 + pop;
                if (result == copyX){
                    return true;
                }
            }
        }
        return false;

    }


}
