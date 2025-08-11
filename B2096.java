import java.io.*;
public class B2096 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][3];
        int[][] dp_max = new int[n][3];
        int[][] dp_min = new int[n][3];
        for(int i=0;i<n;i++){
            String[] input = br.readLine().split(" ");
            for(int j=0;j<3;j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        dp_max[0][0] = map[0][0]; dp_min[0][0] = map[0][0];
        dp_max[0][1] = map[0][1]; dp_min[0][1] = map[0][1];
        dp_max[0][2] = map[0][2]; dp_min[0][2] = map[0][2];
        for(int i=0;i<n-1;i++){
            dp_max[i+1][0] = Math.max(dp_max[i][0],dp_max[i][1])+map[i+1][0];
            dp_max[i+1][1] = Math.max(dp_max[i][0], Math.max(dp_max[i][1], dp_max[i][2])) + map[i+1][1];
            dp_max[i+1][2] = Math.max(dp_max[i][1], dp_max[i][2]) + map[i+1][2];
        }
        int max= Math.max(dp_max[n-1][0], Math.max(dp_max[n-1][1], dp_max[n-1][2]));
        for(int i=0;i<n-1;i++){
            dp_min[i+1][0] = Math.min(dp_min[i][0],dp_min[i][1])+map[i+1][0];
            dp_min[i+1][1] = Math.min(dp_min[i][0], Math.max(dp_min[i][1], dp_min[i][2])) + map[i+1][1];
            dp_min[i+1][2] = Math.min(dp_min[i][1], dp_min[i][2]) + map[i+1][2];
        }
        int min = Math.min(dp_min[n-1][0], Math.min(dp_min[n-1][1], dp_min[n-1][2]));
        System.out.println(max + " " + min);
        br.close();
    }
}
