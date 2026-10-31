import java.io.*;
import java.util.*;
 
public class Main {
 
    static FastScanner fs = new FastScanner(System.in);
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
 
    static final int MOD = 1_000_000_007;
    static final int INF = (int) 1e9;
    
    static int gcd(int a, int b)
    {
        // if b=0, a is the GCD
        if (b == 0)
            return a;
 
        // call the gcd() method recursively by
        // replacing a with b and b with
        // modulus(a,b) as long as b != 0
        else
            return gcd(b, a % b);
    }
    
 
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
        int[] nums = new int[n];
        boolean isPossible = false;
        
        for(int i = 0; i < n; i++) {
            nums[i] = fs.nextInt();
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(gcd(nums[i], nums[j]) <= 2) {
                    isPossible = true;
                    break;
                }
            }
        }
        
        if(isPossible) {
            out.println("Yes");
            return;
        }
        
        out.println("No");
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