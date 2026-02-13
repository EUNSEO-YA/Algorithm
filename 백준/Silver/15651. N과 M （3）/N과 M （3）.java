import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[] result;
	static boolean[] visited;
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		result = new int[M];
		visited = new boolean[N + 1];
		
		dfs(0);
		System.out.println(sb);
	}
	
	static void dfs(int depth) {
		if(depth == M) {
			for(int i = 0; i < result.length; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			result[depth] = i;
			
			dfs(depth + 1);
		}
	}
}