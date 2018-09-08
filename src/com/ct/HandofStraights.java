package com.ct;

import java.util.Arrays;

/**
 * @ Author     ：Cao Tuo
 * @ Date       ：Created in 15:33 2018/9/8
 * @ Description：
 */
public class HandofStraights {

    public static void main(String[] args){
        int[] hand = new int[]{2,1};
        int W = 2;
        System.out.println(new HandofStraights().isNStraightHand(hand,W));
    }

    public boolean isNStraightHand(int[] hand, int W) {
        if(hand.length%W != 0){
            return false;
        }
        Arrays.sort(hand);
        Node[] nodes = new Node[hand.length/W];
        for(int i=0;i<hand.length/W;i++){
            nodes[i] = new Node();
        }
        for(int i=0;i<hand.length;i++){
            int j;
            for(j=0;j<hand.length/W;j++){
                if(nodes[j].counter==0){
                    nodes[j].counter++;
                    nodes[j].number = hand[i];
                    break;
                }else if(nodes[j].counter<W && nodes[j].number+1==hand[i]){
                    nodes[j].number++;
                    nodes[j].counter++;
                    break;
                }
            }
            if(j==hand.length/W){
                return false;
            }
        }
        return true;
    }

    class Node{
        public int counter;
        public int number;
        public Node(){
            counter = 0;
        }
    }
}
