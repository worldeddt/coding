package code.codingtest.DfsBfs.부분집합구하기;

import java.util.Map;
import java.util.Scanner;

public class Application {

    static int[] ch;
    static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        ch = new int[n+1];
        dfs(1);
    }

    public static void dfs(int L) {
        if (L == n + 1) {
            for (int i = 0; i < ch.length; i++) {
                if (ch[i] == 1) {
                    System.out.printf("%d ", i);
                }
            }
            System.out.println();
        } else {
            ch[L] = 1;
            dfs(L + 1);
            ch[L] = 0;
            dfs(L+1);
        }
    }
}
