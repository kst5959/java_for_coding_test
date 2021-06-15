package PART02;

import java.util.*;

public class BOJ11725 {

	public static int N;
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	public static int[] parent = new int[100001];
	
	public static void bfs(int x)
	{
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(x);
		
		while(!q.isEmpty())
		{
			int currentNode = q.poll();
			
			for (int i = 0; i < graph.get(currentNode).size(); i++) 
			{
				if(parent[graph.get(currentNode).get(i)] == Integer.MAX_VALUE)
				{
					//System.out.println("현재 노드 : " + currentNode + " 현재 노드와 연결된 노드  : " + graph.get(currentNode).get(i));
					parent[graph.get(currentNode).get(i)] = currentNode;
					q.offer(graph.get(currentNode).get(i));
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		for (int i = 0; i <= N; i++) 
		{
			graph.add(new ArrayList<Integer>());
		}
		
		for (int i = 1; i <= (N-1); i++) 
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		for (int i = 0; i <= N; i++) 
		{
			parent[i] = Integer.MAX_VALUE;
		}
		
		for (int i = 0; i <= N; i++) 
		{
			Collections.sort(graph.get(i));			
		}
		
		parent[1] = 1;
		bfs(1);						
		
		for (int i = 2; i <= N; i++) 
		{
			System.out.println(parent[i]);
		}
	}

}
