/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class Prims {
        static int V;
        public static void main(String[] args){
            int graph[][] = new int[][] {{0, 2, 0, 6, 0},
                                    {2, 0, 3, 8, 5},
                                    {0, 3, 0, 0, 7},
                                    {6, 8, 0, 0, 9},
                                    {0, 5, 7, 9, 0},
                                   };
            V = graph[0].length;
            calcPrims(graph);
        }

    private static void calcPrims(int[][] graph) {
        int[] parent = new int[V];
        int[] keys = new int[V];
        boolean[] MST = new boolean[V];
        for(int i=0;i<V;i++){
            if(i==0){
                keys[i]=0;
                parent[i]=-1;
                
            }
            else{
                keys[i] = Integer.MAX_VALUE;
            }
            MST[i]= false;
        }
        
        for(int i=0;i<V;i++){
            int index = minIndex(keys,MST);
            MST[index] = true;
            for(int j=0;j<V;j++){
                if(graph[i][j]!=0&&MST[j]==false&&keys[j]>graph[i][j]){
                    keys[j]=graph[i][j];
                    parent[j] = index;
                }
            }
        }
        printMST(graph,parent);
    }

    private static int minIndex(int[] keys, boolean[] MST) {
        int min=Integer.MAX_VALUE,minId=-1;
        for(int i=0;i<V;i++){
            if(MST[i]==false&&min>keys[i]){
                min=keys[i];
                
                minId = i;
            }
        }
        return minId;
    }

    private static void printMST(int[][] graph, int[] parent) {
        System.out.println("Edge Weight");
        for(int i=1;i<V;i++){
            System.out.print(parent[i]+" - "+i+" ");
            System.out.println(graph[i][parent[i]]);
        }
    }
}
