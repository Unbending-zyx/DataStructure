package com.myprojects.recursion;

/**
 * 递归实现迷宫回溯问题
 * 生成迷宫   出生点再map[1][1]  出口在map[map.length-2][map[1].length-2]   左上和右下
 */
public class MiGong {
    public static void main(String[] args) {
        //创建一个二维数组八行七列  模拟迷宫
        //  数字1  代表墙   数字0  代表可行走区域
        int[][] map =new int[8][7];
        createMap(map);
        showMap(map);
        boolean result=setWay(map,1,1);
        System.out.println(result);
        showMap(map);
    }

    /**
     * 使用递归回溯  找到离开迷宫的路  找到返回true  找不到返回false
     * 当小球到达右下角时，表示找到通路  返回true
     * 约定： map中的值   为0  表示没有走过  为1  表示墙   为2  表示此点可以走  为3  表示此点已经走过  但是走不通
     * 走迷宫时 的策略   下->右->上->左
     * @param map  迷宫地图
     * @return   是否找到路  找到返回true  找不到返回false
     */
    public static boolean setWay(int[][] map,int x,int y){
        //设置递归结束的条件
        if (map[map.length-2][map[1].length-2]==2){
            return true;
        }
        //判断的优先级   下->右->上->左
        if (map[y][x]==0){
            map[y][x]=2;
            if (setWay(map,x,y+1)){
                return true;
            }else if (setWay(map,x+1,y)){
                return true;
            }else if (setWay(map,x,y-1)){
                return true;
            }else if (setWay(map,x-1,y)){
                return true;
            }else {
                return false;
            }
        }else{
            return false;
        }

    }


    //随机生成地图
    public static void createMap(int[][] map){
        for (int i=0;i<map.length;i++){
            for (int j=0;j<map[i].length;j++){
                if (i==0 || i==map.length-1){
                    map[i][j]=1;
                }else if (j==0 || j==map[i].length-1){
                    map[i][j]=1;
                }else{
                    int random=(int)(Math.random()*100);
//                    System.out.println(random);
                    if (random<10){
                        map[i][j]=1;
                    }else{
                        map[i][j]=0;
                    }
                }
            }
        }
        map[1][1]=0;
    }

    //展示地图
    public static void showMap(int[][] map){
        for (int i=0;i<map.length;i++){
            for (int j=0;j<map[i].length;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
}
