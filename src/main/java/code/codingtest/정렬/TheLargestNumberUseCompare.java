package code.codingtest.정렬;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Comparator;

@Slf4j
@SpringBootApplication
public class TheLargestNumberUseCompare {

    public static void main(String[] args) {
        int[] numbers2 = {3, 30, 34, 5, 9};

        log.info("solve : {}",solve(numbers2));
    }

    static String solve(int[] numbers) {
        // 숫자를 문자열로 변환하여 비교
        String[] numStrings = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numStrings[i] = String.valueOf(numbers[i]);
        }

        // 비교 함수 정의
        Arrays.sort(numStrings, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                // a와 b를 합친 결과와 b와 a를 합친 결과를 비교하여 내림차순 정렬
                log.info("number b a : {}", b + a);
                log.info("number a b : {}", a + b);
                log.info("-----------");

                return (b + a).compareTo(a + b);
            }
        });

        // 정렬된 문자열을 이어붙여 결과 반환
        StringBuilder result = new StringBuilder();
        for (String numString : numStrings) {
            log.info("number : {}", numString);
            result.append(numString);
        }

        // 만약 결과가 "0"으로 시작한다면 배열이 모두 0인 경우이므로 "0"을 반환
        if (result.charAt(0) == '0') {
            return "0";
        }

        return result.toString();
    }
}
