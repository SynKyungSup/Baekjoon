import java.io.*;
public class B2579{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] scores = new int[n+1];
        for(int i=1; i<n+1;i++){
            scores[i] = Integer.parseInt(br.readLine());
        }
        int[] dp = new int[n+1];
        dp[1] =scores[1];
        if(n==1) {System.out.println(dp[1]); return;} // n이 1,2일 때, Index Outof Bound Error 주의..
        dp[2] = scores[1] + scores[2];
        if(n==2) {System.out.println(dp[2]); return;} // n이 1,2일 때, Index Outof Bound Error 주의..
        dp[3] = Math.max(scores[2]+scores[3], scores[1]+scores[3]);
        for( int i=4;i<n+1;i++){
            dp[i] = Math.max(dp[i-2] + scores[i], dp[i-3] + scores[i-1] + scores[i]);
        }
        System.out.println(dp[n]);
    }
}