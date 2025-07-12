//정수 삼각형

import java.io.*;
public class B1932{
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            int N = Integer.parseInt(br.readLine());
            int[][] triangle = new int[N][N];
            for(int i=0;i<N;i++){
                String[] line = br.readLine().split(" ");
                for(int j=0;j<line.length;j++){
                    triangle[i][j] = Integer.parseInt(line[j]);
                }
            }
            for(int i=N-2;i>=0;i--){
                for(int j=0;j<N-1;j++){
                    if(triangle[i+1][j]<triangle[i+1][j+1]) triangle[i][j]+=triangle[i+1][j+1];
                    else triangle[i][j] +=triangle[i+1][j];
                }
            }
            System.out.println(triangle[0][0]);
        } catch(Exception e){
            System.out.println(e);
        }
    }
}