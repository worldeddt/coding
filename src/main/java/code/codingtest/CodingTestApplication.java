package code.codingtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CodingTestApplication {

    static int n;
    static int[] ch;

    public static void main(String[] args) {
        SpringApplication.run(CodingTestApplication.class, args);

        CodingTestApplication codingTestApplication = new CodingTestApplication();
        n = 3;
        ch = new int[n+1];
        codingTestApplication.DFS(1);
    }


    public void DFS(int L) {
        System.out.println("I : "+L);
        if (L == n+1) {
            String temp = "";
            for (int i =1; i<=n; i++) {
                if (ch[i] == i) temp+=(i+" ");
            }
//            if (temp.length() > 0) System.out.println(temp);
        } else {
            ch[L] = 1;
            System.out.printf("ch[L] : %d  L : %d %n",ch[L],L);
            DFS(L+1);
            ch[L] = 0;
            System.out.printf("ch[L] : %d  L : %d %n",ch[L],L);
            DFS(L+1);
        }
    }
}
