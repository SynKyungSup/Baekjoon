import java.util.Scanner;
//직선의 부등식의 영역을 활용함.
// overflow로 인한 오류를 방지하기위해 dx와 dy는 long 타입을 사용한다
public class B1027 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int[] heights = new int[n];
        for(int i=0;i<n;i++){
            heights[i] = sc.nextInt();
        }
        int Max_visiable=0;
        for(int i=0;i<n;i++){
            int visiable=0;
            for(int j=0;j<n;j++){
                long dy = heights[j] - heights[i];
                long dx = j - i;
                if(dx == 0) continue; // 자기 자신은 제외
                boolean isVisiable = true;
                if(i<j){
                    for(int k=i+1;k<j;k++){//k - i 와 j 사이의 빌딩들
                        long eq = dy*(k-i) + dx*(heights[i] - heights[k]);
                        if(eq<= 0) isVisiable = false; 
                    }
                    if(isVisiable) visiable++;
                } else{
                    for(int k=j+1;k<i;k++){//k - j 와 i 사이의 빌딩들
                        long eq = dy*(k-i) + dx*(heights[i] - heights[k]);
                        if(eq>= 0) isVisiable = false; 
                    }
                    if(isVisiable) visiable++;
                }
            }
            if(visiable > Max_visiable) Max_visiable = visiable;
        }
        System.out.println(Max_visiable);
        sc.close();
    }
}
