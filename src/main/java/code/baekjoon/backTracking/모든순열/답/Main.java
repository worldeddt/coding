package code.baekjoon.backTracking.모든순열.답;

import java.util.Scanner;

public class Main {
    static int N;
    static int[] sequence;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder(); // 출력 최적화

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        N = sc.nextInt();
        sequence = new int[N];
        visited = new boolean[N + 1];  // 1부터 N까지 사용

        // 백트래킹 호출
        backtrack(0);

        // 최종 출력
        System.out.println(sb.toString());
        sc.close();
    }

    public static void backtrack(int depth) {
        // 수열 완성 시 출력
        if (depth == N) {
            for (int num : sequence) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        // 1부터 N까지 순회 (중복 방지)
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;  // 사용 처리
                sequence[depth] = i;
                backtrack(depth + 1);  // 재귀 호출
                visited[i] = false;  // 백트래킹 (원상 복구)
            }
        }
    }
}