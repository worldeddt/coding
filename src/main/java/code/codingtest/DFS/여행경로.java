package code.codingtest.DFS;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootApplication
public class 여행경로 {

    /**
     [["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]]
     @result ["ICN", "JFK", "HND", "IAD"]
     [["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]]
     @result ["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"]
     */
    public static void main(String[] args) {
//        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
        boolean[] used = new boolean[tickets.length];
        List<String> result = new ArrayList<>();

        solve(tickets, used, result);
        String[] array = result.toArray(new String[result.size()]);

        for (String arr : array) {
            log.info("result : {}", arr);
        }


//        return result.toArray();
    }

    static void solve(String[][] tickets, boolean[] used,
                       List<String> result) {

        for (int i = 0; i< tickets.length; i++) {
            if (used[i]) continue;

            for (int j = 0; j<tickets[i].length; j++) {
                if (result.size() == 0) {
                    result.add(tickets[i][0]);
                    result.add(tickets[i][1]);
                    used[i] = true;
                    log.info("'tickets[i][j] : {} ", tickets[i][j]);
                    solve(tickets, used, result);
                } else if (result.get(result.size() - 1).equals(tickets[i][0])) {
                    result.add(tickets[i][1]);
                    used[i] = true;
                    log.info("'tickets[i][j] : {} ", tickets[i][j]);
                    solve(tickets, used, result);
                }
            }
        }
    }
}
