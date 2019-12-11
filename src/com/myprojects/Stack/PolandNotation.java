package com.myprojects.Stack;

import java.util.Stack;

//逆波兰表达式完成计算器
public class PolandNotation {

    public static void main(String[] args) {
        //先定义一个逆波兰表达式
        //  (3+4)*5-6   ==>  3 4 + 5 * 6 -   对应的逆波兰表达式
        String suffixExpression="(3+4)*5-6";
        char[] sufCharArray=change(suffixExpression).toCharArray();
        int a=calculation(sufCharArray);
        System.out.println(a);
        System.out.println(change("1+((2+3)*4)-5"));
    }

    //中缀表达式转后缀表达式
    //  例:  由  1+((2+3)*4)-5   ==> 123+4*+5-
    public static String change(String str){
        Stack s1=new Stack();
        Stack s2=new Stack();
        StringBuilder result=new StringBuilder();
        char[] charArray=str.toCharArray();
        for (char c:charArray){
            if (Character.isDigit(c)){
                s2.push(c);
                continue;
            }
            if (c=='('){
                s1.push(c);
                continue;
            }else if(c==')'){
                while((char)s1.peek()!='('){
                    s2.push(s1.pop());
                }
                s1.pop();
                continue;
            }else{
                isOper(c,s1,s2);
            }
        }
        while(!s1.empty()){
            s2.push(s1.pop());
        }
        while(!s2.empty()){
            result.append(s2.pop());
        }
        return result.reverse().toString();
    }

    public static void isOper(char c,Stack s1,Stack s2){
        if (s1.empty() || (char)s1.peek()=='('){
            s1.push(c);
        }else if (priority(c)>priority((char)s1.peek())){
            s1.push(c);
        }else{
            s2.push(s1.pop());
            isOper(c, s1, s2);
        }
    }

    //判断传入符号的优先级
    public static int priority(char oper){
        if (oper=='*' || oper=='/'){
            return 1;
        }else if (oper=='+' || oper=='-'){
            return 0;
        }else{
            return -1;
        }
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
