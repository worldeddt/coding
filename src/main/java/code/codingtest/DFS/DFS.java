package code.codingtest.DFS;

public class DFS {
    static int n;
    static int[] ch;
    public DFS() {
        ;
        n = 3;
        ch = new int[n+1];
        doDFS(1);
    }

    public void doDFS(int L) {
        System.out.println("I : "+L);
        if (L == n+1) {
            String temp = "";
            for (int i =1; i<=n; i++) {
                if (ch[i] == i) temp+=(i+" ");
            }
//            if (temp.length() > 0) System.out.println(temp);
        } else {
            ch[L] = 1;
            System.out.printf("ch[L] : %d  L : %d %n",ch[L],L);
            doDFS(L+1);
            ch[L] = 0;
            System.out.printf("ch[L] : %d  L : %d %n",ch[L],L);
            doDFS(L+1);
        }
    }
}
