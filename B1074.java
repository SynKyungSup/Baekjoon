// Z 
// 2^N-1 
//input은 N, r, c 
import java.util.Scanner;
public class B1074{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        int results =0;
        for(int i=n; i>=1;i--){
        int size = (int) Math.pow(2,i);
        int div = 0 ; //분위수 
        int doub = (int) Math.pow(4, i-1); //계수
        
        if(r < size/2){
            if(c<size/2){
                div =0; //1사분면
            } else {div = 1;  c-= size/2;// 2사분면
            }
        } else{
            r -= size/2;
            if(c<size/2){
                div = 2;// 3사분면;
            } else{div =3; c-= size/2; //4사분면;
                }
        }
        results += div * doub;
        }
        int add =0;
        if(r==0) add=c;
        else add=r+c+1;
        System.out.println(results+add);
    }
}