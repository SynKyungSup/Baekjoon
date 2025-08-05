import java.io.*;
public class B1012{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testcase = Integer.parseInt(br.readLine());
        for(int t=0;t<testcase;t++){
            String[] inputs = br.readLine().split(" ");
            int n = Integer.parseInt(inputs[0]);
            int m = Integer.parseInt(inputs[1]);
            int[][] arr = new int[n][m];
            boolean[][] visited = new boolean[n][m];
            int num = Integer.parseInt(inputs[2]);
            for(int i=0;i<num;i++){
                String[] coordinates = br.readLine().split(" ");
                int x = Integer.parseInt(coordinates[0]);
                int y = Integer.parseInt(coordinates[1]);
                arr[x][y] = 1; // 배추 위치 마킹
            }
            int count =0;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(arr[i][j] ==1 && !visited[i][j]){
                        count++;
                        visited[i][j] = true;
                        dfs(arr,visited, i,j);// 연결된 배추들을 true로 마킹

                    }else if(arr[i][j]==0 && !visited[i][j]){
                        visited[i][j] = true;
                    }
                }
            }
            bw.write(String.valueOf(count));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
    public static void dfs(int[][] arr, boolean[][] visited, int x, int y){
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0,0,-1,1};
        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && nx<arr.length && ny>=0 && ny<arr[0].length && arr[nx][ny] == 1 && !visited[nx][ny]){
                //유효한 index이며, 방문처리가 안된경우
                visited[nx][ny] = true; // 방문 처리
                dfs(arr, visited, nx, ny); // 재귀 호출
            }
        }
    }
}