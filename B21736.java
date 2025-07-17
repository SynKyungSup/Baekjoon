import java.io.*;
public class B21736{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);
        int[][] map = new int [N][M];
        int nowX =0, nowY=0;
        int[] count = new int[1]; 
        count[0] = 0;
        for(int i=0;i<N;i++){
            String input = br.readLine();
            for(int j=0;j<M;j++){
                char c = input.charAt(j);
                if(c=='P'){
                    map[i][j] = -1;
                }
                if(c=='I'){
                    map[i][j] =1;
                    nowX=i;
                    nowY=j;
                }
                if(c=='X'){
                    map[i][j] =1;
                
                }
                if(c=='O'){
                    map[i][j] =0;
                }
            }
        }
        up(map,nowX,nowY,count);
        left(map,nowX,nowY,count);
        right(map,nowX,nowY,count);
        down(map,nowX,nowY,count);
        if(count[0] ==0){
            System.out.println("TT");
        } else {
            System.out.println(count[0]);
        }
    }
    static void up(int[][] map, int nowX,int nowY, int[] count){
        if(nowX-1>=0){
            if(map[nowX-1][nowY] == -1){
                count[0]++;
                map[nowX-1][nowY] = 1; // P를 만남
            } else if(map[nowX-1][nowY] == 0) {
                map[nowX-1][nowY] = 1;  // 빈공간을 만남
            } else if (map[nowX-1][nowY] == 1) {
                return; // 벽을 만남
            }
            up(map,nowX-1,nowY,count);
            left(map,nowX-1,nowY,count);
            right(map,nowX-1,nowY,count);
            down(map,nowX-1,nowY,count);
        }
    }
    static void down(int[][] map, int nowX,int nowY, int[] count){
        if(nowX+1<map.length){
            if(map[nowX+1][nowY] == -1){
                count[0]++;
                map[nowX+1][nowY] = 1; // P를 만남
            } else if(map[nowX+1][nowY] == 0) {
                map[nowX+1][nowY] = 1;  // 빈공간을 만남
            } else if (map[nowX+1][nowY] == 1) {
                return; // 벽을 만남
            }
            up(map,nowX+1,nowY,count);
            left(map,nowX+1,nowY,count);
            right(map,nowX+1,nowY,count);
            down(map,nowX+1,nowY,count);
        }
    }
    static void left(int[][] map, int nowX,int nowY, int[] count){
        if(nowY-1>=0){
            if(map[nowX][nowY-1] == -1){
                count[0]++;
                map[nowX][nowY-1] = 1; // P를 만남
            } else if(map[nowX][nowY-1] == 0) {
                map[nowX][nowY-1] = 1;  // 빈공간을 만남
            } else if (map[nowX][nowY-1] == 1) {
                return; // 벽을 만남
            }
            up(map,nowX,nowY-1,count);
            left(map,nowX,nowY-1,count);
            right(map,nowX,nowY-1,count);
            down(map,nowX,nowY-1,count);
        }
    }
    static void right(int[][] map, int nowX,int nowY, int[] count){
        if(nowY+1<map[0].length){       
            if(map[nowX][nowY+1] == -1){
                count[0]++;
                map[nowX][nowY+1] = 1; // P를 만남
            } else if(map[nowX][nowY+1] == 0) {
                map[nowX][nowY+1] = 1;  // 빈공간을 만남
            } else if (map[nowX][nowY+1] == 1) {
                return; // 벽을 만남
            }
            up(map,nowX,nowY+1,count);
            left(map,nowX,nowY+1,count);
            right(map,nowX,nowY+1,count);
            down(map,nowX,nowY+1,count);
        }
    }
}