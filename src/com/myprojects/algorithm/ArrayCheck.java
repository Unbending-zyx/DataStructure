package com.myprojects.algorithm;

import java.util.Arrays;

/**
 * 此类完成的是给你一个字符串，返回该字符重复出现的索引
 */
public class ArrayCheck {
    //时间复杂度   n的平方
    //这是一种暴力匹配的方法  可以进行优化
    public static int getIndex(String str){
        char[] chars=str.toCharArray();
        for (int i=0;i<chars.length;i++){
            for (int j=i+1;j<chars.length;j++){
                if (chars[i]==chars[j]){
                    return i;
                }
            }
        }
        return -1;
    }

    //这种方法  时间复杂度是  n
    //使用两个数组作为辅助存储   num储存字符出现的次数   index存储字符第一次出现的索引值
    //将这两个数组都设置为256（ASCII 长度）  从字符串中取出字符  转化成int型  假设为a  将num和index中a位置的数据进行更新
    public static int getIndexUseTowArray(String str){
        int result=-1;
        char[] chars=str.toCharArray();
        int[] num=new int[256];
        int[] index=new int[256];
        //将index中所有数置为-1
        Arrays.fill(index,-1);
        for(int i=0;i<chars.length;i++){
            int a=chars[i];
            num[a]++;
            if (index[a]==-1){
                index[a]=i;
            }
        }
        for (int i=0;i<chars.length;i++){
            int a=chars[i];
            if (num[a]>1 && index[a]!=-1){
                return index[a];
            }
        }
        return result;
    }

    //使用一个数组完成返回第一个重复的值
    //时间复杂度为  n
    //使用一个num数组存储字符出现的次数
    public static int getIndexUseOneArray(String str){
        char[] chars=str.toCharArray();
        int[] num=new int[256];
        int result=-1;

        for (int i=0;i<chars.length;i++){
            int index=chars[i];
            num[index]++;
        }
        for (int i=0;i<chars.length;i++){
            if (num[chars[i]]>1){
                return i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String str="abcdefac";
        System.out.println(getIndexUseOneArray(str));
    }
}
