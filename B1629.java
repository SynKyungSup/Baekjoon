// A의 B제곱의 modulo C 구하기.. 
//시간제한때문에 O(B) 대신 O(log B) 로 구현
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        long A = Long.parseLong(inputs[0]);
        long B = Long.parseLong(inputs[1]);
        long C = Long.parseLong(inputs[2]);
        long result = pow(A, B, C);
        System.out.println(result);
    }

    public static long pow(long A, long B, long C) {
        if (B == 0) return 1;
        if (B == 1) return A % C;

        long half = pow(A, B / 2, C);
        long temp = (half * half) % C;

        if (B % 2 == 0) {
            return temp;
        } else {
            return (temp * A) % C;
        }
    }
}
