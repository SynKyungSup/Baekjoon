import java.util.Scanner;
import java.util.LinkedList;
public class B5525{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int len = scanner.nextInt();
        String s = scanner.next();
        scanner.close();
        int[] counts = new int[len];
        StringBuilder pattern =new StringBuilder( "I");
        for(int i=0;i<n;i++){
            pattern.append("OI");
        }
        int j=0;
        for(int i=0;i<len;i++){
            if(s.charAt(i) == 'I'){
                while(i+2<len&&s.charAt(i+1)=='O' && s.charAt(i+2) == 'I'){
                    i++;
                    i++;
                    counts[j]++;
                }
                j++;
            }
        }
        int result =0;
        for(int i=0;i<j;i++){
            if(counts[i]>=n){
                result += counts[i] -n +1;
            }
        }
        //System.out.println(j + " " + counts[0] + " " + counts[1]); test;
        System.out.println(result);
    }
}