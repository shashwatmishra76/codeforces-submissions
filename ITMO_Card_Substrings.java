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
    
    static void calculateFrequencies(String s, int[] frequencies) {
        // Calculate frequencies of all characters
        for(int i = 0; i < s.length(); i++) {
            frequencies[s.charAt(i) - 'a']++;
        }
    }
    
    static boolean isGood(int[] freq1, int[] freq2) {
        for(int i = 0; i < 26; i++) {
            if(freq1[i] > freq2[i]) {
                return false;
            }
        }
        
        return true;
    }

    static void solve() {
        int n = fs.nextInt();
        int m = fs.nextInt();
        
        String s = fs.next();
        String cards = fs.next();
        
        int[] freqCurr = new int[26];
        int[] freqAllowed = new int[26];
        long result = 0L;
        
        calculateFrequencies(cards, freqAllowed);
        
        int left = 0, right = 0;
        
        while(right < n) {
            freqCurr[s.charAt(right) - 'a']++;
            
            while(left <= right && !isGood(freqCurr, freqAllowed)) {
                freqCurr[s.charAt(left) - 'a']--;
                left++;
            }
            
            result += (right - left + 1);
            
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
