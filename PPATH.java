/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class PPATH {

    private static void initializeGraph(Graph graph, ArrayList<Integer> primenum) {
        for(int i=0;i<primenum.size();i++){
            int node = primenum.get(i);
            graph.adj[i].add(node);
            char[] intchar = (""+node).toCharArray();
            for(int j=0;j<4;j++){
                for(int k=0;k<10;k++){
                    if(!(j==k&&k==0)){  
                        intchar = (""+node).toCharArray();
                        /*if(node==1033){
                                System.out.println("NN "+Integer.parseInt(String.copyValueOf(intchar))+" -- "+String.copyValueOf(intchar));
                        }*/
                        intchar[j]= String.valueOf(k).charAt(0);
                        int newnum = Integer.parseInt(String.copyValueOf(intchar));
                        if(primenum.contains(newnum)&&newnum!=node){
                            //System.out.println(node+" --> "+newnum);
                            graph.adj[i].add(newnum);
                            /*if(node==1033){
                                System.out.println("NN "+newnum);
                            }*/
                        }
                    }
                }
            }
        }
    }
    static class Graph{
        int V;
        LinkedList<Integer> adj[]; 
        
        Graph(int V){
            this.V = V;
            //System.out.println(V);
            adj = new LinkedList[V];
            for(int i=0;i<V;i++){
                adj[i] = new LinkedList();
            }
        }
    }
    
    private static final int MAX = 10000;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        boolean[] prime = new boolean[MAX];
        Arrays.fill(prime, Boolean.TRUE);
        initializePrime(prime);
        /*for(int i=0;i<10000;i++){
            if(prime[i])
                System.out.println(i+" "+prime[i]);
        }*/
        ArrayList<Integer> primenum = new ArrayList();
        for(int i=1001;i<10000;i++){
            if(prime[i]){
                primenum.add(i);
            }
        }
        Graph graph = new Graph(primenum.size());
        initializeGraph(graph,primenum);
        /*for(int i=0;i<graph.adj[0].size();i++){
            System.out.println(graph.adj[0].get(i));  
        }*/
        while(T-->0){
            int from = sc.nextInt();
            int to = sc.nextInt();
            if(from==to){
                System.out.println("0");
                continue;
            }
            int ans = bfs(graph,from,to,primenum);
            if(ans>0)
                System.out.println(ans);
            else
                System.out.println("IMPOSSIBLE");
            /*System.out.println(primenum.contains(to));
            for(int i=0;i<primenum.size();i++){
                for(int j=1;j<graph.adj[i].size();j++){
                    if(graph.adj[i].get(j)==to){
                        System.out.println("NNNNN");
                    }
                }
            }
            int index = primenum.indexOf(1033);
            System.out.println(index);
            for(int i=0;i<graph.adj[index].size();i++){
                System.out.println(graph.adj[index].get(i));
            }*/
        }
    }

    private static void initializePrime(boolean[] prime) {
        prime[0]=false;
        prime[1]=false;
        for(int i=2;i<MAX/2;i++){
            for(int j=i+i;j<MAX;j=j+i){
                prime[j]=false;
            }
        }
    }

    private static int bfs(Graph g, int from, int to, ArrayList<Integer> primenum) {
        LinkedList<Integer> q = new LinkedList();
        boolean[] visited = new boolean[g.V];
        Arrays.fill(visited, Boolean.FALSE);
        q.add(from);
        visited[primenum.indexOf(from)]=true;
        q.add(null);
        int count=0;
        while(!q.isEmpty()){
            if(q.peek()==null){
                count++;
                q.pop();
                q.add(null);
                if(q.peek()==null)
                    break;
                else
                    continue;
            }
            else{
                int node = q.pop();
                int index = primenum.indexOf(node);
                //System.out.println(g.adj[index].get(0));
                for(int i=0;i<g.adj[index].size();i++){
                    int newnode = g.adj[index].get(i);
                    int newindex = primenum.indexOf(newnode);
                    if(!visited[newindex]){
                        visited[newindex]=true;
                        q.add(newnode);
                        //System.out.println(newnode);
                        if(newnode==to){
                            return count+1;
                        }
                    }
                }
            }
        }
        return -1;
    }

}
