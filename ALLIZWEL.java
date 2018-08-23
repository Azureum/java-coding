/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class ALLIZWEL {

    private static boolean findString(char[][] mat, Node start, int n, int m, int index,boolean[][] visited,String expected) {
        boolean top=false,left=false,bottom=false,right=false,diag1=false,diag2=false,diag3=false,diag4=false;
        int newX,newY;
        Node newnode;
        if(index==9)
            return true;
        else{
            int x = start.x;
            int y = start.y;
            if(x-1>=0){
                newX=x-1;
                if(y-1>=0){
                    newY=y-1;
                    if(visited[newX][newY]==false&&mat[newX][newY]==expected.charAt(index+1)){
                        newnode = new Node(newX,newY);
                        visited[newX][newY]=true;
                        diag1 = findString(mat,newnode, n, m, index+1, visited, expected);
                        visited[newX][newY]=false;
                    }
                }
                if(y+1<m){
                    newY=y+1;
                    if(visited[newX][newY]==false&&mat[newX][newY]==expected.charAt(index+1)){
                        newnode = new Node(newX,newY);
                        visited[newX][newY]=true;
                        diag2 = findString(mat,newnode, n, m, index+1, visited, expected);
                        visited[newX][newY]=false;
                    }
                }
                newY=y;
                if(visited[newX][newY]==false&&mat[newX][newY]==expected.charAt(index+1)){
                        newnode = new Node(newX,newY);
                        visited[newX][newY]=true;
                        top = findString(mat,newnode, n, m, index+1, visited, expected);
                        visited[newX][newY]=false;
                    }
            }
            if(x+1<n){
                newX=x+1;
                if(y-1>=0){
                    newY=y-1;
                    if(visited[newX][newY]==false&&mat[newX][newY]==expected.charAt(index+1)){
                        newnode = new Node(newX,newY);
                        visited[newX][newY]=true;
                        diag3 = findString(mat,newnode, n, m, index+1, visited, expected);
                        visited[newX][newY]=false;
                    }
                }
                if(y+1<m){
                    newY=y+1;
                    if(visited[newX][newY]==false&&mat[newX][newY]==expected.charAt(index+1)){
                        newnode = new Node(newX,newY);
                        visited[newX][newY]=true;
                        diag4 = findString(mat,newnode, n, m, index+1, visited, expected);
                        visited[newX][newY]=false;
                    }
                }
                newY=y;
                if(visited[newX][newY]==false&&mat[newX][newY]==expected.charAt(index+1)){
                        newnode = new Node(newX,newY);
                        visited[newX][newY]=true;
                        bottom = findString(mat,newnode, n, m, index+1, visited, expected);
                        visited[newX][newY]=false;
                }
            }
            if(y-1>=0){
                newX=x;
                newY=y-1;
                if(visited[newX][newY]==false&&mat[newX][newY]==expected.charAt(index+1)){
                        newnode = new Node(newX,newY);
                        visited[newX][newY]=true;
                        left = findString(mat,newnode, n, m, index+1, visited, expected);
                        visited[newX][newY]=false;
                }
            }
            if(y+1<m){
                newX=x;
                newY=y+1;
                if(visited[newX][newY]==false&&mat[newX][newY]==expected.charAt(index+1)){
                        newnode = new Node(newX,newY);
                        visited[newX][newY]=true;
                        right = findString(mat,newnode, n, m, index+1, visited, expected);
                        visited[newX][newY]=false;
                }
            }
            if(top||left||bottom||right||diag1||diag2||diag3||diag4){
                return true;
            }
            else{
                return false;
            }
        }
        //return false;
    }
    static class Node{
        int x,y;
        
        Node(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        char[][] mat;
        boolean[][] visited;
        ArrayList<Node> startIndices;
        String expected = "ALLIZZWELL";
        while(T-->0){
            int n=sc.nextInt();
            int m=sc.nextInt();
            mat = new char[n][m];
            visited = new boolean[n][m];
            int count=0;
            startIndices = new ArrayList<>();
            for(int i=0;i<n;i++){
                char[] row = sc.next().toCharArray();
                //System.out.println(row.length);
                for(int j=0;j<m;j++){
                    mat[i][j] = row[j];
                    visited[i][j]=false;
                    if(row[j]=='A'){
                        count++;
                        startIndices.add(new Node(i,j));
                    }
                }
            }
            /*
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    System.out.print(mat[i][j]);
                }
                System.out.println("");
            }*/
            boolean found = false;
            for(int i=0;i<count;i++){
                Node startNode = startIndices.get(i);
                visited[startNode.x][startNode.y] = true;
                found = findString(mat,startNode,n,m,0,visited,expected);
                FillArray(visited);
                if(found)
                    break;
            }
            if(found)
                System.out.println("YES");
            else
                System.out.println("NO");
            
        }
    }
    public static void FillArray(boolean[][] SC){
        for (int i = 0; i < SC.length; i++){
            Arrays.fill(SC[i], Boolean.FALSE);
        }
    }
}
