import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] P = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		int minTime = 0;
		
		Arrays.sort(P);
		
		int[] dp = new int[N];
		dp[0] = P[0];
		
		for(int i = 1; i < N; i++) {
			dp[i] = dp[i - 1] + P[i];
		}
		
		for(int i = 0; i < N; i++) {
			minTime += dp[i];
		}
		
		System.out.println(minTime);
	}

}