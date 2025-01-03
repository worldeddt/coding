package code.codingtest.DfsBfs.그래프최단거리bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Application {
    static int n, m, answer = 0;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch, dis;

    /*
    6 9
    1 2
    1 3
    1 4
    2 1
    2 5
    3 4
    4 5
    4 6
    6 2
    6 5
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        graph = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        ch = new int[n + 1];
        dis = new int[n + 1];

        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph.get(a).add(b);
        }

        bfs(1);

        for(int i = 2; i<=n; i++) {
            System.out.println(i+": "+dis[i]);
        }
    }

    public static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        ch[v] = 1;
        dis[v] = 0;
        queue.offer(v);

        while (!queue.isEmpty()) {
            int cv = queue.poll();

            for (int nv : graph.get(cv)) {
                if (ch[nv] == 0) {
                    ch[nv] = 1;
                    queue.offer(nv);
                    dis[nv] = dis[cv] + 1;
                }
            }
        }
    }
}
