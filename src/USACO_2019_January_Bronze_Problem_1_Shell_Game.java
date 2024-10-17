import java.util.*;
import java.io.*;

public class USACO_2019_January_Bronze_Problem_1_Shell_Game {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("shell.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("shell.out")));
        
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] b = new int[n];
        int[] g = new int[n];
        
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
            g[i] = Integer.parseInt(st.nextToken());
        }
        
        int max = 0;
        
        for(int i = 1; i <= 3; i++) {
            int tempMax = 0;
            // guess is i
            int[] test = {1, 2, 3};
            for(int j = 0; j < n; j++) {
                // swap a[j] and b[j] in test
                int temp = test[a[j] - 1];
                test[a[j] - 1] = test[b[j] - 1];
                test[b[j] - 1] = temp;
                if (test[g[j] - 1] == i) {
                    tempMax++;
                }
            }

            max = Math.max(max, tempMax);
        }

        pw.println(max);
        br.close();
        pw.close();
    }

}
