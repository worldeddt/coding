package code.codingtest.DFS;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class 타겟_넘버 {
    static int[] numbers = {1,1,1,1};

    static int target = 2;

    static int[][] dy = new int[45][45];

    public static void main(String[] args) {
        SpringApplication.run(타겟_넘버.class, args);

        타겟_넘버 타겟_넘버s = new 타겟_넘버();

        int result = 타겟_넘버s.combi(0, 0);

        System.out.println("result :"+result);
    }

    private int combi(int L, int sum) {

        if (L == numbers.length) {
            return sum == target ? 1:0;
        }

        return combi(L+1, sum + numbers[L]) +
                combi(L+1, sum - numbers[L]);

    }
}
