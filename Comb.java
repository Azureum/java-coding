
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
public class Comb {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = "1234";
        
        int n= input.length();
        int[] arr = new int[n-1];
        comb(input,n,arr,0);
        
    }

    private static void comb(String input, int n, int[] arr, int k) {
        if(k==n-1){
            printSeries(input,n,arr,k);
            return;
        }
        else{
            for(int i=0;i<=1;i++){
                arr[k]=i;
                comb(input,n,arr,k+1);
            }
        }
    }

    private static void printSeries(String input, int n, int[] arr, int k) {
        for(int i=0;i<n;i++){
            System.out.print(input.charAt(i));
            
            if(i<n-1&&arr[i]==1){
                System.out.print(" ");
            }
        }
        System.out.println("");
    }
}
