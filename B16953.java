import java.util.Scanner;
public class B16953{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int count =0; boolean done =true;
        while(A!=B){
            String Bs = String.valueOf(B);
            if(B==1) {
                done =false;
                break;
            }
            else if(Bs.endsWith("1")){
                Bs = Bs.substring(0,Bs.length()-1);
                B = Integer.parseInt(Bs);
                count++;
            }
            else if(B%2==0){
                B /=2;
                count++;
            }
            else{
                done =false;
                break;
            }

        }
        if(done) System.out.println(++count);
        else System.out.println("-1");
    }
}