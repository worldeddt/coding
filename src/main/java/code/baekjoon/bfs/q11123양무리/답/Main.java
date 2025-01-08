package code.baekjoon.bfs.q11123양무리.답;

import java.util.*;

/*
https://www.acmicpc.net/problem/11123

2
4 4
#.#.
.#.#
#.##
.#.#
3 5
###.#
..#..
#.###
 */

public class Main {
    static int H, W; // 그리드의 높이와 너비
    static char[][] grid; // 양과 풀의 상태 저장
    static boolean[][] visited; // 방문 여부 체크
    static int[] dx = {0, 0, -1, 1}; // 상하좌우만 탐색
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); // 테스트 케이스 수
        for (int t = 0; t < T; t++) {
            H = sc.nextInt();
            W = sc.nextInt();
            sc.nextLine(); // 개행 문자 소모

            grid = new char[H][W];
            visited = new boolean[H][W];

            // 그리드 입력 받기
            for (int i = 0; i < H; i++) {
                String line = sc.nextLine();
                for (int j = 0; j < W; j++) {
                    grid[i][j] = line.charAt(j);
                }
            }

            int sheepClusters = 0; // 양 무리 개수

            // 모든 셀을 순회하며 BFS 수행
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    // 방문하지 않았고, 양(#)이면 탐색 시작
                    if (!visited[i][j] && grid[i][j] == '#') {
                        bfs(i, j);
                        sheepClusters++; // 새로운 무리 발견
                    }
                }
            }

            // 결과 출력
            System.out.println(sheepClusters);
        }
        sc.close();
    }

    // BFS를 사용하여 상하좌우만 탐색
    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            // 상하좌우 방향 탐색
            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                // 경계 내에 있고, 방문하지 않았으며, 양(#)인 경우
                if (nx >= 0 && ny >= 0 && nx < H && ny < W) {
                    if (!visited[nx][ny] && grid[nx][ny] == '#') {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
