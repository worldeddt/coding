package code.codingtest.DfsBfs.이진트리레벨탐색;

import java.util.LinkedList;
import java.util.Queue;

public class Application {
    Node root;

     public static void main(String[] args) {
        Application app = new Application();
        app.root = new Node(1);
        app.root.lt = new Node(2);
         app.root.rt = new Node(3);
         app.root.rt.lt = new Node(4);
         app.root.rt.rt = new Node(5);
         app.root.lt.lt = new Node(6);
         app.root.lt.rt = new Node(7);
         app.bfs(app.root);
     }

     public static void bfs(Node root) {
         Queue<Node> queue = new LinkedList<>();
         queue.offer(root);
         int L = 0;

         while (!queue.isEmpty()) {
             int size = queue.size();
             System.out.printf(L+" : ");
             for (int i = 0; i < size; i++) {
                 Node cur = queue.poll();
                 System.out.printf(cur.value+" ");
                 if (cur.lt != null) {
                     queue.offer(cur.lt);
                 }

                 if (cur.rt != null) {
                     queue.offer(cur.rt);
                 }
             }
             L++;
             System.out.println();
         }
     }
}

class Node {
    public int value;
    public Node lt;
    public Node rt;

    public Node(int value) {
        this.value = value;
        this.lt = rt = null;
    }
}
