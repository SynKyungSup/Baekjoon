package class4;
import java.util.Scanner;
public class B9251 {
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        int len1 = str1.length();
        int len2 = str2.length();
        int[][] dp = new int[len1][len2];
        for(int i=0;i<len1;i++){
            for(int j=0;j<len2;j++){
                if(str1.charAt(i) == str2.charAt(j)){
                    if(i==0||j==0){
                        dp[i][j]=1;
                    } else{
                        dp[i][j] = dp[i-1][j-1]+1;
                    }
                } else{
                    if(i==0&&j==0) dp[0][0] =0;
                    else if(i==0){
                        dp[i][j] = dp[i][j-1];
                    }else if(j==0){
                        dp[i][j] = dp[i-1][j];
                    } else{
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    }
                }
            }
        }
        System.out.println(dp[len1-1][len2-1]);
        sc.close();
    }
}
