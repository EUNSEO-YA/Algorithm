import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	
	static int N, M, V;
	static boolean[] visited;
	
	static ArrayList<Integer>[] graph;
	static StringBuilder sb = new StringBuilder();
	
	static Queue<int[]> queue;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N + 1];
		for(int i = 0; i <=N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		visited = new boolean[N + 1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
			graph[b].add(a);
		}
		
		for(int i = 0; i < graph.length; i++) {
			Collections.sort(graph[i]);
		}
		
		dfs(V);
		
		sb.append("\n");
		
		visited = new boolean[N + 1];
		queue = new LinkedList<>();
		
		bfs(V);
		System.out.println(sb);
	}

	static void dfs(int idx) {
		visited[idx] = true;
		sb.append(idx).append(" ");
		
		for(int i = 0; i < graph[idx].size(); i++) {
			int n = graph[idx].get(i);
			if(!visited[n]) {
				visited[n] = true;
				dfs(n);
			}
		}
	}
	
	static void bfs(int idx) {
		visited[idx] = true;
		sb.append(idx).append(" ");
		
		for(int i = 0; i < graph[idx].size(); i++) {
			int n = graph[idx].get(i);
			if(!visited[n]) {
				queue.add(new int[] {idx, n});
			}
		}
		
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			int a = temp[0];
			int b = temp[1];
			
			if(!visited[b]) {
				bfs(b);
			}
		}
	}
}