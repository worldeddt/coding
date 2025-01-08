package code.baekjoon.backTracking.N과M4;

import java.util.*;

// https://www.acmicpc.net/problem/15652
public class Main {

    static int N, M;
    static int[] numbers;
    static int[] sequence;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 4
        M = sc.nextInt(); // 2
        numbers = new int[N + 1];

        sequence = new int[M];

        back(1, 0);
        sc.close();
    }

    public static void back(int start, int depth) {

        if (depth == M) {
            for (int num : sequence) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i<=N; i++) {
            sequence[depth] = i;
            back(i, depth + 1);
        }
    }
}
