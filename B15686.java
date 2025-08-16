//치킨거리
//도시치킨거리 구하기 O(N^2M);
// 가능한 치킨집 조합수 : <=13C6 일거같은데
// 그냥 가능한 치킨집 조합수 마다 도시치킨거리 구하면 될거같음
// 가능한 치킨집 조합 수 구하는건 N과 M 문제 활용하는 느낌일거같다

import java.io.*;
//백트랙킹 부분을 순열로 고려했다가 시간초과;;
// 조합으로 수정함.
public class B15686 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //bw 는 필요없을듯; 출력이 숫자 하나밖에없어
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[][] map = new int[N][N]; 
        int[][] chicken = new int[13][2]; // 치킨집의 좌표 저장;
        
        int term; int num =0; // num 이 치킨집 개수를 추적;
        for(int i=0;i<N;i++){
            input=br.readLine().split(" ");
            for(int j=0;j<N;j++){
                term = Integer.parseInt(input[j]);
                map[i][j] = term;
                if(term == 2){
                    chicken[num][0] = i;
                    chicken[num][1] = j;
                    num++; 
                }
            }
        }
        //int[] choice 에는 전체 치킨집(=num) 중 M개를 선택하는 조합을 넣을거임;
        //0부터 num-1 사이에서, M개 선택 
        int[] choice = new int[M];
        int[] minimum = {Integer.MAX_VALUE};
        boolean[] visit = new boolean[num];
        backtrack(map,chicken,0,0,visit, choice, num,M, minimum);
        System.out.println(minimum[0]);
    }
    //도시 치킨 거리 계산
    public static int chickendist_city(int[][] map, int[][] chicken, int[] choice){
        int sum=0;
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map.length;j++){
                if(map[i][j] ==1){ //i,j 위치가 집이면
                    sum += chickendist(map,chicken,choice,i,j);
                }
            }
        }
        return sum;
    }
    public static int chickendist(int[][] map, int[][] chicken, int[] choice, int x, int y){//x,y 위치의 집의 치킨거리 구하기
        int min = Integer.MAX_VALUE;
        int dist1, dist2;
        for(int i=0;i<choice.length;i++){
            dist1 = Math.abs(chicken[choice[i]][0]-x);
            dist2 = Math.abs(chicken[choice[i]][1]-y);
            if(dist1+dist2<min){
                min=dist1+dist2;
            }
        }
        return min;
    }
    // 0~num-1 중 M개를 골라 choice 배열을 만드는 메서드
    public static void backtrack(int[][] map, int[][] chicken, int depth, int start, boolean[] visit, int[] choice, int num, int M,int[] minimum){
        if(depth==M){
            int min = chickendist_city(map,chicken,choice);
            minimum[0] = Math.min(minimum[0], min);

            return;
        }
        for(int i=start;i<num;i++){
            if(visit[i] == false){
                visit[i] = true;
                choice[depth] = i;
                backtrack(map, chicken, depth+1, i+1, visit, choice, num, M, minimum);
                visit[i] =false;
                
            }
        }
        return;
    }
}
