package PART02;

import java.util.*;

public class BOJ1260 {

	public static int N;
	public static int M;
	public static int V;
	
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	public static boolean[] isVisited = new boolean[1001];
	public static boolean[] visited = new boolean[1001];
	
	public static ArrayList<Integer> dfs_result = new ArrayList<Integer>();
	public static ArrayList<Integer> bfs_result = new ArrayList<Integer>();
	
	public static void initialize()
	{
		for (int i = 1; i <= N; i++) 
		{
			visited[i] = false;
			isVisited[i] = false;
		}
	}
	
	public static void dfs(int startX)
	{
		visited[startX] = true;
		for (int i = 0; i < graph.get(startX).size(); i++) 
		{
			int linkedNode = graph.get(startX).get(i);
			if(visited[linkedNode] == false)
			{
				dfs_result.add(linkedNode);
				dfs(linkedNode);
			}
		}
		
	}
	
	public static void bfs(int startX)
	{
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(startX);
		isVisited[startX] = true;
		
		while(!q.isEmpty())
		{
			int currentNode = q.poll();
			
			for (int i = 0; i < graph.get(currentNode).size(); i++) 
			{
				if(isVisited[graph.get(currentNode).get(i)] == false)
				{
					isVisited[graph.get(currentNode).get(i)] = true;
					q.offer(graph.get(currentNode).get(i));
					bfs_result.add(graph.get(currentNode).get(i));
				}
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();
		
		int value = Math.max(N, M);
		
		for (int i = 0; i <= value; i++) 
		{
			graph.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < M; i++) 
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		initialize();
		
		for (int i = 0; i <= M; i++) 
		{
			Collections.sort(graph.get(i));
		}
		
		dfs_result.add(V);
		dfs(V);
		
		bfs_result.add(V);
		bfs(V);
		
		
		for (int i = 0; i < dfs_result.size(); i++) 
		{
			System.out.print(dfs_result.get(i) + " ");
		}
		System.out.println();
		for (int i = 0; i < bfs_result.size(); i++) 
		{
			System.out.print(bfs_result.get(i) + " ");
		}
		
	}

}
