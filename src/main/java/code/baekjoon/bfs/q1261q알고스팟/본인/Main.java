package code.baekjoon.bfs.q1261q알고스팟.본인;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//https://www.acmicpc.net/problem/1261
public class Main {

    static int N,M;
    static boolean[][] visited;
    static int[][] distance;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int[][] board;

    /**
     3 3
     011
     111
     110

     4 2
     0001
     1000

     6 6
     001111
     010000
     001111
     110001
     011010
     100010
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        board = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];

        board[0][0] = 1;

        for (int i = 1; i<= N; i++) {
            for (int j = 1; j <= M; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        visited[1][1] = true;

        System.out.println("result : "+bfs(1,1));
    }

    public static int bfs(int x, int y) {
        Queue<Point> points = new LinkedList<>();

        int brokenWall = 0;
        points.offer(new Point(x, y));

        while (!points.isEmpty()) {
            Point p = points.poll();

            for (int i = 0; i < 4; i++) {
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
