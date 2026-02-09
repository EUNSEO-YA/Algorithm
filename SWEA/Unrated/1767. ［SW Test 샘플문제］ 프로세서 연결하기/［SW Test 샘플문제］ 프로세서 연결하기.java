import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int[][] maxinos;
	
	static int bestCnt, bestLen;
	static List<int[]> cores;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tN = 1; tN <= T; tN++) {
			sb.append("#" + tN + " ");
			
			N = Integer.parseInt(br.readLine());
			maxinos = new int[N][N];
			cores = new ArrayList<>();
			
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					maxinos[i][j] = Integer.parseInt(st.nextToken());
					if(maxinos[i][j] == 1) {
						if(i == 0 || i == N -1 || j == 0 || j == N - 1) continue;
						else {
							cores.add(new int[] {i, j});
						}
					}
				}
			}
			
			bestCnt = 0;
			bestLen = Integer.MAX_VALUE;
			
			dfs(0, 0, 0);
			
			sb.append(bestLen);
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void dfs(int idx, int cnt, int len) {
		if(cnt + (cores.size() - idx) < bestCnt) return;
		if(idx == cores.size()) {
			if(cnt > bestCnt) {
				bestCnt = cnt;
				bestLen = len;
			} else if(cnt == bestCnt) {
				bestLen = Math.min(bestLen, len);
			}
			return;
		}
		
		int r = cores.get(idx)[0];
		int c = cores.get(idx)[1];
		
		for(int d = 0; d < 4; d++) {
			int w = canConnect(r, c, d);
			if(w == 0) continue;
			
			int nr = r + dr[d];
			int nc = c + dc[d];
			while(0 <= nr && nr < N && 0 <= nc && nc < N) {
				maxinos[nr][nc] = 2;
				nr += dr[d];
				nc += dc[d];
			}
			
			dfs(idx + 1, cnt + 1, len + w);
			
			nr = r + dr[d];
			nc = c + dc[d];
			while(0 <= nr && nr < N && 0 <= nc && nc < N) {
				maxinos[nr][nc] = 0;
				nr += dr[d];
				nc += dc[d];
			}
		}
		
		dfs(idx + 1, cnt, len);
	}
	
	static int canConnect(int r, int c, int d) {
		int nr = r + dr[d];
		int nc = c + dc[d];
		
		int w = 0;
		
		while(0 <= nr && nr < N && 0 <= nc && nc < N) {
			if(maxinos[nr][nc] != 0) return 0;
			
			w++;
			nr += dr[d];
			nc += dc[d];
		}
		return w;
	}
}