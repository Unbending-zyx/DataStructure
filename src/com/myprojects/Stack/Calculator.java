package com.myprojects.Stack;

import java.util.Objects;

public class Calculator {

    //使用栈完成综合计算器
    public int Calculator(String str){
        //将字符串分割成char型数组
        char[] strArray=str.toCharArray();
        //创建一个数栈   一个符号栈
        ArrayStackPlus<Integer> numStack=new ArrayStackPlus<Integer>(10);
        ArrayStackPlus<Character> signStack=new ArrayStackPlus<Character>(10);
        for (int i=0;i<strArray.length;i++){
            char temp=strArray[i];
            //判断是否是数字
            if (Character.isDigit(temp)){
                numStack.push(Integer.parseInt(String.valueOf(temp)));
                continue;
            }else{
                if (signStack.isNull()){
                    signStack.push(temp);
                    continue;
                }
                if (priority(temp)<=priority((char)signStack.peek())){
                    int num=count((int)numStack.pop(),(int)numStack.pop(),signStack.pop());
                    numStack.push(num);
                    signStack.push(temp);
                    continue;
                }
                signStack.push(temp);
            }
        }
        while(true){
            if (signStack.isNull()){
                break;
            }
            int num=count(numStack.pop(),numStack.pop(),signStack.pop());
            numStack.push(num);
        }


        return (int)numStack.pop();
    }

    //减和除要使用后面的减或除以前面的值
    public int count(int num1,int num2,char oper){
        int result=0;
        switch (oper){
            case '+':
                result=num1+num2;
                break;
            case '-':
                result=num2-num1;
                break;
            case '*':
                result=num1*num2;
                break;
            case '/':
                result=num2/num1;
                break;
        }
        return result;
    }

    //判断是不是运算符
    public boolean isOper(char oper){
        return oper=='+' || oper=='-' || oper=='*' || oper=='/';
    }

    //判断传入符号的优先级
    public int priority(char oper){
        if (oper=='*' || oper=='/'){
            return 1;
        }else if (oper=='+' || oper=='-'){
            return 0;
        }else{
            return -1;
        }
    }


    class ArrayStackPlus<T>{
        private int top=-1;
        private int maxSize;
        private T[] data;

        ArrayStackPlus(){
            this(10);
        }
        ArrayStackPlus(int size){
            this.maxSize=size;
            data=(T[]) new Object[maxSize];
        }

        //返回栈顶数据  且数据不出栈
        public T peek(){
            if (top==-1){
                return null;
            }
            return data[top];
        }

        //判断栈是否为空
        public boolean isNull(){
            return top==-1;
        }

        //判断是否栈满
        public boolean isFull(){
            return top==(maxSize-1);
        }

        //入栈
        public boolean push(T value){
            if (isFull()){
                return false;
            }
            data[++top]=value;
            return true;
        }

        //出栈
        public T pop(){
            if (isNull()){
                return null;
            }
            return data[top--];
        }

        //输出栈
        public void showStack(){
            if (!isNull()){
                for (int i=0;i<=top;i++){
                    System.out.println(data[i]);
                }
            }
        }


    }

    public static void main(String[] args) {
        Calculator calculator=new Calculator();
        int a=calculator.Calculator("1*2+3-4+5+6-7");
        System.out.println(a);
    }
}
