package code.baekjoon.backTracking.모든순열.본인;


import java.util.Scanner;

public class Main {

    static int N;
    static boolean[] visited;
    static int[] sequence;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        visited = new boolean[N];
        sequence = new int[N];

        back(0);
        sc.close();
    }

    public static void back(int depth) {
        if (depth == N) {
            for (int num : sequence) {
                System.out.printf("%d ", num);
            }

            System.out.println();
            return;
        }


        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sequence[depth] = i + 1;
                back(depth + 1);
                visited[i] = false;
            }
        }
    }
}
