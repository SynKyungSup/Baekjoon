//트리의 지름
// 일단 트리니까, 노드 2개를 선택했을때 경로는 하나밖에 없음
// 인접리스트를 너무 이상하게 만든거같은데;;
import java.util.ArrayList;
import java.io.*;
public class B1967 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input;
        ArrayList<ArrayList<Node>> tree = new ArrayList<>(); // 캐스팅 필요
        for (int i = 0; i <= N; i++) tree.add(new ArrayList<>());

        for(int i=1;i<N;i++){
            input=br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int w = Integer.parseInt(input[2]);
            tree.get(a).add(new Node(b,w));
            tree.get(b).add(new Node(a,w));
        }
        //bfs
        boolean[] visited=new boolean[N+1];
        int[] prop = {0,0,0}; // sum 과 max와 그때의 노드;
        dfs(tree,1,visited,prop);
        int[] prop2 = {0,0,0};
        boolean[] visited2 = new boolean[N+1];
        dfs(tree,prop[2],visited2,prop2);
        System.out.println(prop2[1]);
    }
    public static void dfs(ArrayList<ArrayList<Node>> tree, int start, boolean[] visited, int[] prop){
        visited[start] =true;
        for(int i=0;i<tree.get(start).size();i++){
            Node now = tree.get(start).get(i);
            if(!visited[now.to]){
                visited[now.to]=true;
                prop[0] +=now.weight;
                if(prop[0]>prop[1]){
                    prop[1]=prop[0];
                    prop[2]= now.to;
                }
                dfs(tree,now.to,visited,prop);
                prop[0] -=now.weight;
            }
        }

    }
}
class Node{
    int to;
    int weight;
    public Node(int to,int weight){
        this.to = to;
        this.weight = weight;
    }   
}
