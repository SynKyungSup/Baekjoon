// 로봇청소기
//0123 북동남서
//0- 청소되지 않음, 1- 벽,  -1 - 청소됨
//case 1. 현재 칸이 청소되지 않은경우, 현재칸을 청소
//case 2. 4칸이 다 청소된 상태 혹은 벽인경우
//case 3. 4칸 중에 청소되지 않은 빈칸이 있는경우
import java.io.*;
public class B14503 {
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    
        String[] sizes = br.readLine().split(" ");
        int n = Integer.parseInt(sizes[0]);
        int m = Integer.parseInt(sizes[1]);
        int[][] map = new int[n][m];
        String[] locate = br.readLine().split(" ");
        int x = Integer.parseInt(locate[0]);
        int y = Integer.parseInt(locate[1]);
        int dir = Integer.parseInt(locate[2]);
        for(int i=0;i<n;i++){
            String[] line = br.readLine().split(" ");
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(line[j]);
            }
        }
        int[] prop = {x, y, dir, 0};// x, y 좌표, 방향, 청소한 블럭 수
        doClean(map, n, m, prop);
        System.out.println(prop[3]);
    }
    public static void doClean(int[][] map, int n, int m,int[] prop){
        if(map[prop[0]][prop[1]]==0){ // case 1
            map[prop[0]][prop[1]] = -1; // 청소한 칸은 -1로 표시;
            prop[3]++;
            doClean(map, n, m, prop);
        } else if(!isCleanable(map, n, m, prop)){ //case 2 (주변에 청소 가능한 칸이 없음)
            if(moveBack(map, n, m, prop)) {
                doClean(map, n, m, prop);
            }else { // 후진이 불가능한 경우
                return;
            }
        } else{
            // 반시계 90도 회전
            prop[2] = (prop[2] + 3) % 4;
            // 한 칸 전진
            moveForward(map, n, m, prop);
            doClean(map, n, m, prop);
        }
    }
    public static boolean isCleanable(int[][] map, int n, int m, int[] prop){
        // 주변 4칸 중 청소되지 않은 빈 칸이 있는 지 확인
        int x= prop[0];
        int y = prop[1];
        int[] dx = {-1, 0, 1, 0}; // 북, 동, 남, 서
        int[] dy = {0, 1, 0, -1};
        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && nx<n && ny >=0 && ny<m && map[nx][ny] == 0){
                return true;
            }
        }
        return false;
    }
    public static boolean moveBack(int[][] map, int n, int m,int[] prop){
        int x= prop[0];
        int y= prop[1];
        int dir = prop[2];
        int[] dx = {-1, 0, 1, 0}; // 북, 동, 남, 서
        int[] dy = {0, 1, 0, -1};
        int nx = x + dx[(dir + 2) % 4];
        int ny = y + dy[(dir + 2) % 4];
        if(nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] != 1){
            // 후진이 가능하다면
            prop[0] = nx;
            prop[1] = ny;
            return true;
        }else return false; // 후진이 불가능하다면
    }
    public static boolean moveForward(int[][] map,int n,int m,int[] prop){
        int x = prop[0];
        int y = prop[1];
        int dir = prop[2];
        int[] dx = {-1, 0, 1, 0}; // 북, 동, 남, 서
        int[] dy = {0, 1, 0, -1};
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        if(nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 0){
            prop[0] = nx;
            prop[1] = ny;
            return true;
        } else return false;
    }
}
