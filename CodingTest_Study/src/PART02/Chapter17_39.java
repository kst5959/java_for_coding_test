package PART02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node implements Comparable<Node> {

	private int x;
	private int y;
	private int distance;
	
	public Node(int x, int y, int distance) {
		this.x = x;
		this.y = y;
		this.distance = distance;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public int getDistance() {
		return this.distance;
	}
	
	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		if(this.distance < o.getDistance())
		{
			return -1;
		}
		return 1;
	}
	
}

public class Chapter17_39 {
	
	public static int INF = (int)1e9;
	public static int T;
	public static int N;
	public static int[][] graph = new int[126][126];
	public static int[][] d = new int[126][126];
	
	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	
	public static void dijkstra(int start) {
		
	}

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		//테스트케이스 입력
		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			
			//그래프 입력
			for (int a = 0; a < N; a++) {
				for (int b = 0; b < N; b++) {
					graph[a][b] = Integer.parseInt(null, br.read());
				}				
			}
			
			for (int j = 0; j < N; j++) {				
				Arrays.fill(d[i], INF);
			}
			
			int x = 0; int y = 0;
			PriorityQueue<Node> pq = new PriorityQueue<Node>();
			pq.offer(new Node(0 , 0, graph[x][y]));
			d[x][y] = graph[x][y];
			
			while(!pq.isEmpty())
			{
				Node node = pq.poll();
				x = node.getX();
				y = node.getY();
				int dist = node.getDistance();
				
				if(d[x][y] < dist) continue;
				
				for (int j = 0; j < 4; j++) {
					int nextX = x + dx[i];
					int nextY = y + dx[i];
					
					if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N)
					{
						continue;
					}
					int cost = dist + graph[nextX][nextY];
					if(cost < d[nextX][nextY])
					{
						d[nextX][nextY] = cost;
						pq.offer(new Node(nextX, nextY , cost));
					}
					
				}
				System.out.println(d[N-1][N-1]);
			}
			
			
		}
		
	}

}
