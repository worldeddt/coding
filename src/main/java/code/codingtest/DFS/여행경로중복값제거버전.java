package code.codingtest.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 여행경로중복값제거버전 {

    private List<String> answer;

    public String[] solution(String[][] tickets) {

        Arrays.sort(tickets, Comparator.comparing(arr -> arr[1]));

        for (String[] row : tickets) {
            System.out.println(Arrays.toString(row));
        }

        answer = new ArrayList<>();
        boolean[] visited = new boolean[tickets.length];

        // 출발 지점이 ICN이므로 "ICN"부터 시작
        dfs("ICN", tickets, visited, 0);

        String[] result = new String[answer.size()];
        answer.toArray(result);

        return result;

    }

    private boolean dfs(String current, String[][] tickets, boolean[] visited, int depth) {

        answer.add(current);

        // 모든 항공권을 사용한 경우 종료
        if (depth == tickets.length) {
            return true;
        }

        for (int i = 0; i < tickets.length; i++) {
            // 사용하지 않은 항공권 중 현재 위치에서 출발하는 항공권을 찾음
            if (!visited[i] && tickets[i][0].equals(current)) {
                visited[i] = true;
                // 다음 단계에서 모든 항공권을 사용할 수 있는 경우 종료
                if (dfs(tickets[i][1], tickets, visited, depth + 1)) {
                    return true;
                }
                visited[i] = false;  // backtracking
            }
        }

        // 현재 위치에서 출발하는 항공권 중 모든 항공권을 사용할 수 없는 경우
        answer.remove(answer.size() - 1);
        return false;
    }

}
