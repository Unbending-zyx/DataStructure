package com.myprojects;


/**
 * 使用java实现顺序栈
 */
public class ArrayStack {
    //使用数组存储数据
    private Object data[];
    //栈的最大容量
    private int maxSize;
    //栈顶指针
    private int top=-1;

    public ArrayStack(){
        this(10);
    }
    public ArrayStack(int size){
        this.maxSize=size;
        this.data=new Object[maxSize];
    }

    public boolean isNull(){
        return top==-1;
    }

    public boolean isFull(){
        return top==(maxSize-1);
    }

    public boolean push(Object value){
        if (isFull()){
            return false;
        }
        data[++top]=value;
        return true;
    }
    public Object pop(){
        if (isNull()){
            return null;
        }
        return data[top--];
    }

    public void showStack(){
        for(int i=0;i<=top;i++){
            System.out.println(data[i]);
        }
    }

    public static void main(String[] args) {
        ArrayStack as=new ArrayStack(5);
        as.push("1234");
        as.push(1);
        as.push(2);
        as.push(3);
        as.push(4);
        as.showStack();
        as.pop();
        as.showStack();
    }

}
