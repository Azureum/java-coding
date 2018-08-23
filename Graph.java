
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class Graph {
    int V,E;
    Edge[] edge;

    void KruskalMST() {
        Edge[] results = new Edge[V];
        int i=0;//for sorted edges
        int e=0;//for results
        for (i=0; i<V; ++i)
            results[i] = new Edge();
        Arrays.sort(edge);
        // Allocate memory for creating V ssubsets
        Subset subsets[] = new Subset[V];
        for(i=0; i<V; ++i)
            subsets[i]=new Subset();
        
        for (int v = 0; v < V; ++v)
        {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }
        i=0;
        while(e<V-1){
            Edge nextedge= new Edge();
            nextedge = edge[i++];
            
            int x=find(subsets,nextedge.src);
            int y=find(subsets,nextedge.dest);
            if(x!=y){
                results[e++] = nextedge;
                Union(subsets,x,y);
            }
        }
        System.out.println("EDGES IN MST");
        for(i=0;i<e;++i){
            System.out.println(results[i].src+" - "+results[i].dest+" "+results[i].weight);
        }
 
    }
    
    class Edge implements Comparable<Edge>{
        int src,dest,weight;
        @Override
        public int compareTo(Edge t) {
            return this.weight-t.weight;
        }
    }
    class Subset{
        int parent,rank;
    }
    public Graph(int V, int E) {
        this.V=V;
        this.E=E;
        edge = new Edge[E];
        for(int i=0;i<E;i++){
            edge[i] = new Edge();
        }
    }
    //Path Compression technique
    public int find(Subset subsets[],int i){
        if(subsets[i].parent!=i){
            subsets[i].parent =  find(subsets,subsets[i].parent);
        }
        return subsets[i].parent;
    }
    //Union by rank
    public void Union(Subset subsets[],int x, int y){
        int xroot = find(subsets,x);
        int yroot = find(subsets,y);
        
        if(subsets[xroot].rank>subsets[yroot].rank){
            subsets[yroot].parent = xroot;
        }
        else if(subsets[xroot].rank<subsets[yroot].rank){
            subsets[xroot].parent = yroot;
        }
        else{
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
        
    }
    
}
