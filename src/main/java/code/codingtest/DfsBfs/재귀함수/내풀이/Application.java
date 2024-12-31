package code.codingtest.DfsBfs.재귀함수.내풀이;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        String result = "";
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();

        if (i > 1) {
            dfs(result, i, 1);
        } else {
            System.out.println("result : 0");
        }
    }

    public static void dfs(String result, int max, int stack) {
        if (stack <= max) {

            if (result != null) {
                result = result+" "+stack;
            }

            dfs(result, max, stack+1);
        } else {
            System.out.println("result : "+result);
        }
    }
}
