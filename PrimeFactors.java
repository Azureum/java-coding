/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class PrimeFactors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<List<Integer>> primefactors = new ArrayList<>();
        for(int i=0;i<1001;i++){
            primefactors.add(new ArrayList<Integer>());
        }
        for(int i=2;i<1001/2;i++){
            for(int j=i+i;j<1001;j+=i){
                if(primefactors.get(i).isEmpty())
                    primefactors.get(j).add(i);
            }
        }
        for(int i=0;i<1001;i++){
            System.out.println(i+" "+primefactors.get(i));
        }
        
    }
}
