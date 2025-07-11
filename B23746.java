//문자열 압축 해제
import java.io.*;

public class B23746{
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] hint = new String[91];
        try{
            int N = Integer.parseInt(br.readLine());
            for(int i=0;i<N;i++){
                String[] input = br.readLine().split(" ");
                hint[(int) input[1].charAt(0)] = input[0];
            }
            String goal = br.readLine();
            StringBuilder ret = new StringBuilder();
            for(int i=0;i<goal.length();i++){
                ret.append(hint[((int) goal.charAt(i))]);
            }
            String[] range = br.readLine().split(" ");
            int start = Integer.parseInt(range[0])-1;
            int end = Integer.parseInt(range[1])-1;
            for(int i=start;i<end+1;i++){
                System.out.print(ret.charAt(i));
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
}