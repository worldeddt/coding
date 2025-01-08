package code.baekjoon.backTracking.N과M5;

import java.util.Scanner;

//https://www.acmicpc.net/problem/15654
public class Main {

    static int N, M;
    static int[] numbers;
    static int[] sequence;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        numbers = new int[N];
        sequence = new int[M];

        for(int i = 0 ; i < N ; i++) {
            numbers[i] = sc.nextInt();
        }
        back(1, 0);
    }

    public static void back(int start, int depth) {
        if (depth == N) {

            for (int num : sequence) {
                System.out.print(num + " ");
            }

            System.out.println();
            return;
        }
         
        for(int i = start;  i< N; i++) {
            sequence[depth] = i;
            back(i, depth + 1);
        }
    }
}
