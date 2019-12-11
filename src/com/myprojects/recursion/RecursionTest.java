package com.myprojects.recursion;

//递归的一个小实验
public class RecursionTest {
    public static void main(String[] args) {
        test(5);
        System.out.println(factorial(3));
    }

    //打印问题
    public static void test(int n){
        if (n>1){
            test(n-1);
        }
        System.out.println(n);
    }

    //阶乘问题
    public static int factorial(int num){
        if (num==1){
            return 1;
        }
        return factorial(num-1)*num;


    }
}
