package code.baekjoon.bfs.q1261q알고스팟.답;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    /*
    33011111110
     */
    static int N, M;
    static int[][] map;
    static int[][] distance;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 행렬 크기 입력
        M = sc.nextInt();
        N = sc.nextInt();
        sc.nextLine(); // 개행 문자 소모

        map = new int[N][M];
        distance = new int[N][M];

        // 미로 정보 입력 및 초기화
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();  // 한 줄 입력받기
            Arrays.fill(distance[i], Integer.MAX_VALUE);  // 거리 배열 초기화
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';  // 문자 하나씩 숫자로 변환
            }
        }

        // 0-1 BFS 실행
        bfs();

        // 결과 출력 (N-1, M-1)까지의 최소 벽 부수기
        System.out.println(distance[N - 1][M - 1]);

        sc.close();  // Scanner 닫기
    }

    private static void bfs() {
        Deque<int[]> deque = new LinkedList<>();
        deque.add(new int[]{0, 0});
        distance[0][0] = 0;

        while (!deque.isEmpty()) {
            int[] current = deque.pollFirst();
            int x = current[0];
            int y = current[1];

            // 4방향 탐색
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                // 경계 체크
                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    int nextCost = distance[x][y] + map[nx][ny]; // 벽이면 +1, 빈 방이면 +0

                    System.out.println("x :"+x);
                    System.out.println("y :"+y);
                    System.out.println("nx :"+nx);
                    System.out.println("ny :"+ny);
                    System.out.println("nextCost :"+nextCost);
                    System.out.println("distance[nx][ny] :"+distance[nx][ny]);
                    // 새로운 경로가 더 짧을 경우만 갱신
                    if (nextCost < distance[nx][ny]) {
                        distance[nx][ny] = nextCost;
                        if (map[nx][ny] == 0) {
                            deque.addFirst(new int[]{nx, ny}); // 빈 방일 경우 우선 탐색
                        } else {
                            deque.addLast(new int[]{nx, ny});  // 벽일 경우 나중에 탐색
                        }
                    }
                }
            }
        }
    }
}
