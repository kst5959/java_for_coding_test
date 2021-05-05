package PART02;

import java.util.*;
import java.lang.Comparable;

//class Node implements Comparable<Node> {
	private int index;
	private int distance;
	
	public Node(int index, int distance) {
		this.index = index;
		this.distance = distance;
	}
	
	public int getIndex() {
		return this.index;
	}
	
	public int getDistance() {
		return this.distance;
	}
	
	//거리가 짧은 값이 우선순위를 가지도록 설정
	@Override
	public int compareTo(Node other)
	{
		if(this.distance < other.distance)
		{
			return -1;
		}
		return 1;
	}
}

public class Chapeter9_03 {

	public static int INF = Integer.MAX_VALUE;
	 // 노드의 개수(N), 간선의 개수(M), 시작 노드 번호(Start)
    // 노드의 개수는 최대 100,000개라고 가정
	public static int n;
	public static int m;
	public static int start;
	//그래프
	public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	//최단거리 테이블
	public static int[] dist = new int[200001];
	
	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.offer(new Node(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty())
		{
			//거리가 짧은 노드의 정보 가져오기
			Node node = pq.poll();
			//현재 노드 까지의 비용
			int currentDistance = node.getDistance();
			int currentIndex = node.getIndex();
			
			//이미 처리된 적이 있는 노드인지 검사
			if(dist[currentIndex] < currentDistance)
			{
				continue;
			}
			//현재 노드와 연결된 다른 인접한 노드들을 확인
			for (int i = 0; i < graph.get(currentIndex).size(); i++) {
				int cost = dist[currentIndex] + graph.get(currentIndex).get(i).getDistance();
				//현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
				if(cost < dist[graph.get(currentIndex).get(i).getIndex()])
				{
					dist[graph.get(currentIndex).get(i).getIndex()] = cost;
					pq.offer(new Node(graph.get(currentIndex).get(i).getIndex(), cost));
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);

	        n = sc.nextInt();
	        m = sc.nextInt();
	        start = sc.nextInt();
	        
	        //System.out.println(start + "/" + dist.length);

	        // 그래프 초기화
	        for (int i = 0; i <= n; i++) {
	            graph.add(new ArrayList<Node>());
	        }
	        
	        // 모든 간선 정보를 입력받기
	        for (int i = 0; i < m; i++) {
	            int a = sc.nextInt();
	            int b = sc.nextInt();
	            int c = sc.nextInt();
	            // a번 노드에서 b번 노드로 가는 비용이 c라는 의미
	            graph.get(a).add(new Node(b, c));
	        }
	        
	        Arrays.fill(dist, INF);
	        dijkstra(start);
	        
	        int city = 0;
	        int time = 0;
	        
	        for (int i = 1; i <= n; i++) {
				if(dist[i] != INF)
				{
					city++;
					time = Math.max(time, dist[i]);
				}
				
			}
	        System.out.println(city-1 +" " + time);
	}

}
