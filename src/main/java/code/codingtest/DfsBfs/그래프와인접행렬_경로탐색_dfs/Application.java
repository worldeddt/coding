package code.codingtest.DfsBfs.그래프와인접행렬_경로탐색_dfs;

import java.util.Scanner;

public class Application {
    static int n, m, answer = 0;
    static int[][] graph;
    static int[] ch;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        graph = new int[n + 1][n + 1];
        ch = new int[n + 1];

        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph[a][b] = 1;
        }

        ch[1] = 1;
        dfs(1);
        System.out.println(answer);
    }

    public static void dfs(int v) {
        if (v==n) {
            answer++;
        } else {
            for (int i = 1; i<=n; i++) {
                if (graph[v][i] == 1 && ch[i] == 0) {
                    ch[i] = 1;
                    dfs(i);
                    ch[i] = 0;
                }
            }
        }
    }

    /*
    5 9
    1 2
    1 3
    1 4
    2 1
    2 3
    2 5
    3 4
    4 2
    4 5
     */
}
