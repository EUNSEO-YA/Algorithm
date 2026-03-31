import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	
	static int[][] delta = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
	static int r, c;
	static int[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new int[r][c];

		for(int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < c; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());				
			}
		}
		
		int time = 0;
		int lastCount = 0;
		
		while(true) {
			visited = new boolean[r][c];
			Queue<int[]> queue = new LinkedList<>();
			Queue<int[]> melt = new LinkedList<>();
			
			queue.offer(new int[] {0, 0});
			visited[0][0] = true;
			
			while(!queue.isEmpty()) {
				int[] cur = queue.poll();
				int cx = cur[0];
				int cy = cur[1];
				
				for(int d = 0; d < 4; d++) {
					int nx = cx + delta[d][0];
					int ny = cy + delta[d][1];
					
					if(0 <= nx && nx < r && 0 <= ny && ny < c) {
						if(!visited[nx][ny]) {
							visited[nx][ny] = true;
							
							if(map[nx][ny] == 0) {
								queue.offer(new int[] {nx, ny});
							} else if(map[nx][ny] == 1) {
								melt.offer(new int[] {nx, ny});
							}
						}
					}
				}
			}
			
			if(melt.isEmpty()) break;
			
			lastCount = melt.size();
			
			while(!melt.isEmpty()) {
				int[] cur = melt.poll();
				map[cur[0]][cur[1]] = 0;
			}
			
			time++;
		}
		
		sb.append(time).append("\n").append(lastCount);
        System.out.println(sb);
	}
}