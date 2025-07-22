import java.io.*;
public class B9005{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        int n = Integer.parseInt(input);
        int[] results = new int[12];
        results[1] =1;
        results[2] =2;
        results[3] =4;
        for(int i=4;i<12;i++){
            results[i] = results[i-1] + results[i-2] + results[i-3];
        }                       
        for(int i=0;i<n;i++){
            int num = Integer.parseInt(br.readLine());
            bw.write(results[num] + "\n");
        }
        bw.flush();
        bw.close();
        br.close(); 
    }
}