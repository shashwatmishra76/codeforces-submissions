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
        int a = fs.nextInt();
        int b = fs.nextInt();
        
        int xk = fs.nextInt();
        int yk = fs.nextInt();
        int xq = fs.nextInt();
        int yq = fs.nextInt();
        
        int result = 0;
        
        Set<String> points = new HashSet<>();
        
        int[] dx = {a, -a, a, -a, b, -b, b, -b};
        int[] dy = {b, b, -b, -b, a, a, -a, -a};
        
        for(int i = 0; i < 8; i++) {
            int x = xk + dx[i];
            int y = yk + dy[i];
            points.add(x + "," + y);
        }
        
        //out.println(points);
        
        Set<String> pointsToBeMatched = new HashSet<>();
        
        for(int i = 0; i < 8; i++) {
            int x = xq + dx[i];
            int y = yq + dy[i];
            
            pointsToBeMatched.add(x + "," + y);
        }
        
        for(String point : pointsToBeMatched) {
            if(points.contains(point)) {
                result += 1;
            }
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