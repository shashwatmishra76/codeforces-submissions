import java.io.*;
import java.util.*;
 
public class Main {
 
    static FastScanner fs = new FastScanner(System.in);
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
 
    static final int MOD = 1_000_000_007;
    static final int INF = (int) 1e9;
 
    public static void main(String[] args) throws Exception {
        int t = fs.nextInt();
        //int t = 1;
        
        while (t-- > 0) {
            solve();
        }
        
        out.flush();
    }
 
    static void solve() {
        int n = fs.nextInt();
        int k = fs.nextInt();
        int[] problemDifficulty = new int[n];
        int allowedWindow = 1;
        int result = 1;
        
        for(int i = 0; i < n; i++) {
            problemDifficulty[i] = fs.nextInt();
        }
        
        Arrays.sort(problemDifficulty);
        
        for(int i = 1; i < n; i++) {
            if(Math.abs(problemDifficulty[i] - problemDifficulty[i - 1]) <= k) {
                allowedWindow += 1;
                result = Math.max(result, allowedWindow);
            } else {
                allowedWindow = 1;
            }
        }
        
        out.println(n - result);
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