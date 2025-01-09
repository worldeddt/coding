package code.baekjoon.simulation.아기상어;

import java.util.Scanner;

public class Main {
    static int N;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static boolean[][] visited;
    static int[][] map;
    static int[] locationShark;
    static int second;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();

                if (map[i][j] == 9) {
                    locationShark[0] = i;
                    locationShark[1] = j;
                }
            }
        }


    }

    public static void hunt() {

    }
}
