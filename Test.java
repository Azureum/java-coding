/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Scanner;

/**
 *
 * @author HP
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        String[] numarr = num.split("");
        int[] arr = new int[numarr.length];
        for(int i=0;i<arr.length;i++){
            arr[i]=Integer.valueOf(numarr[i]);
        }
        permute(arr,0);
    }

    private static void permute(int[] arr,int index) {
        if(index==arr.length-1){
            for(int i=0;i<arr.length;i++){
                System.out.print(arr[i]);
            }
            System.out.println("");
        }
        else{
            for(int i=index;i<arr.length;i++){
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
                
                permute(arr,index+1);
                
                temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }
    }
    
}
