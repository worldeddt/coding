package code.codingtest.DfsBfs활용.합이같은부분집합;

import java.util.Scanner;

public class Application {
    static int n, total = 0;
    static String answer = "NO";
    static boolean flag;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            total += arr[i];
        }

        int i = total % 2;

        if (i > 0) {
            System.out.printf("answer 1 : "+answer);
            return;
        }

        dfs(0, 0, arr);

        System.out.printf("answer 2 : "+answer);
    }

    public static void dfs(int L, int sum, int[] arr) {
        if (flag) return;
        if (L == n) {
            if ((total - sum) == sum) {
                answer = "YES";
                flag = true;
            }
        } else {
            dfs(L + 1, sum, arr);
            dfs(L + 1, sum - arr[L], arr);
        }
    }
}
