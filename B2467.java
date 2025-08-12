package class5;
import java.io.*;
// 투 포인터 방식 >> 0으로부터의 차가 계속 감소하게 움직여야 한다
public class B2467 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] prop = new int[n];
        String[] input = br.readLine().split(" ");
        for(int i=0;i<n;i++){
            prop[i] = Integer.parseInt(input[i]);
        }    
        int first =0; int last = n-1;
        int sum =0;
        int diff = 0;
        int min = Integer.MAX_VALUE;
        int index1=-1, index2=-1;
        while(first!=last){
            sum = prop[first]+prop[last];
            diff = Math.abs(sum);
            if(diff<min){
                min = diff;
                index1 =first;
                index2 =last;
            }   
            if(sum<0) first++;
            else last--;
        }
        System.out.println(prop[index1]+" "+prop[index2]);
    }
}
