// skeleton code -- do not modify!
//
// CAS 2103-01, Spring 2025
//
// PS2

import java.io.*;

class As22 {
    
    public static void  main(String[] args) {
        BufferedReader  rd = null;
        BufferedWriter  wr = null;
        int[]           x, y, ans;
        int             n, m, pos, u, v, i, ret;
        String          s;
        long            starttime, elapsedtime;
        
        try {
            // read in the input
            rd = new BufferedReader(new FileReader("input.txt"));
            s = rd.readLine();
            pos = s.indexOf(" ");
            n = Integer.parseInt(s.substring(0, pos));
            m = Integer.parseInt(s.substring(pos + 1));
            x = new int[m];
            y = new int[m];
            s = rd.readLine();
            pos = s.indexOf(" ");
            u = Integer.parseInt(s.substring(0, pos));
            v = Integer.parseInt(s.substring(pos + 1));
            for (i = 0; i < m; i++) {
                s = rd.readLine();
                pos = s.indexOf(" ");
                x[i] = Integer.parseInt(s.substring(0, pos));
                y[i] = Integer.parseInt(s.substring(pos + 1));
            }
            rd.close();
            rd = null;
            ans = new int[n];

            // call SP.findSP and measure the elapsed time
            starttime = System.nanoTime();
            ret = SP.findSP(n, m, x, y, u, v, ans);
            elapsedtime = System.nanoTime() - starttime;
            
            // output the elapsed time to stdout in seconds
            System.out.println(Double.toString((double)elapsedtime / 1000000000));

            // write the output
            wr = new BufferedWriter(new FileWriter("output.txt"));
            wr.write(Integer.toString(ret));
            wr.newLine();
            if (ret != -1) {
                for (i = 0; i < ret; i++) {
                    wr.write(Integer.toString(ans[i]));
                    wr.newLine();
                }
            }
            wr.close();
            wr = null;
        }
        catch (Exception e) {
            // if the code throws any exception, stack trace will be output and the program will halt
            e.printStackTrace();
            System.out.println("Error.");
        }
        finally {
            if (rd != null) {
                try {
                    rd.close();
                }
                catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error.");
                }
            }
            if (wr != null) {
                try {
                    wr.close();
                }
                catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error.");
                }
            }
        }
    }
    
}
