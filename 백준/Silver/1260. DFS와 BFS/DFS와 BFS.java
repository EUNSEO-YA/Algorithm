import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner; // Scanner 임포트

public class Main {
    static int N, M, V; // 정점의 개수 N, 간선의 개수 M, 시작 정점 V
    static ArrayList<ArrayList<Integer>> graph; // 인접 리스트로 그래프 표현
    static boolean[] visitedDfs; // DFS 방문 여부
    static boolean[] visitedBfs; // BFS 방문 여부
    static StringBuilder dfsResult = new StringBuilder(); // DFS 결과 저장
    static StringBuilder bfsResult = new StringBuilder(); // BFS 결과 저장

    public static void main(String[] args) { // IOException 처리 필요 없음
        Scanner sc = new Scanner(System.in); // Scanner 객체 생성

        N = sc.nextInt(); // 정수 입력
        M = sc.nextInt();
        V = sc.nextInt();

        // 그래프 초기화 (1번부터 N번까지 사용하므로 N+1 크기로)
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 정보 입력받기
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            // 양방향 간선
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // 방문할 수 있는 정점이 여러 개인 경우 정점 번호가 작은 것을 먼저 방문하기 위해 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        // DFS 수행
        visitedDfs = new boolean[N + 1]; // 매 탐색마다 visited 배열 초기화
        dfs(V);
        dfsResult.append("\n"); // 줄바꿈

        // BFS 수행
        visitedBfs = new boolean[N + 1]; // 매 탐색마다 visited 배열 초기화
        bfs(V);

        // 결과 출력
        System.out.print(dfsResult.toString());
        System.out.print(bfsResult.toString());

        sc.close(); // Scanner 닫기
    }

    // DFS (깊이 우선 탐색)
    public static void dfs(int node) {
        visitedDfs[node] = true;
        dfsResult.append(node).append(" "); // 현재 노드 방문 기록

        // 현재 노드와 연결된 모든 노드 탐색
        for (int nextNode : graph.get(node)) {
            // 아직 방문하지 않은 노드라면 재귀 호출
            if (!visitedDfs[nextNode]) {
                dfs(nextNode);
            }
        }
    }

    // BFS (너비 우선 탐색)
    public static void bfs(int startNode) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(startNode);
        visitedBfs[startNode] = true;
        bfsResult.append(startNode).append(" "); // 시작 노드 방문 기록

        while (!queue.isEmpty()) {
            int currentNode = queue.poll(); // 큐에서 노드를 하나 꺼냄

            // 꺼낸 노드와 연결된 모든 노드 탐색
            for (int nextNode : graph.get(currentNode)) {
                // 아직 방문하지 않은 노드라면 큐에 추가하고 방문 처리
                if (!visitedBfs[nextNode]) {
                    visitedBfs[nextNode] = true;
                    queue.add(nextNode);
                    bfsResult.append(nextNode).append(" ");
                }
            }
        }
    }
}