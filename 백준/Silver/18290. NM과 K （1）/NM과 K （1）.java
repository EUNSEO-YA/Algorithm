import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, K;
	static List<Integer> result;
	
	static int[][] input;
	static boolean[][] selected;
	
	static int[][] delta = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };
	
	static int maxSum;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		input = new int[N][M];
		result = new ArrayList<>();
		selected = new boolean[N][M];
		maxSum = Integer.MIN_VALUE;
				
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0);
		
		System.out.println(maxSum);
	}
	
	static void dfs(int idx, int start) {
		if(idx == K) {
			int sum = 0;
			for(int i = 0; i < result.size(); i++) {
				sum += result.get(i);
			}
			
			maxSum = Math.max(sum,  maxSum);
			return;
		}
		
		for(int i = start; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(selected[i][j]) continue;
				
				boolean flag = true;
				for(int d = 0; d < 4; d++) {
					int nr = i + delta[d][0];
					int nc = j + delta[d][1];
					
					if(0 <= nr && nr < N && 0 <= nc && nc < M) {
						if(selected[nr][nc]) {
							flag = false;
						}
					}
				}
				
				if(flag) {
					selected[i][j] = true;
					result.add(input[i][j]);
					
					dfs(idx + 1, i);
					result.remove(result.size() - 1);
					
					selected[i][j] = false;
				}
			}
		}
	}
}