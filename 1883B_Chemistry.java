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
    
    private static int getOddOccurringElements(String s) {
        int[] freqMap = new int[256];
        int oddOccuring = 0;
        
        for(int i = 0; i < s.length(); i++) {
            freqMap[s.charAt(i)]++;
        }
        
        for(int i = 0; i < freqMap.length; i++) {
            if(freqMap[i] % 2 == 1) {
                oddOccuring += 1;
            }
        }
        
        return oddOccuring;
    }
 
    static void solve() {
        int n, k;
        n = fs.nextInt();
        k = fs.nextInt();
        String s = fs.next();
        
        int x = getOddOccurringElements(s);
        
        if(x <= k + 1) {
            out.println("YES");
        } else {
            out.println("NO");
        }
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