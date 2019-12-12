package com.myprojects.recursion;

//递归练习斐波那契数
public class Fibonacci {

    /**
     * 斐波那契数   f(n)=f(n-1)+f(n-2)
     *   例：  1 1 2 3 5 8 13 21 .....
     *   从第三个数开始   每个数都等于前两个数的和
     *
     */
    public static void main(String[] args) {
        System.out.println(getFibonacci(5));
    }

    public static int getFibonacci(int num){
        if (num==1 || num==2){
            return 1;
        }else{
            return getFibonacci(num-1)+getFibonacci(num-2);
        }
    }
}
