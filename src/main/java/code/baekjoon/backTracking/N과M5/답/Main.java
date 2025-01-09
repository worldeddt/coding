package code.baekjoon.backTracking.N과M5.답;

import java.util.Arrays;
import java.util.Scanner;


public class Main {
    static int N, M;
    static int[] numbers;
    static int[] sequence;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        N = sc.nextInt();
        M = sc.nextInt();
        numbers = new int[N];
        sequence = new int[M];
        visited = new boolean[N];

        // 수열 입력 및 정렬 (사전순 출력을 위함)
        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }
        Arrays.sort(numbers); // 오름차순 정렬

        // 백트래킹 시작
        backtrack(0);
        sc.close();
    }

    // 백트래킹 메서드 (중복되지 않는 순열 생성)
    private static void backtrack(int depth) {
        // 수열 완성 시 출력
        if (depth == M) {
            for (int num : sequence) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        // 순서대로 하나씩 선택 (중복 방지)
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {  // 아직 사용하지 않은 수만 사용
                visited[i] = true;
                sequence[depth] = numbers[i];
                backtrack(depth + 1);  // 다음 깊이 탐색
                visited[i] = false;  // 백트래킹 (원상 복구)
            }
        }
    }
}
