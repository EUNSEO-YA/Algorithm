import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

class Solution {
	
	static HashSet<Integer> set;
	static int[][] map;
	
	static int[][] delta = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			
			set = new HashSet<>();
			map = new int[4][4];
			
			for(int i = 0; i < 4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 4; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 4; j++) {
					dfs(i, j, 0, String.valueOf(map[i][j]));
				}
			}
			
			sb.append(set.size()).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void dfs(int x, int y, int cnt, String str) {
		if(cnt == 6) {
			set.add(Integer.valueOf(str));
			return;
		}
		
		for(int d = 0; d < 4; d++) {
			int nx = x + delta[d][0];
			int ny = y + delta[d][1];
			
			if(0 <= nx && nx < 4 && 0 <= ny && ny < 4) {
				dfs(nx, ny, cnt + 1, str + String.valueOf(map[nx][ny]));
			}
		}
	}
}