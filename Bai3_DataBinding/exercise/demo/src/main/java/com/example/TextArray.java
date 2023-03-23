package com.example;

import java.util.Scanner;

public class TextArray {
    // method input array
    public static Scanner sc = new Scanner(System.in);
    public static void inputArray(int sizeArray, int[] array){
        for(int i= 0;i<array.length;i++){
            System.out.println("Input number: "+ i);
            array[i] = sc.nextInt();
        }
    }
    public static void outputArray( int[] array){
        for(int i= 0;i<array.length;i++){
            System.out.print( array[i]+" ");
        }
    }
    public static void minMax(int[] array){
        int min =array[0];
        int max= array[0];
        for(int i=0; i<array.length;i++){
            if(array[i]>max)
                max=array[i];
            if(array[i]<min)
                min=array[i];
        }
        System.out.println("min: "+min+" max: "+max);
    }
    public static int count(int[] array){
        int count=0;
        for(int i= 0; i<array.length;i++){
            if(array[i]%2==0){
                count++;
            }
        }
        return count;
    }
    public static int[] sort(int[] array){
        for(int i=0;i<array.length-1;i++){
            for(int j=i+1;j<array.length;j++){
                if(array[i]>array[j]){
                    int tmp= array[i];
                    array[i]=array[j];
                    array[j]=tmp;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        System.out.println("Input number");
        int n = sc.nextInt();
        int[] arrays = new int[n];
        inputArray(n,arrays);
        outputArray(arrays);
        minMax(arrays);
        System.out.println(count(arrays));
        for(int i=0;i<sort(arrays).length;i++){
            System.out.print( arrays[i]+" ");
        }

    }

}
