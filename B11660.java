//구간 합 구하기5

import java.io.*;
public class B11660 {
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try{
            String[] nums = br.readLine().split(" ");
            int N = Integer.parseInt(nums[0]);
            int M = Integer.parseInt(nums[1]);
            int[][] input = new int[N+1][N+1];
            // sum 을 구할때 x1 부터 x2까지의 element에 접근하여 더하면, 최대 O(N^2) 의 시간복잡도가 발생한다
            //O(N^2*M) 의 경우 시간초과가 발생할 염려가 있음
            //각각의 행을 저장할 떄, 합을 누적하여 저장하면, 후에 합을 구할때 constant time으로 합을 구할 수 있다.
            for(int i=1;i<N+1;i++){
                int con =0;
                String[] line = br.readLine().split(" ");
                input[i][0] = con;
                for(int j=1;j<N+1;j++){
                    con+=Integer.parseInt(line[j-1]);
                    input[i][j]=con;
                }
            } // O(N^2) < O(NM) 이니까 상관없다
            
            for(int i=0;i<M;i++){
                String[] position = br.readLine().split(" ");
                int x1 = Integer.parseInt(position[0]);
                int y1 = Integer.parseInt(position[1]);
                int x2 = Integer.parseInt(position[2]);
                int y2 = Integer.parseInt(position[3]);
                int sum=0;
                for(int j=x1;j<x2+1;j++){
                    sum += input[j][y2]-input[j][y1-1];
                }
                bw.write(String.valueOf(sum));
                bw.newLine();
            } // O(NM) ,, x,y 좌표 주의..
            
            
            bw.flush();
            bw.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}