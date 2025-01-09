package code.baekjoon.backTracking.감시;

import java.util.Scanner;

public class Main {

    static int N, M;
    static int[][] board;
    static char shop = '#';

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

            }
        }
        back(0, 0);
    }

    public static void back(int x, int y) {

        int chars = board[x][y];


        if (chars == 1) {

        } else if (chars == 2) {

        } else if (chars == 3) {

        } else if (chars == 4) {

        } else if (chars == 5) {

        }
    }
}
