package code.codingtest.DfsBfs.재귀함수.강의풀이;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        String result = "";
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        dfs(i);
    }

    public static void dfs(int n) {
        if (n==0) return ;
        else {
            dfs(n-1);
            System.out.print(n+" ");
        }
    }
}
