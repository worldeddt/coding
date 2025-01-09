package code.baekjoon.backTracking.N과M5.본인;

import java.util.Arrays;
import java.util.Scanner;

//https://www.acmicpc.net/problem/15654
public class Main {

    static int N, M;
    static int[] numbers;
    static String[] sequence;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        numbers = new int[N];
        sequence = new String[M];

        for(int i = 0 ; i < N ; i++) {
            numbers[i] = sc.nextInt();
        }

        Arrays.sort(numbers);

        back(0, 0);
    }

    public static void back(int start, int depth) {
        if (depth == M) {
            for (String num: sequence) {
                System.out.printf(num+" ");
            }

            System.out.println();
            return;
        }

        for (int i = start; i < N; i++) {
            sequence[depth] = String.valueOf(numbers[i]);
            back(start + 1, depth + 1);
        }
    }
}
