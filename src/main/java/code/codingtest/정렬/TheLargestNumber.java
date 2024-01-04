package code.codingtest.정렬;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Array;
import java.util.*;

@Slf4j
@SpringBootApplication
public class TheLargestNumber {

    static String answer = "";
    static String temp = "0";

    public static void main(String[] args) {
        SpringApplication.run(TheLargestNumber.class, args);

        TheLargestNumber theLargestNumber = new TheLargestNumber();

        Scanner kb = new Scanner(System.in);

        Integer n = kb.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i< n; i++) {
            arr[i] = kb.nextInt();
        }

        List<Integer> list1 = new ArrayList<>(Arrays.asList(arr));

        Integer count = 0;
        while(count <= list1.size()) {
            theLargestNumber.solve(list1);
            count++;
        }
        log.info("the answer : {}", temp);
    }

//    [3, 30, 34, 5, 9]
    private void solve(List<Integer> list) {
        answer = "";

        for (int i = 0; i < list.size() ; i++) {
            answer = answer+String.valueOf(list.get(i));
        }

        log.info("answer : {}, temp : {}", answer, temp);
        list.add(list.get(0));
        list.remove(0);
        if (Integer.valueOf(answer) > Integer.valueOf(temp)) {
            temp = answer;
        }
    }
}
