package code.baekjoon.dfs.q14888연산자끼워넣기;

import java.util.Scanner;

//https://www.acmicpc.net/problem/14888

public class Main {
    static int N;
    static int[] numbers;
    static int[] operators; // [덧셈, 뺄셈, 곱셈, 나눗셈] 순서
    static int maxValue = Integer.MIN_VALUE;
    static int minValue = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        N = sc.nextInt();
        numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        operators = new int[4];  // +, -, *, /
        for (int i = 0; i < 4; i++) {
            operators[i] = sc.nextInt();
        }

        // 백트래킹 시작
        backtrack(numbers[0], 1);

        // 결과 출력
        System.out.println(maxValue);
        System.out.println(minValue);
        sc.close();
    }

    // 백트래킹 메서드 (재귀적으로 연산자를 적용)
    private static void backtrack(int currentResult, int index) {
        // 모든 연산자를 다 사용한 경우
        if (index == N) {
            maxValue = Math.max(maxValue, currentResult);
            minValue = Math.min(minValue, currentResult);
            return;
        }

        // 각 연산자를 순회하며 백트래킹 수행
        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;  // 연산자 사용
                if (i == 0) {
                    backtrack(currentResult + numbers[index], index + 1);
                } else if (i == 1) {
                    backtrack(currentResult - numbers[index], index + 1);
                } else if (i == 2) {
                    backtrack(currentResult * numbers[index], index + 1);
                } else if (i == 3) {
                    backtrack(division(currentResult, numbers[index]), index + 1);
                }
                operators[i]++;  // 백트래킹 (연산자 복구)
            }
        }
    }

    // 정수 나눗셈 (음수 처리)
    private static int division(int a, int b) {
        if (a < 0) {
            return -(-a / b);
        } else {
            return a / b;
        }
    }
}