package code.baekjoon.bfs.q1261q알고스팟;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//https://www.acmicpc.net/problem/1261
public class Main {

    static int N,M;
    static boolean[][] visited;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int[][] board;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        board = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i< N; i++) {
            for (int j = 0; j< M; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        visited[1][1] = true;

        System.out.println("result : "+bfs(1,1));
    }

    public static int bfs(int x, int y) {
        Queue<Point> points = new LinkedList<>();

        int brokenWall = 0;

        while (!points.isEmpty()) {
            Point p = points.poll();

            for (int i = 1; i <= 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];


                if (nx >= 1 && ny >= 1 && nx < N && ny < M && !visited[nx][ny]) {
                    if (board[nx][ny] == 1) brokenWall++;

                    points.offer(new Point(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }

        return brokenWall;
    }
}


class Point {
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
