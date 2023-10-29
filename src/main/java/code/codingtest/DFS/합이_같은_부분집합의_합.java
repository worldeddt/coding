//package code.codingtest.DFS;
//
//import code.codingtest.CodingTestApplication;
//import org.springframework.boot.SpringApplication;
//
//import java.util.Scanner;
//
//public class 합이_같은_부분집합의_합 {
//    static String answer = "NO";
//    static int[] ch;
//    static int total, n = 0;
//    boolean flag = false;
//
//    public static void main(String[] args) {
//        SpringApplication.run(합이_같은_부분집합의_합.class, args);
//
//        합이_같은_부분집합의_합 codingTestApplication = new 합이_같은_부분집합의_합();
//
//        Scanner kb = new Scanner(System.in);
//        n = kb.nextInt();
//        int[] arr = new int[n];
//        for (int i = 0; i< n; i++) {
//            arr[i] = kb.nextInt();
//            total += arr[i];
//        }
//        codingTestApplication.DFS(0,0, arr);
//        System.out.println(answer);
//    }
//
//    public void DFS(int L, int sum, int[] arr){
//        if(flag) return;
//        if(sum>total/2)return;
//        if(L == n) { // 세부로직(조건에 부합하는지 안하는지 확인
//            if((total - sum) == sum) {
//                answer = "YES";
//                flag = true;
//            }
//        }else {
//            DFS(L+1, sum+arr[L], arr);//왼쪽 갈래
//            DFS(L+1, sum,arr);//오른쪽 갈래
//        }
//    }
//}
