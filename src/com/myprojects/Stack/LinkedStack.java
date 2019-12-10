package com.myprojects.Stack;


/**
 * 使用链表为底层完成栈
 */
public class LinkedStack {

    private int top=-1;
    private int maxSize;
    private LinkedNode headNode=new LinkedNode(null,null);


    LinkedStack(){
        this(10);
    }

    LinkedStack(int size){
        this.maxSize=size;
    }

    public boolean isNull(){
        return top==-1;
    }

    public boolean isFull(){
        return top==(maxSize-1);
    }

    //入栈
    public boolean push(Object value){
        LinkedNode node=new LinkedNode(value,null);
        if (isFull()){
            return false;
        }
        if (headNode.getData()==null && headNode.getNext()==null){
            headNode=node;
            top++;
            return true;
        }
        LinkedNode temp=headNode;
        while(true){
            if (temp.getNext()==null){
                temp.setNext(node);
                top++;
                return true;
            }
            temp=temp.getNext();
        }
    }

    public Object pop(){
        if (isNull()){
            return null;
        }
        if (headNode.getNext()==null){
            top--;
            return headNode.getData();
        }
        LinkedNode temp=headNode;
        while(true){
            if (temp.getNext().getNext()==null && temp.getNext().getData()!=null){
                top--;
                Object result=temp.getNext().getData();
                temp.setNext(null);
                return result;
            }
            temp=temp.getNext();
        }
    }

    public void showStack(){
        LinkedNode temp=headNode;
        while(true){
            if (temp==null){
                return;
            }
            System.out.println(temp.toString());
            temp=temp.getNext();
        }
    }


    //链表节点
    class LinkedNode{
        private Object data;
        private LinkedNode next;

        LinkedNode(Object data,LinkedNode next){
            this.data=data;
            this.next=next;
        }

        public Object getData(){
            return data;
        }

        public void setData(Object data){
            this.data=data;
        }

        public LinkedNode getNext(){
            return next;
        }

        public void setNext(LinkedNode next){
            this.next=next;
        }

        @Override
        public String toString() {
            return "Node: data:"+data;
        }
    }

    public static void main(String[] args) {
        LinkedStack ls=new LinkedStack(5);
        ls.push(1);
        ls.push(2);
        ls.push(3);
        ls.showStack();
    }
}
