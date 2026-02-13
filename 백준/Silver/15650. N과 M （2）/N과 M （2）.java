import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int result[];

	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		result = new int[M];

		dfs(0, 1);
		System.out.println(sb);
	}

	static void dfs(int cnt, int start) {
		if(cnt == M) {
			for(int i = 0; i < result.length; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = start; i <= N; i++) {
			result[cnt] = i;
			
			dfs(cnt + 1, i + 1);
		}
	}
}