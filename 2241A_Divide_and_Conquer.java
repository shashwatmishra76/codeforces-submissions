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
        int x = fs.nextInt();
        int y = fs.nextInt();
        
        if(y > x) {
            out.println("NO");
        } else if(y == x) {
            out.println("YES");
        } else {
            if(x % y == 0) {
                out.println("YES");
            } else {
                out.println("NO");
            }
        }
        
        return;
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