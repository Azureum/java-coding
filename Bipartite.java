/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author HP
 */
public class Bipartite {
    public static void main(String[] args){
        int G[][] = {{0, 1, 0, 1},
            {1, 0, 1, 0},
            {0, 1, 0, 1},
            {1, 0, 1, 0}
        };
        //System.out.println(G.length);
        Bipartite b = new Bipartite();
        if (b.isBipartite(G))
           System.out.println("Yes");
        else
           System.out.println("No");
    }

    private boolean checkNode(int[][] G, int i, int[] color) {
        LinkedList<Integer> q = new LinkedList();
        q.add(i);
        color[i]=1;
        while(!q.isEmpty()){
            int node = q.poll();
            if(G[node][node]==1) //self-loop
                return false;
            
            for(int j=0;j<G.length;j++){
                if(G[node][j]==1&&color[j]==-1){
                   color[j]=1-color[node];
                   q.add(j);
                }
                else if(G[node][j]==1&&color[node]==color[j])
                    return false;
            }
        }
        return true;
    }

    private boolean isBipartite(int[][] G) {
        int[] color = new int[G.length];
        Arrays.fill(color,-1);
        for(int i=0;i<G.length;i++){
            if(color[i]==-1)
                if(checkNode(G, i, color)==false)
                    return false;
        }
        return true;
    }
}
