import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

	static int n, m;
	static int answer;
	static ArrayList<Integer>[] graph;
	static Queue<Integer> queue;
	
	static int p1, p2;
	static int[] dist;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		p1 = Integer.parseInt(st.nextToken());
		p2 = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[n + 1];
		for(int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		
		answer = -1;
		dist = new int[n + 1];
		Arrays.fill(dist, -1);
		
		m = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			graph[x].add(y);
			graph[y].add(x);
		}
		
		queue = new LinkedList<>();
		queue.add(p1);
		dist[p1] = 0;
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			
			if(curr == p2) break;
			
			for(int next : graph[curr]) {
				if(dist[next] == -1) {
					dist[next] = dist[curr] + 1;
					queue.add(next);
				}
			}
		}
		
		answer = dist[p2];
		
		System.out.println(answer);
	}
}