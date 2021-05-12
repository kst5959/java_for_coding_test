package PART02;

import java.util.*;

public class Chapter13_15 {

	//도시 개수, 도로 개수, 거리정보, 출발 도시 번호
	public static int N;
	public static int M;
	public static int K;
	public static int X;
	
	public static int INF = (int)1e9;
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	public static int[] d= new int[300001];
	
	
	public static void bfs()
	{
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(X);
		d[X] = 0;
		
		while(!q.isEmpty())
		{
			int node = q.poll();
			
			for (int i = 0; i < graph.get(node).size(); i++) 
			{
				int nextNode = graph.get(node).get(i);
				if(d[nextNode] == INF)
				{
					d[nextNode] = d[node] + 1; 
					q.offer(nextNode);
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		X = sc.nextInt();
		
		for (int i = 0; i <= N; i++) 
		{
			graph.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < M; i++) 
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			graph.get(a).add(b);
		}
		
		Arrays.fill(d, INF);
		
		bfs();
		
		boolean find = false;
		for (int i = 1; i <= N; i++) 
		{
			if(d[i] == K)
			{
				System.out.println(i);
				find = true;
			}
		}
	
		if(!find)
		{
			System.out.println(-1);
		}
	}

}
