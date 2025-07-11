//행렬
import java.io.*;
public class B1080{
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            String[] nums = br.readLine().split(" ");
            int N = Integer.parseInt(nums[0]);
            int M = Integer.parseInt(nums[1]);
            int[][] matrix = new int[N][M];
            boolean[][] change = new boolean[N][M];
            boolean isPossible=true;
            for(int i=0;i<N;i++){
                String input = br.readLine();
                for(int j=0;j<M;j++){
                    matrix[i][j]=(int) input.charAt(j);
                } 
            }
            for(int i=0;i<N;i++){
                String input = br.readLine();
                for(int j=0;j<M;j++){
                    if(matrix[i][j]==(int) input.charAt(j)) change[i][j]=false;
                    else change[i][j]=true;
                } 
            }
            if(N<3||M<3){
                for(int i=0;i<N;i++){
                    for(int j=0;j<M;j++){
                        if(change[i][j]) {
                            isPossible =false;
                        }
                    }
                }
            }
            
            int count=0;
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(change[i][j]){
                        if(i<N-2&&j<M-2){
                            for(int x=i;x<i+3;x++){
                                for(int y=j;y<j+3;y++){
                                    change[x][y] = !change[x][y];
                                }
                            }
                            count++;
                        }
                        else{
                            if(change[i][j]){
                                isPossible =false;
                            }
                        }
                    }
                }
            }
            if(!isPossible) System.out.println("-1");
            else System.out.println(count);
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
}