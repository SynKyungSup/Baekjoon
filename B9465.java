import java.io.*;
public class B9465 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            int n = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][n];
            
            String[] input1 = br.readLine().split(" ");
            String[] input2 = br.readLine().split(" ");
            for(int j=0;j<n;j++){
                sticker[0][j] = Integer.parseInt(input1[j]); // 첫 번째 줄
                sticker[1][j] = Integer.parseInt(input2[j]); // 두 번째 줄
            }
            
            // 0 열 부터 차례대로 최대값을 구함.
            int[][] dp = new int[2][n];
            if(n>1){
            dp[0][0] = sticker[0][0];
            dp[1][0] = sticker[1][0];
            dp[0][1] = sticker[0][1] + dp[1][0];
            dp[1][1] = sticker[1][1] + dp[0][0];
            } else {
                dp[0][0] = sticker[0][0];
                dp[1][0] = sticker[1][0];
            }
            for(int i=0;i<n-2;i++){
                dp[0][i+2] = Math.max(dp[1][i+1], dp[1][i]) + sticker[0][i+2];
                dp[1][i+2] = Math.max(dp[0][i+1], dp[0][i]) + sticker[1][i+2];
            }
            // 마지막 열의 값이 최댓값 후보
            int result = Math.max(dp[0][n-1], dp[1][n-1]);
            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
