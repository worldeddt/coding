package code.baekjoon.dfs.q2583영역구하기;

import java.util.*;

public class Main {
    static int N,M,K;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static int[][] maps;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();

        maps = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < K; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    maps[y][x] = 1;  // 직사각형 영역 채우기
                }
            }
        }

        List<Integer> arr = new ArrayList<>();

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                if (maps[x][y] == 0 && !visited[x][y]) {
                    int areaSize = bfs(x, y);
                    arr.add(areaSize);
                }
            }
        }
        Collections.sort(arr);

        System.out.println(arr.size());
        for (int size : arr) {
            System.out.print(size + " ");
        }
    }

    public static int bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        visited[x][y] = true;

        int areaSize = 0;

        while (!q.isEmpty()) {
            Point p = q.poll();
            areaSize++;

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx > 0 && ny > 0 && nx < N && ny < M ) {
                    if (maps[nx][ny] == 0 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.offer(new Point(nx, ny));
                    }
                }
            }
        }

        return areaSize;
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
