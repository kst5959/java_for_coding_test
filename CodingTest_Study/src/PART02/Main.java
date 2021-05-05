package PART02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//class Node implements Comparable<Node>{
	
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

	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		if (this.distance < o.getDistance()) {
			return -1;
		}
		return 1;
	}
}


public class Main {
	
	public static int INF = (int) 1e9;
	public static int N, M, K;
	
	public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	public static int[] d;
	public static int[][] r;
	
	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.offer(new Node(start, 0));
		d[start] = 0;
		
		int cnt = 0;
		while(!pq.isEmpty())
		{
			Node node = pq.poll();
			int dist = node.getDistance();
			int now = node.getIndex();
			
			if(d[now] < dist) continue;
			
			for (int i = 0; i < graph.get(now).size(); i++) {
				int cost = d[now] + graph.get(now).get(i).getDistance();				
				r[graph.get(now).get(i).getIndex()][cnt] = cost;
				cnt++;
				
				if (cost < d[graph.get(now).get(i).getIndex()]) {
					d[graph.get(now).get(i).getIndex()] = cost;
					pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
					if(r[graph.get(now).get(i).getIndex()][cnt-1] != cost)
					{
						r[graph.get(now).get(i).getIndex()][cnt] = cost;
						cnt++;						
					}
				}
				
			}
			
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		r = new int[N+1][M+1];
		d = new int[N+1];
		
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<Node>());
		}
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st1.nextToken());
			int b = Integer.parseInt(st1.nextToken());
			int c = Integer.parseInt(st1.nextToken());
			
			graph.get(a).add(new Node(b, c));
		}
		
		Arrays.fill(d, INF);
		
		dijkstra(1);
		
		int temp = -1;
		for (int i = 1; i <= N; i++) {			
			for (int j = 0; j < r[i].length; j++) {
				if(r[i][j] > d[i])
				{
					temp = r[i][j];
					break;
				}
			}
			System.out.println(temp);
		}
	}

}

