import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[] result;
	static boolean[] selected;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		result = new int[M];
		selected = new boolean[N + 1];
		
		dfs(0);
		
		System.out.println(sb);
	}
	
	static void dfs(int cnt) {
		
		// 1. 기저 조건
		if(cnt == M) {
			for(int i = 0; i < result.length; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		// 2. 재귀 유도
		for(int i = 1; i <= N; i++) {
			if(!selected[i]) {
				selected[i] = true;
				result[cnt] = i;
				
				dfs(cnt + 1);
				
				selected[i] = false;
			}
		}
		
	}
	
}