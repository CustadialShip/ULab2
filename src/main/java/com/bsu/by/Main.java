package com.bsu.by;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("length of the main diagonal");
            int el1 = sc.nextInt();
            if (el1 <= 0) {
                throw new Exception("wrong number");
            }

            int[][] arr1 = randMatrix(new int[el1][el1]);
            int[][] arr2 = randMatrix(new int[el1][el1]);

            outputArr(arr1);
            System.out.println();
            outputArr(arr2);
            System.out.println();
            outputArr(calcMatrix(arr1, arr2));
            System.out.println();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static void outputArr(int[][] arr) {
        for (int[] i : arr) {
            for (int k : i) {
                System.out.print(k + " ");
            }
            System.out.println();
        }
    }

    public static int maxValueRow(int[][] arr, int numOfRow) {
        int maxEl = arr[numOfRow][0];
        for (int i = 0; i < arr[numOfRow].length; i++) {
            if (maxEl < arr[numOfRow][i]) {
                maxEl = arr[numOfRow][i];
            }
        }
        return maxEl;
    }

    public static int[][] randMatrix(int[][] arr) {
        int minRand = 0;
        int maxRand = 5;
        int diff = maxRand - minRand;
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            for (int k = 0; k < arr[i].length; k++) {
                arr[i][k] = rand.nextInt(diff + 1);
                arr[i][k] += minRand;
            }
        }
        return arr;
    }

    public static int[][] calcMatrix(int[][] arr1, int[][] arr2) {
        int maxEl;
        int length = arr1.length;
        int[][] arrFinal = new int[length][length];
        for (int i = 0; i < arr1.length; i++) {
            maxEl = maxValueRow(arr2, i);
            for (int j = 0; j < arr2.length; j++) {
                arrFinal[i][j] = arr1[i][j] * maxEl;
            }
        }
        return arrFinal;
    }
}
