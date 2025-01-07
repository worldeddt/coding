package code.baekjoon.bfs.q16234인구이동;

import java.io.IOException;
import java.util.*;

public class Application {

    static int N,L,R;
    static int[][] population;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        L = sc.nextInt();
        R = sc.nextInt();

        population = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                population[i][j] = sc.nextInt();
            }
        }

        int days = 0;  // 인구 이동 발생 일수

        while (true) {
            visited = new boolean[N][N];
            boolean moved = false; // 하루 동안 인구 이동 발생 여부 체크

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // 방문하지 않은 국가에 대해 BFS 수행
                    if (!visited[i][j]) {
                        List<int[]> union = bfs(i, j); // 연합 찾기

                        // 연합이 2개 이상이어야 인구 이동 발생
                        if (union.size() > 1) {
                            moved = true;
                            int totalPopulation = 0;
                            for (int[] country : union) {
                                totalPopulation += population[country[0]][country[1]];
                            }
                            int averagePopulation = totalPopulation / union.size();

                            // 인구 재배치
                            for (int[] country : union) {
                                population[country[0]][country[1]] = averagePopulation;
                            }
                        }
                    }
                }
            }

            // 인구 이동이 발생하지 않았다면 종료
            if (!moved) break;
            days++; // 하루 증가
        }

        System.out.println(days);
    }

    // BFS를 사용하여 연합을 찾고, 해당 연합을 반환하는 메서드
    private static List<int[]> bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> union = new ArrayList<>();

        queue.add(new int[]{x, y});
        union.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            // 4방향 탐색
            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
                    int diff = Math.abs(population[cx][cy] - population[nx][ny]);
                    if (diff >= L && diff <= R) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                        union.add(new int[]{nx, ny});
                    }
                }
            }
        }
        return union;
    }

}
