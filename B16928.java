//BFS 
import java.io.*;
public class B16928 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int lad = Integer.parseInt(input[0]);
        int snk = Integer.parseInt(input[1]);
        int[] board = new int[101];
        for(int i=1;i<101;i++){
            board[i]=i;
        }
        for(int i=0;i<lad;i++){
            input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            board[start] = end;
        }
        for(int i=0;i<snk;i++){
            input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            board[start] = end;
        }
        int[] queue = new int[101];
        boolean[] visited = new boolean[101];
        int[] dist = new int[101];
        dist[1] =0;
        int front =0; int rear=0;
        queue[rear++] =1; // Start from square 1
        visited[1]=true;
        int count=0;
        while(front<rear){
            int current = queue[front++];
            if(current ==100){
                System.out.println(count);
                return;
            }else{
                
                for(int i=1;i<7;i++){
                    int next = current +i;
                    if(next<=100 && !visited[board[next]]){
                        visited[board[next]] = true;
                        queue[rear++] = board[next];
                        dist[board[next]] = dist[current]+1;
                        count = dist[board[next]];
                        if(board[next] == 100) {
                            System.out.println(count);
                            return;
                        }
                        if(next == 100) {
                            System.out.println(count);
                            return;
                        }
                    }
                }
            }
        }
    }    
}
