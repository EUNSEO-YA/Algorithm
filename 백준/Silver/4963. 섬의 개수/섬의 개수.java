import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
	static int w, h;
	static int[][] map;
	static int island;
	
	static boolean[][] visited;
	static int[][] delta = { {0, 1}, {1, 0}, {0, -1}, {-1, 0},
			{1, 1}, {1, -1}, {-1, 1}, {-1, -1} };

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if(w == 0 && h == 0) break;
			
			// 1은 땅, 0은 바다
			map = new int[h][w];
			for(int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			island = 0;
			visited = new boolean[h][w];
			
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					if(map[i][j] == 1 && !visited[i][j]) {
						island++;
						dfs(i, j);
					}
				}
			}
			sb.append(island).append("\n");
		}
		System.out.println(sb);
	}

	static void dfs(int x, int y) {
		visited[x][y] = true;
		
		for(int d = 0; d < 8; d++) {
			int nx = x + delta[d][0];
			int ny = y + delta[d][1];
			
			if(0 <= nx && nx < h && 0 <= ny && ny < w) {
				if(!visited[nx][ny] && map[nx][ny] == 1) {
					dfs(nx, ny);
				}
			}
		}
	}
}