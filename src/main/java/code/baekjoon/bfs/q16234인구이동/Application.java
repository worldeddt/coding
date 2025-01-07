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

        int days = 0; // 인구 이동 발생 일수.

        //방문 시작
        while(true) {
            visited = new boolean[N][N];
            boolean moved = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        if (search(i,j)) {
                            moved = true;
                        }
                    }
                }
            }

            if (!moved) break;
            days++;
        }

        System.out.println(days);
    }

    public static boolean search(int x, int y) {
        Queue<int[]> nations = new LinkedList<>();
        List<int[]> union = new ArrayList<>();

        nations.offer(new int[]{x, y});
        union.add(new int[]{x, y});
        visited[x][y] = true;
        int totalPopulation = population[x][y];

        while(!nations.isEmpty()) {
            int[] current = nations.poll();
            int cx = current[0], cy = current[1];

            for(int i=0; i<4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
                    int diffPopulation = Math.abs(population[cx][cy] - population[nx][ny]);

                    // 국경선을 열어야 한다.
                    if (diffPopulation >= L && diffPopulation <= R) {
                        visited[nx][ny] = true;
                        nations.offer(new int[]{nx, ny});
                        union.add(new int[]{nx, ny});
                        totalPopulation += population[nx][ny];
                    }
                }
            }
        }

        if (union.size() == 1) {
            return false;
        }

        int averagePopulation = totalPopulation / N;

        for (int[] coord: union) {
            population[coord[0]][coord[1]] = averagePopulation;
        }

        return true;
    }

}
