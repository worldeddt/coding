package code.codingtest.DfsBfs.팩토리얼.강의풀이;


import java.util.Scanner;

public class Application {

    // Q. 자연수 N이 입력되면 N!을 구하는 프로그램 작성

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();

        System.out.print(dfs(i));
    }

    public static int dfs(int n) {
        if (n==1)return 1;
        else return n * dfs(n-1);
    }
}
