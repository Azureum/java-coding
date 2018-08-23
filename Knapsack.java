
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class Knapsack {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int[] weights = new int[]{10,20,30};
        int[] values = new int[]{60,100,120};
        int N = values.length;
        int W = 50;
        int[][] arr = new int[N+1][W+1];
        /*for(int i=0;i<N;i++){
            weights[i]=sc.nextInt();
            values[i]=sc.nextInt();
        }*/
        for(int i=0;i<=N;i++){
            for(int j=0;j<=W;j++){
                if(i==0||j==0){
                    arr[i][j]=0;
                }
                else if(weights[i-1]<=j){
                    arr[i][j] = Math.max(values[i-1]+arr[i-1][j-weights[i-1]], arr[i-1][j]);
                }
                else{
                    arr[i][j] = arr[i-1][W];
                }
            }
        }
        System.out.println(arr[N][W]);
    }
}
