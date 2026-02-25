import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			int[] dp = new int[12];
			dp[1] = 1;
			dp[2] = 2;
			dp[3] = 4;
			
			for(int i = 4; i <= n; i++) {
				dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
			}
			
			sb.append(dp[n]).append("\n");
		}
		
		System.out.println(sb);
	}
}