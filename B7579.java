//7579번 앱
// N개, 메모리 크기 M
// N개의 앱이 주어진다. c의 합이 최소가 되면서 M을 초과하도록
import java.io.*;
public class B7579 {
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        String[] memories_input = br.readLine().split(" ");
        String[] cash_input = br.readLine().split(" ");
        int[] mem = new int[N+1];
        int[] cash = new int[N+1];
        for(int i=0;i<N;i++){
            mem[i+1]=Integer.parseInt(memories_input[i]);
            cash[i+1]=Integer.parseInt(cash_input[i]);
        }
        int sum=0;
        for(int i=1;i<N+1;i++){ // sum 계산할때 index 잘못설정한듯;
            sum+=cash[i];
        }
        int[][] dp = new int[N+1][sum+1]; // i번째 까지의 앱을 사용해서, 비용 c를 넘지않게 절약할 수 있는 메모리
        
        dp[1][0] = 0;//basis case
        for(int i=0;i<sum+1;i++){
            dp[0][i]=0;
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<sum+1;j++){
                if(cash[i+1]>j){
                    dp[i+1][j]=dp[i][j];
                } else{
                    dp[i+1][j]=(int)Math.max(dp[i][j], dp[i][j-cash[i+1]]+mem[i+1]);
                }
            }
        }
        for(int i=0;i<sum+1;i++){
            if(dp[N][i]>=M){
                
                System.out.println(i);
                break;
            }
        }
        //System.out.println(dp[N][99]); 테스트용
        
    }
}
