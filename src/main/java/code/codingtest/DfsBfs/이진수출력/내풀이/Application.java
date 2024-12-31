package code.codingtest.DfsBfs.이진수출력.내풀이;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();


        dfs(i);
    }


    public static void dfs(int n) {
        if (n == 0) return;
        else {
            int remain = n % 2;
            int root = n / 2;
            System.out.print(""+remain);
            dfs(root);
        }
    }
}
