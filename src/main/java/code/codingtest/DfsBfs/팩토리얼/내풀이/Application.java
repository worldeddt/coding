package code.codingtest.DfsBfs.팩토리얼.내풀이;

import java.util.Scanner;

public class Application {
    // Q. 자연수 N이 입력되면 N!을 구하는 프로그램 작성

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();

        dfs(i, 0, "");
    }

    public static void dfs(int n, int result, String facString) {
        if (n==0 || n > 101) {
            System.out.println(facString+" result: "+result);
        }
        else {
            if (result != 0) {
                result = n * result;
                facString = facString + "*"+n+"";
            } else {
                result = n;
                facString = n+"";
            }

            dfs(n-1, result, facString);
        }
    }
}
