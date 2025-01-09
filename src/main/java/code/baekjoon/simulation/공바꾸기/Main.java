package code.baekjoon.simulation.공바꾸기;

import java.util.Scanner;

public class Main {

    static int N, M;
    static int[] buckets;
    static int[][] maps;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        buckets = new int[N];
        maps = new int[M][2];
        for (int i = 0; i < N; i++) {
            buckets[i] = i+1;
        }

        for (int i = 0; i < M; i++) {
            for(int j = 0; j < 2; j++) {
                maps[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < M; i++) {
            int temp = buckets[maps[i][0] - 1];
            buckets[maps[i][0] - 1] = buckets[maps[i][1] - 1];
            buckets[maps[i][1] - 1] = temp;
        }

        for (int i = 0; i < N; i++) {
            System.out.printf("%d ", buckets[i]);
        }
    }
}
