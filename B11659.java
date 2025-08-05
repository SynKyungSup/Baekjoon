import java.io.*;
public class B11659 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[] arr = new int[n+1];
        arr[0] =0 ;
        String[] line = br.readLine().split(" ");
        for(int i=1;i<n+1;i++){
            arr[i]= Integer.parseInt(line[i-1]);
            arr[i] += arr[i-1];
        }
        for(int i=0;i<m;i++){
            input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int ans = arr[end] - arr[start-1];
            bw.write(String.valueOf(ans));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
