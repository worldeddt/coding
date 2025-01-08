package code.baekjoon.bfs.q11123양무리.본인;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int T, H, W;
    static char[][] map;
    static boolean[][] visited;
    static int[][] distance;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();
        sc.nextLine(); // 개행 문자 소모
        H = sc.nextInt();
        W = sc.nextInt();
        sc.nextLine(); // 개행 문자 소모

        map = new char[H][W];
        visited = new boolean[H][W];

        // 미로 정보 입력 및 초기화
        for (int i = 0; i < H; i++) {
            String line = sc.nextLine();  // 한 줄 입력받기
            for (int j = 0; j < W; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        System.out.printf("group : "+bfs(0, 0));
    }

    public static int bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        visited[x][y] = true;
        int group = 0;

        while(!queue.isEmpty()) {

            Point poll = queue.poll();
            int nx = poll.x, ny = poll.y;

            for (int i = 0; i < 4; i++) {
                int nx2 = nx + dx[i];
                int ny2 = ny + dy[i];

                if (nx2 < H && nx2 > 0 && ny2 < W && ny2 > 0 && !visited[nx2][ny2]) {
                    visited[nx][ny] = true;
                    if (map[nx2][ny2] == '#') group++;
//                    if (map[nx2 - 1][ny2 - 1] == '#' && map[nx2][ny2] == '#') {
//
//                    }
                    queue.offer(new Point(nx2, ny2));
                }
            }
        }

        return group;
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
