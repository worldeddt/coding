package code.codingtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class CodingTestApplication {
    static int n;
    static int[] ch;

    public static void main(String[] args) {
        SpringApplication.run(CodingTestApplication.class, args);

        CodingTestApplication codingTestApplication = new CodingTestApplication();

        Integer i = 12;
        Integer.toString(i).length();

        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        ch=new int[n+1];
        codingTestApplication.DFS(1);
    }

    public void DFS(int L) {
        if (L == n+1) {
            // 종착점
            String tmp = "";
            for (int i =1; i<=n; i++) {
                if (ch[i] == 1) tmp += (i+" ");
            }

            if(tmp.length()>0) System.out.println(tmp);

        } else {
            ch[L] = 1;
            DFS(L+1);
            ch[L] = 0;
            DFS(L+1);
        }
    }
}
