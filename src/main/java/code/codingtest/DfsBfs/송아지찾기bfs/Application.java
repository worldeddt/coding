package code.codingtest.DfsBfs.송아지찾기bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Application {

    static int answer = 0;
    static int[] dis = {1, -1, 5};
    static int[] ch;
    static Queue<Integer> queue = new LinkedList<>();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        int e = scanner.nextInt();

        System.out.println(bfs(s, e));
    }

    public static int bfs(int s, int e) {
        ch = new int[10001];
        ch[s] = 1;
        queue.add(5);
        int L = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int poll = queue.poll();
                for (int j = 0; j < dis.length; j++) {
                    int i1 = poll + dis[j];
                    if (poll == e) return L;

                    if (i1 > 1 && i1 < 10001 && ch[i1] == 0) {
                        ch[i1] = 1;
                        queue.offer(i1);
                    }
                }
            }
            L++;
        }

        return L;
    }
}
