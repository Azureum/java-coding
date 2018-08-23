/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author HP
 */
public class asd {
    public static void main(String[] args){
        int n=9;
        char[] arr  = {'5','2'};
        arr[0] = String.valueOf(n).charAt(0);
        System.out.println(arr);
        String s = String.copyValueOf(arr);
        System.out.println(s);
        int newnum =Integer.parseInt(s);
        System.out.println(newnum);
    }
}
