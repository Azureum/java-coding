/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class INVCNT {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] bits;
        ArrayList<Integer> arr,sorted;
        while(T-->0){
            //sc.next();
            int N = sc.nextInt();
            //System.out.println("--"+N);
            arr = new ArrayList<>();
            sorted= new ArrayList<>();
            bits = new int[N];
            Arrays.fill(bits,0);
            for(int i=0;i<N;i++){
                int newnum = sc.nextInt();
                arr.add(newnum);
                sorted.add(newnum);
            }
            int count=0;
            /*for(int i=0;i<N;i++){
                for(int j=i;j<N;j++){
                    if(arr[j]<arr[i]){
                        count++;
                    }
                }
            }*/
            Collections.sort(sorted);
            for(int i=0;i<N;i++){
                int index = sorted.indexOf(arr.get(i));
                bits[index]=1;
                for(int j=index+1;j<N;j++){
                    count+=bits[j];
                }
            }
            System.out.println(count);
        }
    }
}
