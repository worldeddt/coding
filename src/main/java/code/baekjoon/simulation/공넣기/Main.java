package code.baekjoon.simulation.공넣기;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int N, M;
    static int[][] board;
    static int[] buckets;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        N = sc.nextInt();
        M = sc.nextInt();
        buckets = new int[N];
        board = new int[M][3];

        for(int i = 0 ; i < M; i++) {
            for (int j = 0 ; j < 3 ; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = board[i][0] - 1; j < board[i][1]; j++) {
                buckets[j] = board[i][2];
            }
        }

        for(int i = 0; i<buckets.length; i++) {
            System.out.printf(buckets[i]+" ");
        }
    }
}
