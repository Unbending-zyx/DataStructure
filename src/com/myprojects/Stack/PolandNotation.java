package com.myprojects.Stack;

import java.util.Stack;

//逆波兰表达式完成计算器
public class PolandNotation {

    public static void main(String[] args) {
        //先定义一个逆波兰表达式
        //  (3+4)*5-6   ==>  3 4 + 5 * 6 -   对应的逆波兰表达式
        String suffixExpression="34+5*6-";
        char[] sufCharArray=suffixExpression.toCharArray();
        int a=calculation(sufCharArray);
        System.out.println(a);
    }


    public static int calculation(char[] chars){
        //java提供的栈
        Stack<Integer> stack=new Stack<Integer>();
        for (char c:chars){
            if (Character.isDigit(c)){
                stack.push(Integer.parseInt(c+""));
                continue;
            }
            int num=count((int)stack.pop(),(int)stack.pop(),c);
            stack.push(num);
        }
        return (int)stack.pop();
    }

    public static  int count(int a,int b,char c){
        int result=0;
        switch (c){
            case '+':
                result=a+b;
                break;
            case '*':
                result=a*b;
                break;
            case '-':
                result=b-a;
                break;
            case '/':
                result=b/a;
        }
        return result;
    }



}
