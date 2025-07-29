import java.io.*;
import java.util.Arrays;

public class B1931{
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        //System.out.println(n);
        int[][] meeting = new int[n][2];
        for(int i =0 ;i<n;i++){
            String[] input = br.readLine().split(" ");
            meeting[i][0] = Integer.parseInt(input[0]);
            meeting[i][1] = Integer.parseInt(input[1]);
        }
        br.close();
        int count =0;
        int currentEnd=0;
        //다음 회의를 고르는 기준: 현재 회의의 종료시간에
        //가장 가까운 종료시간을 가지는 회의, 단 시작시간은 현재 종료시간보다 늦어야함.
        
        Arrays.sort(meeting, (a, b) -> {
            if (a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });
        for(int i=0;i<n;i++){
            if(meeting[i][0]>=currentEnd){
                currentEnd=meeting[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}
