// 트리의 부모 찾기
import java.io.*;
import java.util.Queue;
import java.util.LinkedList;
public class B11725 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        //boolean[][] graph = new boolean[n+1][n+1]; << 이게 메모리 초과같은데, 인접리스트로 해야할듯 N^2>> N+M
        Node[] edges = new Node[n+1];
        edges[1] = new Node(1); // 루트 노드
        for(int i=1;i<n+1;i++){
            edges[i] = new Node(i);
        }
        for(int i=0;i<n-1;i++){ //vertex n 개의 트리의 edge는 항상 n-1개
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            if(edges[a] == null) edges[a] = new Node(b);
            else{
                Node current = edges[a];
                while(current.next!=null){
                    current= current.next;
                } // edges[a] 의 마지막 노드로 이동
                current.next = new Node(b);
            }
            if(edges[b] == null) edges[b] = new Node(a);
            else{
                Node current = edges[b];
                while(current.next!=null){
                    current= current.next;
                } // edges[b] 의 마지막 노드로 이동
                current.next = new Node(a);
            }
        }
        int[] parent = new int[n+1];
        //BFS 로 검사할 예정
        Queue<Node> queue = new LinkedList<>();
        queue.add(edges[1]);
        boolean[] visited = new boolean[n+1]; // 트리니까 필요 없을거같긴한데?
        //visited array가 indexOutofBounds 방지함. 리프 노드가 검사되는걸 방지할 수 있음.
        //int front=0; int rear=0;
        //시작점은 1
        visited[1] = true; 
        int par;
        while(!queue.isEmpty()){
            Node current = queue.poll();
            par = current.key;
            current = current.next;
            while(current != null){
                int child = current.key;
                if(!visited[child]){
                    visited[child]=true;
                    parent[child] = par;
                    queue.add(edges[child]);
                }
                current = current.next;
            }
        }
        for(int i=2;i<n+1;i++){
            bw.write(String.valueOf(parent[i]));
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
class Node{
    int key;
    Node next;
    public Node(int key){
        this.key =key;
        this.next =null;
    }
}
