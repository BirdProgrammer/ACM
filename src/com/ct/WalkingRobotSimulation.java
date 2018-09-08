package com.ct;

import java.util.HashSet;
import java.util.Set;

/**
 * @ Author     ：Cao Tuo
 * @ Date       ：Created in 16:49 2018/9/8
 * @ Description：
 */
public class WalkingRobotSimulation {

    public static void main(String[] args){
        int[] commands = new int[]{4,-1,4,-2,4};
        int[][] obstacles = new int[1][2];
        obstacles[0][0] = 2;
        obstacles[0][1] = 4;
        System.out.println(new WalkingRobotSimulation().robotSim(commands,obstacles));
    }

    public int robotSim(int[] commands, int[][] obstacles) {
        int ans = 0;
        Set<String> set = new HashSet<>();
        for(int[] o : obstacles){
            set.add(o[0] + " " + o[1]);
        }
        int[][] directions = new int[][]{{1,0},{0,-1},{-1,0},{0,1}};
        int index=3,x=0,y=0,distance=0;
        for(int command : commands){
            if(command == -2){
                index = (index-1+4)%4;
            }else if(command == -1){
                index = (index+1)%4;
            }else {
                while(command>0 && !set.contains((x+directions[index][0])+" "+(y+directions[index][1]))){
                    x += directions[index][0];
                    y += directions[index][1];
                    command--;
                }
//                System.out.println("x:"+x+"\ty:"+y);
            }
            distance = x*x+y*y;
            ans = distance>ans ? distance : ans;
        }
        return ans;
    }
}
