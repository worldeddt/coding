package code.codingtest.Bubble;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;


@SpringBootApplication
public class BUBBLE {
    static int n;
    static int r;
    public static void main(String[] args) {

        SpringApplication.run(BUBBLE.class, args);

        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();

        for (int i =0; i<n; i++) {
            r = kb.nextInt();
        }
    }

}
