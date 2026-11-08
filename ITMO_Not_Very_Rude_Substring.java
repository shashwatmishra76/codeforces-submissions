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

    static void solve() {
        int n = fs.nextInt();
        long c = fs.nextLong();
        
        String s = fs.next();
        
        int result = 0;
        
        int left = 0, right = 0;
        long freqA = 0L;
        long freqB = 0L;
        long rudeness = 0L;
        
        while(right < n) {
            if(s.charAt(right) == 'a') {
                freqA++;
            } else if(s.charAt(right) == 'b') {
                freqB++;
                rudeness += freqA;
            }
            
            while(left <= right && rudeness > c) {
                if(s.charAt(left) == 'a') {
                    freqA--;
                    rudeness -= freqB;
                } else if(s.charAt(left) == 'b') {
                    freqB--;
                }
                
                left++;
            }
            
            result = Math.max(result, right - left + 1);
            
            right++;
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
