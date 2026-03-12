import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	
	static int N;
	static List<Integer>[] graph;
	static boolean[] visited;
	
	static int[] answer;
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		graph = new ArrayList[N + 1];
		
		for(int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i = 1; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
			graph[b].add(a);
		}
		
		for(int i = 1; i <= N; i++) {
			Collections.sort(graph[i]);
		}
		
		visited = new boolean[N + 1];
		answer = new int[N + 1];
		bfs(1);
		
		for(int i = 2; i <= N; i++) {
			sb.append(answer[i]).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int i = 0; i < graph[now].size(); i++) {
				int num = graph[now].get(i);
				if(!visited[num] && answer[num] == 0) {
					q.offer(num);
					visited[num] = true;
					answer[num] = now;
				}
			}
		}
		
	}

}