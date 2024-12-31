package code.codingtest.DfsBfs.피보나치재귀.내풀이;


import java.util.Scanner;

public class Application {

    // 피보나치 수열
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();

        for (int j = 1; j <= i; j++) {
            System.out.print(dfs(j)+" ");
        }
    }

    public static int dfs(int n) {

        if (n == 1) return 1;
        else if (n == 2) return 1;
        else {
            return  dfs(n - 2) + dfs(n - 1);
        }
    }
}
