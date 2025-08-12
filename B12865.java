package class4;
import java.io.*;
import java.util.Arrays;
public class B12865 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int[] weight = new int[n+1];
        int[] value = new int[n+1];
    
        
        for(int i=0;i<n;i++){
            input = br.readLine().split(" ");
            weight[i+1] = Integer.parseInt(input[0]);
            value[i+1] = Integer.parseInt(input[1]);
        }
    
        int[][] dp = new int[n+1][k+1]; // dp[i][j] : i번째 물건까지 고려했을 때, j 무게를 넘지 않는 최대 가치
        for(int i=1;i<=n;i++){
            for(int j=1;j<=k;j++){
                // dp[i-1][j] 를 기반으로 dp[i][j]를 계산
                if(weight[i]>j){
                    dp[i][j] = dp[i-1][j]; //i번째 물건이 j보다도 크기때문에 넣는 것이 불가능
                } else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]] + value[i]); // i번째 물건을 넣지 않을지, 넣을지 결정
                } // j- weight[i] 는 index error가 나지 않는다 ( if 문에서 걸러짐)
            }
        }
        System.out.println(dp[n][k]);
        br.close();
        bw.close();
    }
}
