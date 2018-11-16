package com.kbein.algorithm.CalculateTheSquare;


/**
 * com.kbein.remoteviewdemo
 * Created by KBein on 2018/11/14 13:40
 * 随机给一个数，求出平方恨。
 * 二分法
 */

public class CalculateTheSquareRoot {

    private static CalculateTheSquareRoot calculateTheSquareRoot;


    private CalculateTheSquareRoot(){

    }

    public static CalculateTheSquareRoot getInstance(){

        if (calculateTheSquareRoot ==null){
            calculateTheSquareRoot = new CalculateTheSquareRoot();
        }
        return calculateTheSquareRoot;

    }

    public static double compute(double x,double target){
        double dd =  0.0000000001d;
        if (target == 0){
            return 0;
        }
        while (true){
            x = (x+target/x)/2;
            if (x * x == target || Math.abs(x * x - target) < dd){
                return x;
            }
        }
    }


}
