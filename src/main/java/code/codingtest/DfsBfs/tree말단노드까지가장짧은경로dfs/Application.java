package code.codingtest.DfsBfs.tree말단노드까지가장짧은경로dfs;

public class Application {

    static Node root;

    public static void main(String[] args) {
        root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);

        System.out.println(dfs(0, root));
    }

    public static int dfs(int L, Node node) {

        if (node.lt == null && node.rt == null) return L; // 주기능 > dfs 혼자만 봤을 때 기능
        else {
            return Math.min(dfs(L + 1, node.lt), dfs(L + 1, node.rt)); // 전체 기능
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
