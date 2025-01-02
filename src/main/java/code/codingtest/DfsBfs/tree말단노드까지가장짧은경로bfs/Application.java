package code.codingtest.DfsBfs.tree말단노드까지가장짧은경로bfs;


import java.util.LinkedList;
import java.util.Queue;

public class Application {

    static Node root;

    public static void main(String[] args) {
        root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);
        root.rt.rt.rt = new Node(8);
        root.rt.rt.lt = new Node(9);

        System.out.println(bfs(root));
    }

    public static int bfs(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        int L = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                if (cur.lt == null && cur.rt == null) return L;
                if (cur.lt != null) queue.offer(cur.lt);
                if (cur.rt != null) queue.offer(cur.rt);
            }
            L++;
        }

        return L;
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
