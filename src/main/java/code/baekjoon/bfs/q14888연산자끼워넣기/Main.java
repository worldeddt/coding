package code.baekjoon.bfs.q14888연산자끼워넣기;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//https://www.acmicpc.net/problem/14888
public class Main {
    static int line;
    static int[] numbers;
    static int[] operators;
    static List<Integer> results = new ArrayList<>();
    static int maxValue = Integer.MIN_VALUE;
    static int minValue = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        line = sc.nextInt();
        numbers = new int[line];
        sc.nextLine();

        for (int i = 0; i < line; i++) {
            numbers[i] = sc.nextInt();
        }

        sc.nextLine();

        operators = new int[4];
        for (int i = 0; i < 4; i++) {
            operators[i] = sc.nextInt();
        }

        /*
        plus
        minus
        mul
        div
         */
        dfs(numbers[0], 1);

        System.out.println(maxValue);
        System.out.println(minValue);

        sc.close();
    }

    public static void dfs(int currentResult, int index) {

        if (index == line) {
            maxValue = Math.max(maxValue, currentResult);
            minValue = Math.min(minValue, currentResult);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;

                switch (i) {
                    case 0 ->   dfs(currentResult + numbers[index], index + 1);
                    case 1 ->   dfs(currentResult - numbers[index], index + 1);
                    case 2 ->   dfs(currentResult * numbers[index], index + 1);
                    case 3 ->   dfs(division(currentResult , numbers[index]), index + 1);
                }

                operators[i]++;
            }
        }
    }

    private static int division(int a, int b) {
        if (a < 0) {
            return -(-a/b);
        } else {
            return a/b;
        }
    }
}
