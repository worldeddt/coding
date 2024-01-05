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
        int[] arr = new int[n];
        for (int i = 0; i< n; i++) {
            arr[i] = kb.nextInt();
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPermutation = new ArrayList<>();
        boolean[] used = new boolean[arr.length];

        solve(arr, used, currentPermutation, result);
        String response = "0";

        for (List<Integer> re : result) {
            String answer = "";
            for (Integer pro : re) {
                answer += pro.toString();
            }

            if (Integer.parseInt(answer) >  Integer.parseInt(response)) {
                 response = answer;
            }
        }

        log.info("result : {}", response);
    }

//    [3, 30, 34, 5, 9]
    static void solve(int[] nums, boolean[] used,
                       List<Integer> currentPermutation, List<List<Integer>> result) {

        // 2 일때,
        if (currentPermutation.size() == nums.length) {
            result.add(new ArrayList<>(currentPermutation));
            return;
        }

        for( int i = 0; i<nums.length; i++) {
            if (used[i]) continue;

            used[i] = true;
            currentPermutation.add(nums[i]);//6, 10, 2
            printCurrent(currentPermutation);
            solve(nums, used, currentPermutation, result);
            used[i] = false;//2, 10, 6
            currentPermutation.remove(currentPermutation.size() - 1); // 끝에서부터 제거
        }
    }

    static void printCurrent(List<Integer> current) {
        String result = "";
        for (Integer num : current) {
            result += num.toString();
        }

        log.info("current combination : {}", result);
    }
}
