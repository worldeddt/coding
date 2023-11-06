package code.codingtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class CodingTestApplication {
    static String answer = "NO";
    static int total, n = 0;
    boolean flag = false;

    public static void main(String[] args) {
        SpringApplication.run(CodingTestApplication.class, args);

        CodingTestApplication codingTestApplication = new CodingTestApplication();

        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i< n; i++) {
            arr[i] = kb.nextInt();
            total += arr[i];
        }
        codingTestApplication.DFS(0,0, arr);
    }

    // 1 3 5 6 7 9 10
    public void DFS(int L, int sum, int[] arr) {
        if (flag) return;
        if (sum > total/2) return;
        if (L == n) {
            if ((total-sum) == sum) {
                answer = "YES";
                flag = true;
            }
        } else {
            DFS(L+1, sum+arr[L], arr);
            DFS(L+1, sum, arr);
        }
    }
}
