import java.io.*;
import java.util.*;

public class Main {

    static FastScanner fs = new FastScanner(System.in);
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    static final int MOD = 1_000_000_007;
    static final int INF = (int) 1e9;

    public static void main(String[] args) throws Exception {
        //int t = fs.nextInt();
        int t = 1;
        
        while (t-- > 0) {
            solve();
        }
        
        out.flush();
    }
    
    static void reverse(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }
    

    static void solve() {
        int n = fs.nextInt();
        int m = fs.nextInt();
        int s = fs.nextInt();
        int a = fs.nextInt();
        int b = fs.nextInt();
        long result = 0l;
        int[] aCost = new int[n];
        int[] bCost = new int[m];
        
        for(int i = 0; i < n; i++) {
            aCost[i] = fs.nextInt();
        }
        
        for(int j = 0; j < m; j++) {
            bCost[j] = fs.nextInt();
        }
        
        Arrays.sort(aCost);
        Arrays.sort(bCost);
        
        reverse(aCost);
        reverse(bCost);
        
        int i = 0, j = 0;
        long currCost = 0l, currWeight = 0l;
        
        for(; i < n; i++) {
            if(currWeight + a <= s) {
                currCost += aCost[i];
                currWeight += a;
            } else {
                break;
            }
        }
        
        result = currCost;
        
        for(; j < m; j++) {
            currCost += bCost[j];
            currWeight += b;
            
            while(currWeight > s && i > 0) {
                i--;
                currCost -= aCost[i];
                currWeight -= a;
            }
            
            if(currWeight > s) {
                break;
            }
            
            result = Math.max(currCost, result);
        }
        
        out.println(result);
    }

    // --------- Fast Scanner ----------
    static class FastScanner {
        private final BufferedReader br;
        private StringTokenizer st;

        FastScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    String line = br.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            try {
                st = null;
                return br.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
