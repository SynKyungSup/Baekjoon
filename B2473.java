//세 용액
// N<=5000  O(N^2) 은 가능
// sum 구하는 과정에서 overflow 발생할 수 있으니까 long 타입으로 선언해야 함..

import java.io.*;
import java.util.Arrays;
public class B2473 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        long[] prop = new long[N];
        for(int i=0;i<N;i++){
            prop[i] = Long.parseLong(input[i]);
        }
        Arrays.sort(prop);
        long MIN = Long.MAX_VALUE; 
        long[][] min = new long[N][3]; // min[i] : i를 고정하고, 투포인터로 계산할 경우 최소 값; 그때의 나머지 2개의 용액
        for(int i=0;i<N;i++){
            min[i][0] = Long.MAX_VALUE;
        }
        for(int i=0;i<N;i++){
            // i th 용액을 고정
            long sum =0; long dist=0;
            int start=0; int end = N-1;
            while(start<end){
                if(start==i){start++; continue;}
                if(end ==i) { end--; continue;}
                
                sum = prop[i]+prop[start]+prop[end];
                dist = Math.abs(sum);
                if(dist<min[i][0]){
                    min[i][0] = dist;
                    min[i][1] = start;
                    min[i][2] = end;
                }
                if(sum<0) start++;
                else end--;
                
            }
        }
        int index=-1;
        for(int i=0;i<N;i++){
            if(min[i][0]<MIN){
                MIN=min[i][0];
                index = i;
            }
        }
        long[] ret = {prop[index], prop[(int)min[index][1]], prop[(int)min[index][2]]};
        Arrays.sort(ret);
        System.out.println(ret[0]+" "+ret[1]+" "+ret[2]);
    }
}
