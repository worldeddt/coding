package code.codingtest.DFS;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootApplication
public class 여행경로 {

    private List<String> answer;
    /**
     [["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]]
     @result ["ICN", "JFK", "HND", "IAD"]
     [["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]]
     @result ["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"]
     */
    public static void main(String[] args) {
        여행경로 ma = new 여행경로();
//        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};

        String[] result2 = ma.solution(tickets);

        for (String re : result2) {
            log.info("result : {}", re);
        }

    }

    public String[] solution(String[][] tickets) {
        answer = new ArrayList<>();
        boolean[] visited = new boolean[tickets.length];

        // 출발 지점이 ICN이므로 "ICN"부터 시작
        dfs("ICN", tickets, visited, 0);

        // List를 배열로 변환
        String[] result = new String[answer.size()];
        answer.toArray(result);

        return result;
    }

    private void dfs(String current, String[][] tickets, boolean[] visited, int depth) {
        answer.add(current);

        // 모든 항공권을 사용한 경우 종료
        if (depth == tickets.length) {
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            // 사용하지 않은 항공권 중 현재 위치에서 출발하는 항공권을 찾음
            if (!visited[i] && tickets[i][0].equals(current)) {
                visited[i] = true;
                dfs(tickets[i][1], tickets, visited, depth + 1);
                visited[i] = false;  // backtracking
            }
        }
    }
}
