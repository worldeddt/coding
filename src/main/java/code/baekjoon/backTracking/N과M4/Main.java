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

    public static void back(int start, int depth) { //1

        if (depth == M) {
            for (int num : sequence) { // 1 1, 1 2, 1 3 ..
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i<=N; i++) {
            sequence[depth] = i; //[1] = 1, 2, 3, 4
            back(i, depth + 1);
        }
    }
}
